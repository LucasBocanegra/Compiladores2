package compiladores2.antlr;

import compiladores2.ASemantico.PilhaDeTabelas;
import compiladores2.ASemantico.TabelaDeSimbolos;
import compiladores2.ASintatico.SaidaParser;

/**
 * Created by Gabriel Palomino on 10/31/2016.
 */
public class GeradorCodigo extends GrammarLABaseVisitor<String>{

    private PilhaDeTabelas pt;
    private SaidaParser out;

    public GeradorCodigo(SaidaParser out) {
        this.out = out;
    }

    public static String tipoPrint(String tipoPrint){
        String tipo;
        switch (tipoPrint){
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
        return tipo;
    }

    @Override
    public String visitPrograma(GrammarLAParser.ProgramaContext ctx) {
        out.println("#include <stdio.h>\n" +
                "#include <stdlib.h>\n"
        );

        pt = new PilhaDeTabelas();
        pt.empilhar(new TabelaDeSimbolos("global"));

        visitDeclaracoes(ctx.declaracoes());

        out.println("int main() {");

        visitCorpo(ctx.corpo());

        out.println("\treturn 0;\n}");

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
                    out.println("#define "+ ctx.IDENT() + " " + visitValor_constante(ctx.valor_constante())+"\n");
                    break;
                case 2:
                    out.print("\ttypedef" + Character.toString((char) 127));
                    visitTipo(ctx.tipo());
                    out.println(ctx.IDENT().toString()+ ";");
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitVariavel(GrammarLAParser.VariavelContext ctx) {
        String varsConcat = "";
        TabelaDeSimbolos escopoAtual = pt.topo();

        String TipoVar = visitTipo(ctx.tipo());

        if(!TipoVar.contains("*") && !TipoVar.contains("struct"))
            out.print("\t" + TipoVar  + " ");
        else if (TipoVar.contains("*")){
            out.print("\t" + TipoVar.substring(1) + TipoVar.substring(0,1) + " " );
        }
        else if (TipoVar.contains("struct")){
            out.print(TipoVar.replace("struct",""));
            TipoVar = "struct";
        }

        if (!TipoVar.equals("char"))
            varsConcat += ctx.IDENT();
        else
            out.print(ctx.IDENT()+"[80]");

        if(ctx.mais_var().children != null){
            varsConcat  += visitMais_var(ctx.mais_var());
           String varConcat[] = visitMais_var(ctx.mais_var()).split(", ");
            for (String varConcate:varConcat) {
                escopoAtual.adicionarSimbolo(varConcate, TipoVar);
            }

        }
        out.print(varsConcat);
        if(ctx.dimensao() != null) {
            out.print((visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao())));
        }
        out.println(";");

        // Coloca na tabela de simbolos
        escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), TipoVar);
        return varsConcat;
    }

    @Override
    public String visitMais_var(GrammarLAParser.Mais_varContext ctx) {
        if(ctx.children != null){
            String maisvarConcat = ", " +
                    ctx.IDENT()
                    + (visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao()))
                    + (visitMais_var(ctx.mais_var()) == null?"":visitMais_var(ctx.mais_var()));
            return maisvarConcat;
        }
        return null;
    }

    @Override
    public String visitIdentificador(GrammarLAParser.IdentificadorContext ctx) {
        String idConcat = "";

        idConcat += (visitPonteiros_opcionais(ctx.ponteiros_opcionais()) == null?"":visitPonteiros_opcionais(ctx.ponteiros_opcionais())+" ");
        idConcat += ctx.IDENT();
        idConcat += (visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao()));

        return idConcat;
    }

    @Override
    public String visitPonteiros_opcionais(GrammarLAParser.Ponteiros_opcionaisContext ctx) {
        if(ctx.children != null ){
            String ponteirosopcionaisConcat =
                    "*"
                    + (visitPonteiros_opcionais(ctx.ponteiros_opcionais()) == null?"":visitPonteiros_opcionais(ctx.ponteiros_opcionais()));
            return ponteirosopcionaisConcat;
        }else
            return null;
    }

    @Override
    public String visitOutros_ident(GrammarLAParser.Outros_identContext ctx) {
        if(ctx.children != null){
//            return "." + visitIdentificador(ctx.identificador());
            //todo para funcionar  a regra semantica eh necessario mudar essa regra, logo nao existe identificador
            return "." + ctx.IDENT().toString();
        }
        return null;
    }

    @Override
    public String visitDimensao(GrammarLAParser.DimensaoContext ctx) {
        if(ctx.children != null) {
            String DimConcat =
                    "[" + visitExp_aritmetica(ctx.exp_aritmetica()) + "]";
            if (ctx.dimensao() != null)
                DimConcat += (visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao()));
            return DimConcat;
        }
        return null;
    }

    @Override
    public String visitTipo(GrammarLAParser.TipoContext ctx) {
        if(ctx.registro() != null){
            return visitRegistro(ctx.registro());
        } else{
            return visitTipo_estendido(ctx.tipo_estendido());
        }
    }

    @Override
    public String visitMais_ident(GrammarLAParser.Mais_identContext ctx) {
        return super.visitMais_ident(ctx);
    }

    @Override
    public String visitMais_variaveis(GrammarLAParser.Mais_variaveisContext ctx) {
        if (ctx.children != null){
            visitVariavel(ctx.variavel());
            visitMais_variaveis(ctx.mais_variaveis());
        }
        return null;
    }

    @Override
    public String visitTipo_basico(GrammarLAParser.Tipo_basicoContext ctx) {
        if(ctx.getText().equals("literal")){
            return "char";
        } else if (ctx.getText().equals("inteiro")){
            return "int";
        } else if (ctx.getText().equals("real")){
            return "float";
        } else if (ctx.getText().equals("logico")){
            return "int";
        }
        return null;
    }

    @Override
    public String visitTipo_basico_ident(GrammarLAParser.Tipo_basico_identContext ctx) {
        if(ctx.IDENT() != null){
            return ctx.IDENT().toString();
        }
        else{
            return visitTipo_basico(ctx.tipo_basico());
        }
    }

    @Override
    public String visitTipo_estendido(GrammarLAParser.Tipo_estendidoContext ctx) {
        String tipoestendidoConcat =
                (visitPonteiros_opcionais(ctx.ponteiros_opcionais()) == null?"":visitPonteiros_opcionais(ctx.ponteiros_opcionais()))
        + visitTipo_basico_ident(ctx.tipo_basico_ident());
        return  tipoestendidoConcat;
    }

    @Override
    public String visitValor_constante(GrammarLAParser.Valor_constanteContext ctx) {
        if(ctx.getText() != "verdadeiro" && ctx.getText() != "falso"){
            return ctx.getText();
        }else
            return null;
    }

    @Override
    public String visitRegistro(GrammarLAParser.RegistroContext ctx) {
        if(ctx.children != null) {
            out.println("\tstruct {");
            visitVariavel(ctx.variavel());
            visitMais_variaveis(ctx.mais_variaveis());

            out.print("\t}");
            return "struct ";
        }
        return null;
    }

    @Override
    public String visitDeclaracao_global(GrammarLAParser.Declaracao_globalContext ctx) {
        if(ctx.tipoGlob == 0){
            out.print("void " + ctx.IDENT().toString() + "(");
            out.print(visitParametros_opcional(ctx.parametros_opcional()));
            out.println(") {");
            visitDeclaracoes_locais(ctx.declaracoes_locais());
            visitComandos(ctx.comandos());
            out.println("}\n");
        } else {
            TabelaDeSimbolos escopoAtual = pt.topo();
            String decTipo = visitTipo_estendido(ctx.tipo_estendido());
            escopoAtual.adicionarSimbolo(ctx.IDENT().toString(),decTipo);
            out.print(decTipo + " " + ctx.IDENT().toString() + " (");
            out.print(visitParametros_opcional(ctx.parametros_opcional()));
            out.println(") {");
            visitDeclaracoes_locais(ctx.declaracoes_locais());
            visitComandos(ctx.comandos());
            out.println("}\n");
        }
        return null;
    }

    @Override
    public String visitParametros_opcional(GrammarLAParser.Parametros_opcionalContext ctx) {
        if(ctx.children != null){
            return visitParametro(ctx.parametro());
        } else
            return null;
    }

    @Override
    public String visitParametro(GrammarLAParser.ParametroContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();
        String parConcat = "";
        String parTipo = (visitTipo_estendido(ctx.tipo_estendido()) == null?"":visitTipo_estendido(ctx.tipo_estendido()));
        parConcat += parTipo;
        parConcat += (visitVar_opcional(ctx.var_opcional()) == null?"":visitVar_opcional(ctx.var_opcional()));
        try{
            escopoAtual.adicionarSimbolo(ctx.identificador().IDENT().toString(),parTipo);
            if(escopoAtual.getTipoSimbolo(ctx.identificador().IDENT().toString()).equals("char"))
                parConcat += " *";
            else
                parConcat += " ";
        } catch (NullPointerException e){
            parConcat += " ";
        }
        parConcat += visitIdentificador(ctx.identificador());
        parConcat += (visitMais_ident(ctx.mais_ident()) == null?"":visitMais_ident(ctx.mais_ident()));
        parConcat += (visitMais_parametros(ctx.mais_parametros()) == null?"":visitMais_parametros(ctx.mais_parametros()));
        return parConcat;
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
                        out.println("\tscanf(\""
                                + ((escopoAtual.getTipoSimbolo(ctx.identificador().IDENT().toString()).equals("int"))?"%d":"%f")
                                + "\",&"
                                + ctx.identificador().IDENT().toString()
                                + ");"
                        );
                    } else {
                        out.println("\tgets("
                                + ctx.identificador().IDENT().toString()
                                + ");"
                        );
                    }

                    visitIdentificador(ctx.identificador());
                    //TODO implementar mais_ident depois
                    visitMais_ident(ctx.mais_ident());
                    break;
                case 1:
                    String varParam = visitExpressao(ctx.expressao()) +
                            (visitMais_expressao(ctx.mais_expressao()) == null ?"":visitMais_expressao(ctx.mais_expressao()));
                    String tipo;

                    //TODO: Arrumar
                    String varParamSplit[] = visitExpressao(ctx.expressao()).split("\\+");

                    if(ctx.mais_expressao().children == null) {
                        if(escopoAtual.existeSimbolo(varParamSplit[0])){
                            tipo = tipoPrint(escopoAtual.getValorTipoSimbolo(varParamSplit[0]));
                            out.print("\tprintf(");
                            out.print("\""
                                    + tipo
                                    + "\","
                                    + varParam
                            );
                            out.println(");");
                        } else if (varParamSplit[0].contains("(")){
                            String sp3[] = varParamSplit[0].split("\\(");
                            out.println("\tprintf("
                                    + "\""
                                    + tipoPrint(escopoAtual.getValorTipoSimbolo(sp3[0]))
                                    + "\","
                                    + varParamSplit[0]
                                    + ");"
                            );
                        } else if (varParamSplit[0].contains("[")) {
                            String sp3[] = varParamSplit[0].split("\\[");
                            out.println("\tprintf("
                                    + "\""
                                    + tipoPrint(escopoAtual.getValorTipoSimbolo(sp3[0]))
                                    + "\","
                                    + varParamSplit[0]
                                    + ");"
                            );
                        } else {
                            out.print("\tprintf(");
                            out.print(varParam);
                            out.println(");");
                        }
                    }else{
                        String varParamSplited[] = varParam.split(",");
                        for(int i = 0 ; i < varParamSplited.length ; i++) {
                            if (escopoAtual.existeSimbolo(varParamSplited[i])) {
                                tipo = tipoPrint(escopoAtual.getValorTipoSimbolo(varParamSplited[i]));
                                out.print("\tprintf(");
                                out.print("\""
                                        + tipo
                                        + "\","
                                        + varParamSplited[i]
                                );
                                out.println(");");
                            }else if( i+1 < varParamSplited.length && escopoAtual.existeSimbolo(varParamSplited[i+1])){
                                tipo = tipoPrint(escopoAtual.getValorTipoSimbolo(varParamSplited[i+1]));
                                out.print("\tprintf(");
                                out.print(varParamSplited[i].substring(0, varParamSplited[i].length()-1) + tipo + "\"," + varParamSplited[i+1] );
                                out.println(");");
                                i++;
                            }else if(varParamSplited[i].contains(".")){
                                String sp2[] = varParamSplited[i].split("\\.");
                                out.println("\tprintf("
                                        + "\""
                                        + tipoPrint(escopoAtual.getValorTipoSimbolo(sp2[1]))
                                        + "\","
                                        + varParamSplited[i]
                                        + ");"
                                );
                            }
                            else{
                                out.print("\tprintf(");
                                out.print(varParamSplited[i]);
                                out.println(");");
                            }
                        }

                    }
                    break;
                case 2:
                    out.print("\tif (");
                    out.print(visitExpressao(ctx.expressao()));
                    out.println(") {");
                    out.print("\t");
                    visitComandos(ctx.comandos());

                    if(ctx.senao_opcional().children != null) {
                        out.println("\t}");
                        out.println("\telse {");
                        out.print("\t");
                        visitSenao_opcional(ctx.senao_opcional());
                    }

                    out.println("\t}");
                    break;
                case 3:
                    out.print("\tswitch (");
                    out.print(visitExp_aritmetica(ctx.exp_aritmetica(0)));
                    out.println(") {");
                    visitSelecao(ctx.selecao());
                    if(ctx.senao_opcional().children != null) {
                        out.println("\tdefault:");
                        out.print("\t");
                        visitSenao_opcional(ctx.senao_opcional());
                    }
                    out.println("\t}");
                    break;
                case 4:
                    out.println("\tfor (" + ctx.IDENT() +" = " +visitExp_aritmetica(ctx.exp_aritmetica(0)) + "; " + ctx.IDENT().toString() + " <= " + visitExp_aritmetica(ctx.exp_aritmetica(1)) + "; " +ctx.IDENT().toString() +"++) {");
                    visitComandos(ctx.comandos());
                    out.println("\t}");

                    break;
                case 5:
                    out.println("\twhile (" + visitExpressao(ctx.expressao()) + ") {");
                    visitComandos(ctx.comandos());
                    out.println("}");
                    break;
                case 6:
                    out.println("\tdo {");
                    visitComandos(ctx.comandos());
                    out.println("\t} while(" + visitExpressao(ctx.expressao())+");");
                    break;
                case 7:
                    out.println("\t*"+ctx.IDENT().toString() +
                            (visitOutros_ident(ctx.outros_ident()) == null?"":visitOutros_ident(ctx.outros_ident()))
                            + (visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao()))
                            +" = "
                            + visitExpressao(ctx.expressao())
                            +";"
                    );

                    break;
                case 8:
                    String tipoVar = "";
                    try{
//                        tipoVar = escopoAtual.getValorTipoSimbolo(ctx.chamada_atribuicao().outros_ident().identificador().IDENT().toString());
                        tipoVar = escopoAtual.getValorTipoSimbolo(ctx.chamada_atribuicao().outros_ident().IDENT().toString());
                    } catch (NullPointerException e){

                    }
                    if(!tipoVar.equals("char"))
                        out.println("\t" + ctx.IDENT().toString() + visitChamada_atribuicao(ctx.chamada_atribuicao()) + ";");
                    else
                        out.println("\tstrcpy(" + ctx.IDENT().toString() + visitChamada_atribuicao(ctx.chamada_atribuicao()) + ");");
                    break;
                case 9:
                    out.print("\treturn ");
                    out.print(visitExpressao(ctx.expressao()));
                    out.println(";");
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitMais_expressao(GrammarLAParser.Mais_expressaoContext ctx) {
        if(ctx.children != null) {
            String maisexpressaoConcat = ","
                    + visitExpressao(ctx.expressao())
                    + (visitMais_expressao(ctx.mais_expressao()) == null?"":visitMais_expressao(ctx.mais_expressao()));
            return maisexpressaoConcat;
        }
        else {
            return null;
        }

    }

    @Override
    public String visitSenao_opcional(GrammarLAParser.Senao_opcionalContext ctx) {
        if(ctx.children != null){
            String senao_opicionalConcat = visitComandos(ctx.comandos());
            return senao_opicionalConcat;
        }
        return null;
    }

    @Override
    public String visitChamada_atribuicao(GrammarLAParser.Chamada_atribuicaoContext ctx) {
        //if(ctx.expressao().children != null){ deu pau com o children
        if(ctx.expressao() != null){
            TabelaDeSimbolos escopoAtual = pt.topo();
            String tipoVar = "";
            String chamadaatribuicaoConcat = "";
            try{
//                tipoVar = escopoAtual.getValorTipoSimbolo(ctx.outros_ident().identificador().IDENT().toString());
                tipoVar = escopoAtual.getValorTipoSimbolo(ctx.outros_ident().IDENT().toString());
            } catch (NullPointerException e){

            }

            if(!tipoVar.equals("char")) {
                chamadaatribuicaoConcat =
                        (visitOutros_ident(ctx.outros_ident()) == null ? "" : visitOutros_ident(ctx.outros_ident()))
                                + (visitDimensao(ctx.dimensao()) == null ? "" : visitDimensao(ctx.dimensao()))
                                + " = "
                                + visitExpressao(ctx.expressao()).replace("+", " + ");
            } else {
                chamadaatribuicaoConcat =
                        (visitOutros_ident(ctx.outros_ident()) == null ? "" : visitOutros_ident(ctx.outros_ident()))
                                + (visitDimensao(ctx.dimensao()) == null ? "" : visitDimensao(ctx.dimensao()))
                                + ","
                                + visitExpressao(ctx.expressao()).replace("+", " + ");
            }
            return chamadaatribuicaoConcat;
        }
        else {
            String caConcat = "(";
            caConcat += visitArgumentos_opcional(ctx.argumentos_opcional());
            caConcat += ")";
            return caConcat;
        }
    }

    @Override
    public String visitArgumentos_opcional(GrammarLAParser.Argumentos_opcionalContext ctx) {
        if(ctx.children != null){
            String aoConcat = "";
            aoConcat += (visitExpressao(ctx.expressao()) == null?"":visitExpressao(ctx.expressao()));
            aoConcat += (visitMais_expressao(ctx.mais_expressao()) == null?"":visitMais_expressao(ctx.mais_expressao()));
            return aoConcat;
        } else
            return null;
    }

    @Override
    public String visitSelecao(GrammarLAParser.SelecaoContext ctx) {
        String Constantes[] = visitConstantes(ctx.constantes()).split("\\.\\.");
        if(Constantes.length > 1)
            for(int i = Integer.parseInt(Constantes[0]); i <= Integer.parseInt(Constantes[1]); i++)
                out.println("\tcase " + i + ":");
        else
            out.println("\tcase " + Constantes[0] + ":");
        out.print("\t");
        visitComandos(ctx.comandos());
        out.println("\t\tbreak;");
        visitMais_selecao(ctx.mais_selecao());
        return null;
    }

    @Override
    public String visitMais_selecao(GrammarLAParser.Mais_selecaoContext ctx) {
        return super.visitMais_selecao(ctx);
    }

    @Override
    public String visitConstantes(GrammarLAParser.ConstantesContext ctx) {
        String constantesConcat =
                visitNumero_intervalo(ctx.numero_intervalo())
                + (visitMais_constantes(ctx.mais_constantes()) == null?"":visitMais_constantes(ctx.mais_constantes()));
        return constantesConcat;
    }

    @Override
    public String visitMais_constantes(GrammarLAParser.Mais_constantesContext ctx) {
        return super.visitMais_constantes(ctx);
    }

    @Override
    public String visitNumero_intervalo(GrammarLAParser.Numero_intervaloContext ctx) {
        String numerointervaloConcat =
                (visitOp_unario(ctx.op_unario()) == null?"":visitOp_unario(ctx.op_unario()))
                + ctx.NUM_INT()
                + (visitIntervalo_opcional(ctx.intervalo_opcional()) == null?"":visitIntervalo_opcional(ctx.intervalo_opcional()));
        return numerointervaloConcat;
    }

    @Override
    public String visitIntervalo_opcional(GrammarLAParser.Intervalo_opcionalContext ctx) {
        if(ctx.children != null){
            String intervaloopcionalConcat =
                    ".."
                    + (visitOp_unario(ctx.op_unario()) == null?"":visitOp_unario(ctx.op_unario()))
                    + ctx.NUM_INT();
            return intervaloopcionalConcat;
        }else
            return null;
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
        return ctx.start.getText();
    }

    @Override
    public String visitOp_adicao(GrammarLAParser.Op_adicaoContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitTermo(GrammarLAParser.TermoContext ctx) {
        String termConcat = (visitFator(ctx.fator()) == null?"":visitFator(ctx.fator()))
                + (visitOutros_fatores(ctx.outros_fatores()) == null?"":visitOutros_fatores(ctx.outros_fatores()));
        return termConcat;
    }

    @Override
    public String visitOutros_termos(GrammarLAParser.Outros_termosContext ctx) {
        if(ctx.children != null){
            String outrostermosConcat =
                    visitOp_adicao(ctx.op_adicao())
                    + (visitTermo(ctx.termo()) == null?"":visitTermo(ctx.termo()))
                    + (visitOutros_termos(ctx.outros_termos()) == null?"":visitOutros_termos(ctx.outros_termos()));
            return outrostermosConcat;
        }
        return null;
    }

    @Override
    public String visitFator(GrammarLAParser.FatorContext ctx) {
        String fatConcat = (visitParcela(ctx.parcela()) == null?"":visitParcela(ctx.parcela()))
                + (visitOutras_parcelas(ctx.outras_parcelas()) == null?"":visitOutras_parcelas(ctx.outras_parcelas()));
        return fatConcat;
    }

    @Override
    public String visitOutros_fatores(GrammarLAParser.Outros_fatoresContext ctx) {
        String ofConcat = "";
        if (ctx.children != null) {
            ofConcat += (visitOp_multiplicacao(ctx.op_multiplicacao()) == null?"":visitOp_multiplicacao(ctx.op_multiplicacao()));
            ofConcat += visitFator(ctx.fator());
            ofConcat += (visitOutros_fatores(ctx.outros_fatores()) == null?"":visitOutros_fatores(ctx.outros_fatores()));
            return ofConcat;
        } else
            return null;
    }

    @Override
    public String visitParcela(GrammarLAParser.ParcelaContext ctx) {
        if(ctx.parcela_nao_unario() != null){
            return visitParcela_nao_unario(ctx.parcela_nao_unario());
        } else{
            String parConcat = (visitOp_unario(ctx.op_unario()) == null?"": visitOp_unario(ctx.op_unario()))
                    + (visitParcela_unario(ctx.parcela_unario()) == null?"":visitParcela_unario(ctx.parcela_unario())
            );
            //out.println(parConcat);
            return parConcat;
        }
    }

    @Override
    public String visitParcela_unario(GrammarLAParser.Parcela_unarioContext ctx) {
        String parConcat = "";
        switch (ctx.tipoParcela){
            case 0:
                break;
            case 1:
                parConcat = ctx.IDENT().toString() + (visitChamada_partes(ctx.chamada_partes()) == null?"":visitChamada_partes(ctx.chamada_partes()));
                break;
            case 2:
                parConcat = (ctx.NUM_INT().toString() == null?"":ctx.NUM_INT().toString());
                break;
            case 3:
                parConcat = (ctx.NUM_REAL().toString() == null?"":ctx.NUM_REAL().toString());
                break;
            case 4:
                parConcat = "("+ visitExpressao(ctx.expressao()) + ")";
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
            String parcelanaounarioConcat =
                    "&"
                    + ctx.IDENT().toString()
                    + (visitOutros_ident(ctx.outros_ident()) == null?"":visitOutros_ident(ctx.outros_ident()))
                    + (visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao()));
            return parcelanaounarioConcat;
        }
    }

    @Override
    public String visitOutras_parcelas(GrammarLAParser.Outras_parcelasContext ctx) {
        return super.visitOutras_parcelas(ctx);
    }

    @Override
    public String visitChamada_partes(GrammarLAParser.Chamada_partesContext ctx) {
        String callConcat = "";
        if(ctx.children != null){
            if(ctx.expressao() != null){
                callConcat += "("
                        + (visitExpressao(ctx.expressao()) == null?"":visitExpressao(ctx.expressao()))
                        + (visitMais_expressao(ctx.mais_expressao()) == null?"":visitMais_expressao(ctx.mais_expressao()))
                        + ")"
                        ;
            } else{
                callConcat +=
                        (visitOutros_ident(ctx.outros_ident()) == null?"":visitOutros_ident(ctx.outros_ident()))
                        + (visitDimensao(ctx.dimensao()) == null?"":visitDimensao(ctx.dimensao()))
                        ;
            }
        }
        return callConcat;
    }

    @Override
    public String visitExp_relacional(GrammarLAParser.Exp_relacionalContext ctx) {
        String expConcat = (visitExp_aritmetica(ctx.exp_aritmetica()) == null?"":visitExp_aritmetica(ctx.exp_aritmetica()))
                + (visitOp_opcional(ctx.op_opcional()) == null?"":visitOp_opcional(ctx.op_opcional()));
        return expConcat;
    }

    @Override
    public String visitOp_opcional(GrammarLAParser.Op_opcionalContext ctx) {
        if(ctx.children != null){
            String opopcionalConcat =
                    visitOp_relacional(ctx.op_relacional())
                    +visitExp_aritmetica(ctx.exp_aritmetica());
            return opopcionalConcat;
        }else
            return null;

    }

    @Override
    public String visitOp_relacional(GrammarLAParser.Op_relacionalContext ctx) {
        if(ctx.getText().equals("="))
            return " == ";
        else
            return " " + ctx.getText() + " ";
    }

    @Override
    public String visitExpressao(GrammarLAParser.ExpressaoContext ctx) {
        String expConcat = (visitTermo_logico(ctx.termo_logico()) == null?"":visitTermo_logico(ctx.termo_logico()))
                + (visitOutros_termos_logicos(ctx.outros_termos_logicos()) == null?"":visitOutros_termos_logicos(ctx.outros_termos_logicos()));
        return expConcat;
    }

    @Override
    public String visitOp_nao(GrammarLAParser.Op_naoContext ctx) {
        if(ctx.children != null)
            return "!";
        else
            return null;
    }

    @Override
    public String visitTermo_logico(GrammarLAParser.Termo_logicoContext ctx) {
        String termConcat = (visitFator_logico(ctx.fator_logico()) == null?"":visitFator_logico(ctx.fator_logico()))
                + (visitOutros_fatores_logicos(ctx.outros_fatores_logicos()) == null?"":visitOutros_fatores_logicos(ctx.outros_fatores_logicos()));
        return termConcat;
    }

    @Override
    public String visitOutros_termos_logicos(GrammarLAParser.Outros_termos_logicosContext ctx) {
        return super.visitOutros_termos_logicos(ctx);
    }

    @Override
    public String visitOutros_fatores_logicos(GrammarLAParser.Outros_fatores_logicosContext ctx) {
        if(ctx.children != null){
            String outrosfatoreslogicosConcat =
                    " && "
                    + visitFator_logico(ctx.fator_logico())
                    + (visitOutros_fatores_logicos(ctx.outros_fatores_logicos()) == null?"":visitOutros_fatores_logicos(ctx.outros_fatores_logicos()));
            return outrosfatoreslogicosConcat;
        }else
            return null;
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

