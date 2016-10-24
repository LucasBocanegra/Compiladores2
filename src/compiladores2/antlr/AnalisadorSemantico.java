package compiladores2.antlr;

import compiladores2.ASemantico.PilhaDeTabelas;
import compiladores2.ASemantico.TabelaDeSimbolos;

/**
 * Created by lucas on 24/10/16.
 */
public class AnalisadorSemantico extends GrammarLABaseVisitor<String> {

    //criação do escopo global
    PilhaDeTabelas pt = new PilhaDeTabelas();

    @Override
    public String visitPrograma(GrammarLAParser.ProgramaContext ctx) {
            visitDeclaracoes(ctx.declaracoes());
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
    public String visitDecl_local_global(GrammarLAParser.Decl_local_globalContext ctx) {
        if(ctx.declaracao_local() != null){
            visitDeclaracao_local(ctx.declaracao_local());
        }else{
            visitDeclaracao_global(ctx.declaracao_global());
        }
        return null;
    }

    @Override
    public String visitDeclaracao_local(GrammarLAParser.Declaracao_localContext ctx) {
        if(ctx.variavel() != null){
            visitVariavel(ctx.variavel());
        }else{
            TabelaDeSimbolos escopoAtual = pt.topo();
//            escopoAtual.adicionarSimbolo();
            //TODO terminar verificação caso const ou tipo
        }

        return null;
    }

    @Override
    public String visitVariavel(GrammarLAParser.VariavelContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();
        escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo(ctx.tipo()));
        return super.visitVariavel(ctx);
    }

    @Override
    public String visitTipo(GrammarLAParser.TipoContext ctx) {
        if(ctx.registro() != null){
            visitRegistro(ctx.registro());
        }else{
            visitTipo_estendido(ctx.tipo_estendido());
        }
    }


    @Override
    public String visitTipo_estendido(GrammarLAParser.Tipo_estendidoContext ctx) {
        if(ctx.ponteiros_opcionais() != null){
            visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        }else{
            visitTipo_basico_ident(ctx.tipo_basico_ident());
        }

        return  null;
    }


    @Override
    public String visitTipo_basico_ident(GrammarLAParser.Tipo_basico_identContext ctx) {
        if(ctx.IDENT() != null){
            TabelaDeSimbolos escopoAtual = pt.topo();
            if(escopoAtual.existeSimboloComTipo(ctx.IDENT().toString(), "tipo")){
                //TODO remover println
                System.out.println("Esse tipo existe! "+ctx.IDENT().toString());
                return ctx.IDENT().toString();
            }else{
                //TODO melhorar mensagem de saida
                System.out.println("Linha com erro"+ctx.IDENT().toString());
            }
        }else{
           return visitTipo_basico(ctx.tipo_basico());
        }
    }

    @Override
    public String visitTipo_basico(GrammarLAParser.Tipo_basicoContext ctx) {
        if(ctx.toString().equals("literal") || ctx.toString().equals("inteiro")
            || ctx.toString().equals("real") || ctx.toString().equals("logico")){

            return ctx.toString();
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

    @Override
    public String visitMais_var(GrammarLAParser.Mais_varContext ctx) {
        return super.visitMais_var(ctx);
    }







}
