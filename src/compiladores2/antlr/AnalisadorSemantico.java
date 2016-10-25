package compiladores2.antlr;

import compiladores2.ASemantico.PilhaDeTabelas;
import compiladores2.ASemantico.TabelaDeSimbolos;

/**
 * Created by lucas on 24/10/16.
 */
public class AnalisadorSemantico extends GrammarLABaseVisitor<String> {

    private PilhaDeTabelas pt;

    @Override
    public String visitPrograma(GrammarLAParser.ProgramaContext ctx) {
        //criação escopo global
        pt = new PilhaDeTabelas();
        pt.empilhar(new TabelaDeSimbolos("global"));

        visitDeclaracoes(ctx.declaracoes());
        visitCorpo(ctx.corpo());
        System.out.println("Fim da compilacao");
        return null;
    }

    @Override
    public String visitDeclaracoes(GrammarLAParser.DeclaracoesContext ctx) {
        if(ctx !=  null){
            visitDecl_local_global(ctx.decl_local_global());
            visitDeclaracoes(ctx.declaracoes());
        }
        return null;
    }

    @Override
    public String visitCorpo(GrammarLAParser.CorpoContext ctx) {
        if(ctx.declaracoes_locais() != null){
            visitDeclaracoes_locais(ctx.declaracoes_locais());
        }
        if(ctx.comandos() != null){
            //TODO implementar visitor comandos
            visitComandos(ctx.comandos());
        }
        return null;
    }

    @Override
    public String visitComandos(GrammarLAParser.ComandosContext ctx) {
        if (ctx != null){
            visitCmd(ctx.cmd());
            visitComandos(ctx.comandos());
        }
        return null;
    }

    @Override
    public String visitCmd(GrammarLAParser.CmdContext ctx) {
        if(ctx != null){
            switch (ctx.getStart().getText()){
                case "leia(":
                    visitIdentificador(ctx.identificador());
                    //TODO implementar mais_ident depois
                    visitMais_ident(ctx.mais_ident());
                    break;
                case "escreva(":
                    //Todo implementar escreva
                    break;
                case "se":
                    //TODO implementar se
                    break;
                case "para":
                    break;
                case "enquanto":
                    break;
                case "faca":
                    break;
                case "^":
                    break;
                case "retorne":
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitIdentificador(GrammarLAParser.IdentificadorContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();
        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())) {
            System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
        }
        return null;
    }

    @Override
    public String visitDeclaracoes_locais(GrammarLAParser.Declaracoes_locaisContext ctx) {
        if(ctx != null){
            if(ctx.declaracao_local() != null){
                visitDeclaracao_local(ctx.declaracao_local());
            }
            visitDeclaracoes_locais(ctx.declaracoes_locais());
        }
        return null;
    }

    @Override
    public String visitDecl_local_global(GrammarLAParser.Decl_local_globalContext ctx) {
        if(ctx != null){
            if(ctx.declaracao_local() != null){
                visitDeclaracao_local(ctx.declaracao_local());
            }else{
                visitDeclaracao_global(ctx.declaracao_global());
            }
        }
        return null;
    }

    @Override
    public String visitDeclaracao_local(GrammarLAParser.Declaracao_localContext ctx) {
        if(ctx.variavel() != null){
            visitVariavel(ctx.variavel());
        }else{
            TabelaDeSimbolos escopoAtual = pt.topo();
            //TODO terminar verificação caso const ou tipo
        }

        return null;
    }

    @Override
    public String visitVariavel(GrammarLAParser.VariavelContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();

        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
            escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo(ctx.tipo()));
        }else{
            System.out.println("Erro, já existe declarado uma variável com esse nome: "+ctx.IDENT().toString());
        }

        //declara todas as mais_var com o tipo definido
        GrammarLAParser.Mais_varContext m = ctx.mais_var();
        while (m.children != null){
            if(!escopoAtual.existeSimbolo(visitMais_var(m))){
                escopoAtual.adicionarSimbolo(m.IDENT().toString(), visitTipo(ctx.tipo()));
            }else{
                System.out.println("Erro, já existe declarado uma variável com esse nome: "+m.IDENT().toString());
            }
            m = m.mais_var();
        }

        return null;
    }

    @Override
    public String visitMais_var(GrammarLAParser.Mais_varContext ctx) {
        return (ctx != null)? ctx.IDENT().toString() : null;
    }

    @Override
    public String visitTipo(GrammarLAParser.TipoContext ctx) {
        if(ctx.registro() != null){
           return visitRegistro(ctx.registro());
        }else{
           return visitTipo_estendido(ctx.tipo_estendido());
        }
    }


    @Override
    public String visitTipo_estendido(GrammarLAParser.Tipo_estendidoContext ctx) {
        if(ctx.ponteiros_opcionais() != null){
            visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        }

        return visitTipo_basico_ident(ctx.tipo_basico_ident());
    }


    @Override
    public String visitTipo_basico_ident(GrammarLAParser.Tipo_basico_identContext ctx) {
        //eh um tipo básico
        if(ctx.tipo_basico() != null){
            return visitTipo_basico(ctx.tipo_basico());
        //eh um tipo criado (declaracao de tipo)
        }else{
            TabelaDeSimbolos escopoAtual = pt.topo();
            //se o Tipo existe na tabela de símbolos ou seja, se o simbolo ja foi declarado
            if(escopoAtual.existeSimbolo(ctx.IDENT().toString())){
                //TODO remover println
                System.out.println("Esse tipo existe! "+ctx.IDENT().toString());
                return ctx.IDENT().toString();
            }else{
                //TODO melhorar mensagem de saida
                System.out.println("Linha "+ctx.getStart().getLine()+": tipo "+ctx.IDENT().toString()+" nao declarado");
                return null;
            }
        }
    }

    @Override
    public String visitTipo_basico(GrammarLAParser.Tipo_basicoContext ctx) {
        if(ctx.getText().equals("literal") || ctx.getText().equals("inteiro")
            || ctx.getText().equals("real") || ctx.getText().equals("logico")){
            return ctx.getText();
        }else{
            //TODO melhorar mensagem de saida
            System.out.println("Erro, tipo declarado não compatível com tipo básico");
            return null;
        }
    }

    @Override
    public String visitPonteiros_opcionais(GrammarLAParser.Ponteiros_opcionaisContext ctx) {
        return super.visitPonteiros_opcionais(ctx);
    }

    @Override
    public String visitRegistro(GrammarLAParser.RegistroContext ctx) {
        //TODO implementar registo
        return "teste";

    }









}
