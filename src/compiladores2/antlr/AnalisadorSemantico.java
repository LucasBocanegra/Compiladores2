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
        if(ctx.children !=  null){
            visitDecl_local_global(ctx.decl_local_global());
            visitDeclaracoes(ctx.declaracoes());
        }
        return null;
    }

    @Override
    public String visitDecl_local_global(GrammarLAParser.Decl_local_globalContext ctx) {
        if(ctx.children != null){
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
        if(ctx.children != null) {
            TabelaDeSimbolos escopoAtual = pt.topo();
            switch (ctx.dLocal) {
                case 0:
                    visitVariavel(ctx.variavel());
                    break;
                case 1:
                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
                        escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo_basico(ctx.tipo_basico()));
                    }else{
                        System.out.println("Linha "+ ctx.getStart().getLine() +": identificador "+ ctx.IDENT().toString() +" ja declarado anteriormente ");
                    }
                    visitValor_constante(ctx.valor_constante());
                    break;
                case 2:
                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
                        escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo(ctx.tipo()));
                    }else{
                        System.out.println("Linha "+ ctx.getStart().getLine() +": identificador "+ ctx.IDENT().toString() +" ja declarado anteriormente ");
                    }
                    break;
                default:
                    break;
            }
        }
        return null;
        /* FEITO PELO BOCA
        if(ctx.variavel() != null){
            visitVariavel(ctx.variavel());
        }else{
            TabelaDeSimbolos escopoAtual = pt.topo();
            //TODO terminar verificação caso const ou tipo
        }*/
    }

    @Override
    public String visitVariavel(GrammarLAParser.VariavelContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();

        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
            escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo(ctx.tipo()));
        }else{
            System.out.println("Linha "+ ctx.getStart().getLine() +": identificador "+ ctx.IDENT().toString() +" ja declarado anteriormente ");
        }

        //declara todas as mais_var com o tipo definido
        GrammarLAParser.Mais_varContext m = ctx.mais_var();
        while (m.children != null){
            if(!escopoAtual.existeSimbolo(visitMais_var(m))){
                escopoAtual.adicionarSimbolo(m.IDENT().toString(), visitTipo(ctx.tipo()));
            }else{
                System.out.println("Linha "+ m.getStart().getLine() +": identificador "+ m.IDENT().toString() +" ja declarado anteriormente ");
            }
            m = m.mais_var();
        }
        //visitDimensao(ctx.dimensao());

        return null;
    }

    @Override
    public String visitMais_var(GrammarLAParser.Mais_varContext ctx) {
        /* Acho que toda a volta que vcs fizeram em variavel pra
         * verificar se existia mais_var declarada poderia ter sido
         * feito aqui... */
        /*Não por que eu nao sei o tipo da variáveil em mais var*/


        return (ctx != null)? ctx.IDENT().toString() : null;
    }

    @Override
    public String visitIdentificador(GrammarLAParser.IdentificadorContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();
        visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())) {
            System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
        }
        visitDimensao(ctx.dimensao());
        visitOutros_ident(ctx.outros_ident());
        return null;
    }

    @Override
    public String visitPonteiros_opcionais(GrammarLAParser.Ponteiros_opcionaisContext ctx) {
        if(ctx.children != null){
            visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        }
        return null;
    }

    @Override
    public String visitOutros_ident(GrammarLAParser.Outros_identContext ctx) {
        if(ctx.children != null){
            visitIdentificador(ctx.identificador());
        }
        return null;
    }

    @Override
    public String visitDimensao(GrammarLAParser.DimensaoContext ctx) {
        if(ctx.children != null){
            visitExp_aritmetica(ctx.exp_aritmetica());
            visitDimensao(ctx.dimensao());
        }
        return null;
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
    public String visitMais_ident(GrammarLAParser.Mais_identContext ctx) {
        if(ctx.children != null){
            visitIdentificador(ctx.identificador());
            visitMais_ident(ctx.mais_ident());
        }
        return null;
    }

    @Override
    public String visitMais_variaveis(GrammarLAParser.Mais_variaveisContext ctx) {
        if(ctx.children != null){
            visitVariavel(ctx.variavel());
            visitMais_variaveis(ctx.mais_variaveis());
        }
        return null;
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
    public String visitTipo_estendido(GrammarLAParser.Tipo_estendidoContext ctx) {
        if(ctx.ponteiros_opcionais() != null){
            visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        }

        return visitTipo_basico_ident(ctx.tipo_basico_ident());
    }

    @Override
    public String visitValor_constante(GrammarLAParser.Valor_constanteContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitRegistro(GrammarLAParser.RegistroContext ctx) {
        //TODO implementar registo
        visitVariavel(ctx.variavel());
        visitMais_variaveis(ctx.mais_variaveis());
        return null;

    }
    //TODO: Parei aqui, falta conferir o que eu ja fiz e continuar.
    @Override
    public String visitDeclaracao_global(GrammarLAParser.Declaracao_globalContext ctx) {
        return super.visitDeclaracao_global(ctx);
    }

    @Override
    public String visitParametros_opcional(GrammarLAParser.Parametros_opcionalContext ctx) {
        return super.visitParametros_opcional(ctx);
    }

    @Override
    public String visitParametro(GrammarLAParser.ParametroContext ctx) {
        return super.visitParametro(ctx);
    }

    @Override
    public String visitVar_opcional(GrammarLAParser.Var_opcionalContext ctx) {
        return super.visitVar_opcional(ctx);
    }

    @Override
    public String visitMais_parametros(GrammarLAParser.Mais_parametrosContext ctx) {
        return super.visitMais_parametros(ctx);
    }

    @Override
    public String visitDeclaracoes_locais(GrammarLAParser.Declaracoes_locaisContext ctx) {
        if(ctx.children != null){
            if(ctx.declaracao_local() != null){
                visitDeclaracao_local(ctx.declaracao_local());
            }
            visitDeclaracoes_locais(ctx.declaracoes_locais());
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
        if (ctx.children != null){
            visitCmd(ctx.cmd());
            visitComandos(ctx.comandos());
        }
        return null;
    }

    @Override
    public String visitCmd(GrammarLAParser.CmdContext ctx) {
        if(ctx != null){
            switch(ctx.tipoCmd) {
                case 0:
                    visitIdentificador(ctx.identificador());
                    //TODO implementar mais_ident depois
                    visitMais_ident(ctx.mais_ident());
                    break;
                case 1:
                    visitExpressao(ctx.expressao());
                    visitMais_expressao(ctx.mais_expressao());
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    //Todo armazenar IDENT
                    visitChamada_atribuicao(ctx.chamada_atribuicao());
                    break;
                default:
                    break;
            }
        }
        return null;
    }


    @Override
    public String visitMais_expressao(GrammarLAParser.Mais_expressaoContext ctx) {
        if(ctx.children != null){
            visitExpressao(ctx.expressao());
            visitMais_expressao(ctx.mais_expressao());
        }
        return null;
    }

    @Override
    public String visitSenao_opcional(GrammarLAParser.Senao_opcionalContext ctx) {
        return super.visitSenao_opcional(ctx);
    }

    @Override
    public String visitChamada_atribuicao(GrammarLAParser.Chamada_atribuicaoContext ctx) {
        visitExpressao(ctx.expressao());
        return null;
    }

    @Override
    public String visitArgumentos_opcional(GrammarLAParser.Argumentos_opcionalContext ctx) {
        return super.visitArgumentos_opcional(ctx);
    }

    @Override
    public String visitSelecao(GrammarLAParser.SelecaoContext ctx) {
        return super.visitSelecao(ctx);
    }

    @Override
    public String visitMais_selecao(GrammarLAParser.Mais_selecaoContext ctx) {
        return super.visitMais_selecao(ctx);
    }

    @Override
    public String visitConstantes(GrammarLAParser.ConstantesContext ctx) {
        return super.visitConstantes(ctx);
    }

    @Override
    public String visitMais_constantes(GrammarLAParser.Mais_constantesContext ctx) {
        return super.visitMais_constantes(ctx);
    }

    @Override
    public String visitNumero_intervalo(GrammarLAParser.Numero_intervaloContext ctx) {
        return super.visitNumero_intervalo(ctx);
    }

    @Override
    public String visitIntervalo_opcional(GrammarLAParser.Intervalo_opcionalContext ctx) {
        return super.visitIntervalo_opcional(ctx);
    }

    @Override
    public String visitOp_unario(GrammarLAParser.Op_unarioContext ctx) {
        if(ctx.children != null){
            if(ctx.getText().equals("-")){
                return ctx.getText();
            }
            else{
                return null;
            }
        }
        return null;
    }

    @Override
    public String visitExpressao(GrammarLAParser.ExpressaoContext ctx) {

        visitTermo_logico(ctx.termo_logico());
        visitOutros_termos_logicos(ctx.outros_termos_logicos());
        return null;
    }

    @Override
    public String visitExp_aritmetica(GrammarLAParser.Exp_aritmeticaContext ctx) {
        visitTermo(ctx.termo());
        visitOutros_termos(ctx.outros_termos());
        return null;
    }

    @Override
    public String visitOp_multiplicacao(GrammarLAParser.Op_multiplicacaoContext ctx) {
        return super.visitOp_multiplicacao(ctx);
    }

    @Override
    public String visitOp_adicao(GrammarLAParser.Op_adicaoContext ctx) {

        if(ctx.children != null){
            if(ctx.getText().equals("+") || ctx.getText().equals("-")){
                return ctx.getText();
            }
            else{
                return null;
            }
        }

        return null;
    }

    @Override
    public String visitTermo(GrammarLAParser.TermoContext ctx) {
        visitFator(ctx.fator());
        visitOutros_fatores(ctx.outros_fatores());
        return null;
    }

    @Override
    public String visitOutros_termos(GrammarLAParser.Outros_termosContext ctx) {
        if(ctx.children != null){
            if(ctx.op_adicao() != null){
                visitOp_adicao(ctx.op_adicao());
                visitTermo(ctx.termo());
                visitOutros_termos(ctx.outros_termos());
            }else{
                return null;
            }
        }


        return null;
    }

    @Override
    public String visitFator(GrammarLAParser.FatorContext ctx) {
        visitParcela(ctx.parcela());
        visitOutras_parcelas(ctx.outras_parcelas());
        return null;
    }

    @Override
    public String visitOutros_fatores(GrammarLAParser.Outros_fatoresContext ctx) {
        if(ctx.children != null){
            if(ctx.op_multiplicacao() != null){
                visitOp_multiplicacao(ctx.op_multiplicacao());
                visitFator(ctx.fator());
            }else{
                return null;
            }
        }
        return super.visitOutros_fatores(ctx);
    }

    @Override
    public String visitParcela(GrammarLAParser.ParcelaContext ctx) {
        if(ctx.children != null) {
            if (ctx.parcela_nao_unario() == null) {
                visitOp_unario(ctx.op_unario());
                visitParcela_unario(ctx.parcela_unario());
            } else {
                visitParcela_nao_unario(ctx.parcela_nao_unario());
            }
        }
        return null;
    }

    @Override
    public String visitParcela_unario(GrammarLAParser.Parcela_unarioContext ctx) {
        if(ctx.children != null){
            TabelaDeSimbolos escopoAtual = pt.topo();
            switch (ctx.tipoParcela){
                case 0:
                    visitOutros_ident(ctx.outros_ident());
                    visitDimensao(ctx.dimensao());
                    break;
                case 1:
                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())) {
                        System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
                    }
                    visitChamada_partes(ctx.chamada_partes());
                    break;
                case 2:
                    System.out.println("cheguei aqui" + ctx.NUM_INT().toString() +" " +ctx.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getText() );
                    GrammarLAParser.Parcela_unarioContext m = ctx;
                    //return "inteiro";
                break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitParcela_nao_unario(GrammarLAParser.Parcela_nao_unarioContext ctx) {
        return super.visitParcela_nao_unario(ctx);
    }

    @Override
    public String visitOutras_parcelas(GrammarLAParser.Outras_parcelasContext ctx) {
        if(ctx.children != null){
            if(ctx.parcela() != null) {
                visitParcela(ctx.parcela());
                visitOutras_parcelas(ctx.outras_parcelas());
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public String visitChamada_partes(GrammarLAParser.Chamada_partesContext ctx) {
        if(ctx.children != null){
            if(ctx.expressao() != null){
                visitExpressao(ctx.expressao());
                visitMais_expressao(ctx.mais_expressao());
            }
            else if(ctx.outros_ident() != null){
                visitOutros_ident(ctx.outros_ident());
                visitDimensao(ctx.dimensao());
            }
            else{
                return null;
            }
        }
        return null;
    }

    @Override
    public String visitExp_relacional(GrammarLAParser.Exp_relacionalContext ctx) {
        visitExp_aritmetica(ctx.exp_aritmetica());
        visitOp_opcional(ctx.op_opcional());
        return null;
    }

    @Override
    public String visitOp_opcional(GrammarLAParser.Op_opcionalContext ctx) {
        if(ctx.children != null){
            if(ctx.op_relacional() != null){
                visitOp_relacional(ctx.op_relacional());
                visitExp_aritmetica(ctx.exp_aritmetica());
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public String visitOp_relacional(GrammarLAParser.Op_relacionalContext ctx) {
        return super.visitOp_relacional(ctx);
    }

    @Override
    public String visitOp_nao(GrammarLAParser.Op_naoContext ctx) {
        if(ctx.children != null){
            if(ctx.getText().equals("nao")){
                return ctx.getText();
            }
        }
        return null;
    }

    @Override
    public String visitTermo_logico(GrammarLAParser.Termo_logicoContext ctx) {
        visitFator_logico(ctx.fator_logico());
        visitOutros_fatores_logicos(ctx.outros_fatores_logicos());
        return null;
    }

    @Override
    public String visitOutros_termos_logicos(GrammarLAParser.Outros_termos_logicosContext ctx) {
        if(ctx.children != null) {
            visitTermo_logico(ctx.termo_logico());
            visitOutros_termos_logicos(ctx.outros_termos_logicos());
        }
        return null;
    }

    @Override
    public String visitOutros_fatores_logicos(GrammarLAParser.Outros_fatores_logicosContext ctx) {
        return super.visitOutros_fatores_logicos(ctx);
    }

    @Override
    public String visitFator_logico(GrammarLAParser.Fator_logicoContext ctx) {
        visitOp_nao(ctx.op_nao());
        visitParcela_logica(ctx.parcela_logica());
        return null;
    }

    @Override
    public String visitParcela_logica(GrammarLAParser.Parcela_logicaContext ctx) {
        if(ctx.exp_relacional() != null){
            visitExp_relacional(ctx.exp_relacional());
        }
        return null;
    }
}
