package compiladores2.antlr;

import compiladores2.ASemantico.PilhaDeTabelas;
import compiladores2.ASemantico.TabelaDeSimbolos;

/**
 * Created by Gabriel Palomino on 10/31/2016.
 */
public class GeradorCodigo extends GrammarLABaseVisitor<String>{

    private PilhaDeTabelas pt;

    @Override
    public String visitPrograma(GrammarLAParser.ProgramaContext ctx) {
        System.out.println("#include <stdio.h>\n" +
                "#include <stdlib.h>\n"
        );

        pt = new PilhaDeTabelas();
        pt.empilhar(new TabelaDeSimbolos("global"));

        visitDeclaracoes(ctx.declaracoes());

        System.out.println("int main() {");

        visitCorpo(ctx.corpo());

        System.out.println("\treturn 0;\n}");
        return null;
    }

    @Override
    public String visitDeclaracoes(GrammarLAParser.DeclaracoesContext ctx) {
        if(ctx != null){
            visitDecl_local_global(ctx.decl_local_global());
            visitDeclaracoes(ctx.declaracoes());
        }
        return null;
    }

    @Override
    public String visitDecl_local_global(GrammarLAParser.Decl_local_globalContext ctx) {
        if(ctx != null){
            if(ctx.declaracao_local() != null){
                visitDeclaracao_local(ctx.declaracao_local());
            } else{
                visitDeclaracao_global(ctx.declaracao_global());
            }
        }
        return null;
    }

    @Override
    public String visitDeclaracao_local(GrammarLAParser.Declaracao_localContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();
        if(ctx != null) {
            switch (ctx.dLocal) {
                case 0:
                    visitVariavel(ctx.variavel());
                    break;
                case 1:
                    //TODO: Falta implementar
                    // visitValor_constante(ctx.valor_constante());
                    break;
                case 2:
                    //TODO: Falta implementar
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitVariavel(GrammarLAParser.VariavelContext ctx) {
        System.out.print("\t" + visitTipo(ctx.tipo())+" ");
        System.out.print(ctx.IDENT());
        visitDimensao(ctx.dimensao());
        visitMais_var(ctx.mais_var());
        System.out.println(";");

        // Coloca na tabela de simbolos
        TabelaDeSimbolos escopoAtual = pt.topo();
        escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo(ctx.tipo()));
        return null;
    }

    @Override
    public String visitMais_var(GrammarLAParser.Mais_varContext ctx) {
        return super.visitMais_var(ctx);
    }

    @Override
    public String visitIdentificador(GrammarLAParser.IdentificadorContext ctx) {
        return super.visitIdentificador(ctx);
    }

    @Override
    public String visitPonteiros_opcionais(GrammarLAParser.Ponteiros_opcionaisContext ctx) {
        return super.visitPonteiros_opcionais(ctx);
    }

    @Override
    public String visitOutros_ident(GrammarLAParser.Outros_identContext ctx) {
        return super.visitOutros_ident(ctx);
    }

    @Override
    public String visitDimensao(GrammarLAParser.DimensaoContext ctx) {
        return super.visitDimensao(ctx);
    }

    @Override
    public String visitTipo(GrammarLAParser.TipoContext ctx) {
        if(ctx.registro() != null){
            //TODO: Falta implementar registro
        } else{
            return visitTipo_estendido(ctx.tipo_estendido());
        }
        return null;
    }

    @Override
    public String visitMais_ident(GrammarLAParser.Mais_identContext ctx) {
        return super.visitMais_ident(ctx);
    }

    @Override
    public String visitMais_variaveis(GrammarLAParser.Mais_variaveisContext ctx) {
        return super.visitMais_variaveis(ctx);
    }

    @Override
    public String visitTipo_basico(GrammarLAParser.Tipo_basicoContext ctx) {
        if(ctx.getText().equals("literal")){
            //System.out.print("char ");
            return "char";
        } else if (ctx.getText().equals("inteiro")){
            //System.out.print("int ");
            return "int";
        } else if (ctx.getText().equals("real")){
            //System.out.print("float ");
            return "float";
        } else if (ctx.getText().equals("logico")){
            //System.out.print("int ");
            return "int";
        }
        return null;
    }

    @Override
    public String visitTipo_basico_ident(GrammarLAParser.Tipo_basico_identContext ctx) {
        if(ctx.IDENT() != null){
            //TODO: Falta implementar
        }
        else{
            return visitTipo_basico(ctx.tipo_basico());
        }
        return null;
    }

    @Override
    public String visitTipo_estendido(GrammarLAParser.Tipo_estendidoContext ctx) {
        //TODO: Falta implementar ponteiro_opcionais
        visitPonteiros_opcionais(ctx.ponteiros_opcionais());
        return visitTipo_basico_ident(ctx.tipo_basico_ident());
    }

    @Override
    public String visitValor_constante(GrammarLAParser.Valor_constanteContext ctx) {
        return super.visitValor_constante(ctx);
    }

    @Override
    public String visitRegistro(GrammarLAParser.RegistroContext ctx) {
        return super.visitRegistro(ctx);
    }

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
        if(ctx != null) {
            visitDeclaracao_local(ctx.declaracao_local());
            visitDeclaracoes_locais(ctx.declaracoes_locais());
        }
        return null;
    }

    @Override
    public String visitCorpo(GrammarLAParser.CorpoContext ctx) {
        visitDeclaracoes_locais(ctx.declaracoes_locais()); // TODO
        visitComandos(ctx.comandos());
        return null;
    }

    @Override
    public String visitComandos(GrammarLAParser.ComandosContext ctx) {
        if(ctx != null){
            visitCmd(ctx.cmd());
            visitComandos(ctx.comandos());
        }
        return null;
    }

    @Override
    public String visitCmd(GrammarLAParser.CmdContext ctx) {
        if(ctx != null){
            TabelaDeSimbolos escopoAtual = pt.topo();
            switch(ctx.tipoCmd) {
                case 0:
                    if (!escopoAtual.getTipoSimbolo(ctx.identificador().IDENT().toString()).equals("char")) {
                        System.out.println("\tscanf(\""
                                + ((escopoAtual.getTipoSimbolo(ctx.identificador().IDENT().toString()).equals("int"))?"%d":"%f")
                                + "\",&"
                                + ctx.identificador().IDENT().toString()
                                + ");"
                        );
                    } else {
                        System.out.println("gets("
                                + ctx.identificador().IDENT().toString()
                                + ");"
                        );
                    }

                    visitIdentificador(ctx.identificador());
                    //TODO implementar mais_ident depois
                    visitMais_ident(ctx.mais_ident());
                    break;
                case 1:
                    System.out.print("\tprintf(");
                    String varParam = visitExpressao(ctx.expressao());
                    if(escopoAtual.existeSimbolo(varParam)){
                        String tipo;
                        switch (escopoAtual.getTipoSimbolo(varParam)){
                            case "int":
                                tipo = "%d";
                                break;
                            case "float":
                                tipo = "%f";
                                break;
                            default:
                                tipo = "%s";
                                break;
                        }
                        System.out.print("\""
                                + tipo
                                + "\","
                                + varParam
                        );
                    }
                    System.out.println(");");
                    //TODO:NAO FAZ SENTIDO ALGUM ???!
                    if(ctx.mais_expressao().mais_expressao() != null) {
                        System.out.print("printf(");
                        visitMais_expressao(ctx.mais_expressao());
                        System.out.print(");");
                    }
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
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitMais_expressao(GrammarLAParser.Mais_expressaoContext ctx) {
        return null;
    }

    @Override
    public String visitSenao_opcional(GrammarLAParser.Senao_opcionalContext ctx) {
        return super.visitSenao_opcional(ctx);
    }

    @Override
    public String visitChamada_atribuicao(GrammarLAParser.Chamada_atribuicaoContext ctx) {
        return super.visitChamada_atribuicao(ctx);
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
        return super.visitOp_unario(ctx);
    }

    @Override
    public String visitExp_aritmetica(GrammarLAParser.Exp_aritmeticaContext ctx) {
        String expAConcat = (visitTermo(ctx.termo()) == null?"":visitTermo(ctx.termo()))
                + (visitOutros_termos(ctx.outros_termos()) == null?"":visitOutros_termos(ctx.outros_termos()));
        return expAConcat;
    }

    @Override
    public String visitOp_multiplicacao(GrammarLAParser.Op_multiplicacaoContext ctx) {
        return super.visitOp_multiplicacao(ctx);
    }

    @Override
    public String visitOp_adicao(GrammarLAParser.Op_adicaoContext ctx) {
        return super.visitOp_adicao(ctx);
    }

    @Override
    public String visitTermo(GrammarLAParser.TermoContext ctx) {
        String termConcat = (visitFator(ctx.fator()) == null?"":visitFator(ctx.fator()))
                + (visitOutros_fatores(ctx.outros_fatores()) == null?"":visitOutros_fatores(ctx.outros_fatores()));
        return termConcat;
    }

    @Override
    public String visitOutros_termos(GrammarLAParser.Outros_termosContext ctx) {
        return super.visitOutros_termos(ctx);
    }

    @Override
    public String visitFator(GrammarLAParser.FatorContext ctx) {
        String fatConcat = (visitParcela(ctx.parcela()) == null?"":visitParcela(ctx.parcela()))
                + (visitOutras_parcelas(ctx.outras_parcelas()) == null?"":visitOutras_parcelas(ctx.outras_parcelas()));
        return fatConcat;
    }

    @Override
    public String visitOutros_fatores(GrammarLAParser.Outros_fatoresContext ctx) {
        return super.visitOutros_fatores(ctx);
    }

    @Override
    public String visitParcela(GrammarLAParser.ParcelaContext ctx) {
        if(ctx.parcela_nao_unario() != null){
            return visitParcela_nao_unario(ctx.parcela_nao_unario());
        } else{
            String parConcat = (visitOp_unario(ctx.op_unario()) == null?"": visitOp_unario(ctx.op_unario()))
                    + (visitParcela_unario(ctx.parcela_unario()) == null?"":visitParcela_unario(ctx.parcela_unario())
            );
            //System.out.println(parConcat);
            return parConcat;
        }
    }

    @Override
    public String visitParcela_unario(GrammarLAParser.Parcela_unarioContext ctx) {
        String parConcat = null;
        switch (ctx.tipoParcela){
            case 0:
                break;
            case 1:
                //System.out.println(ctx.IDENT().toString());
                parConcat = ctx.IDENT().toString() + (visitChamada_partes(ctx.chamada_partes()) == null?"":visitChamada_partes(ctx.chamada_partes()));
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        return parConcat;
    }

    @Override
    public String visitParcela_nao_unario(GrammarLAParser.Parcela_nao_unarioContext ctx) {
        if(ctx.CADEIA() != null)
            return ctx.CADEIA().toString();
        else{
            //TODO: Falta implementar resto
            return null;
        }
    }

    @Override
    public String visitOutras_parcelas(GrammarLAParser.Outras_parcelasContext ctx) {
        return super.visitOutras_parcelas(ctx);
    }

    @Override
    public String visitChamada_partes(GrammarLAParser.Chamada_partesContext ctx) {
        return null;
    }

    @Override
    public String visitExp_relacional(GrammarLAParser.Exp_relacionalContext ctx) {
        String expConcat = (visitExp_aritmetica(ctx.exp_aritmetica()) == null?"":visitExp_aritmetica(ctx.exp_aritmetica()))
                + (visitOp_opcional(ctx.op_opcional()) == null?"":visitOp_opcional(ctx.op_opcional()));
        return expConcat;
    }

    @Override
    public String visitOp_opcional(GrammarLAParser.Op_opcionalContext ctx) {
        return super.visitOp_opcional(ctx);
    }

    @Override
    public String visitOp_relacional(GrammarLAParser.Op_relacionalContext ctx) {
        return super.visitOp_relacional(ctx);
    }

    @Override
    public String visitExpressao(GrammarLAParser.ExpressaoContext ctx) {
        String expConcat = (visitTermo_logico(ctx.termo_logico()) == null?"":visitTermo_logico(ctx.termo_logico()))
                + (visitOutros_termos_logicos(ctx.outros_termos_logicos()) == null?"":visitOutros_termos_logicos(ctx.outros_termos_logicos()));
        //TODO: Falta implementar outros termos logicos

        return expConcat;
    }

    @Override
    public String visitOp_nao(GrammarLAParser.Op_naoContext ctx) {
        return super.visitOp_nao(ctx);
    }

    @Override
    public String visitTermo_logico(GrammarLAParser.Termo_logicoContext ctx) {
        String termConcat = (visitFator_logico(ctx.fator_logico()) == null?"":visitFator_logico(ctx.fator_logico()))
                + (visitOutros_fatores_logicos(ctx.outros_fatores_logicos()) == null?"":visitOutros_fatores_logicos(ctx.outros_fatores_logicos()));
        //TODO: Falta implementar outros fatores logicos
        return termConcat;
    }

    @Override
    public String visitOutros_termos_logicos(GrammarLAParser.Outros_termos_logicosContext ctx) {
        return super.visitOutros_termos_logicos(ctx);
    }

    @Override
    public String visitOutros_fatores_logicos(GrammarLAParser.Outros_fatores_logicosContext ctx) {
        return super.visitOutros_fatores_logicos(ctx);
    }

    @Override
    public String visitFator_logico(GrammarLAParser.Fator_logicoContext ctx) {
        //TODO: Falta implementar op_nao
        String fatConcat = (visitOp_nao(ctx.op_nao()) == null?"":visitOp_nao(ctx.op_nao()))
                + (visitParcela_logica(ctx.parcela_logica()) == null?"":visitParcela_logica(ctx.parcela_logica()));
        return fatConcat;
    }

    @Override
    public String visitParcela_logica(GrammarLAParser.Parcela_logicaContext ctx) {
        if(ctx.exp_relacional() != null){
            return (visitExp_relacional(ctx.exp_relacional()) == null?"":visitExp_relacional(ctx.exp_relacional()));
        } else if (ctx.tipoParcela == 0){
            return "verdadeiro";
        } else
            return "falso";
    }
}

