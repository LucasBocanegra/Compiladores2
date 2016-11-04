package compiladores2.antlr;

import compiladores2.ASemantico.EntradaTabelaDeSimbolos;
import compiladores2.ASemantico.PilhaDeTabelas;
import compiladores2.ASemantico.TabelaDeSimbolos;
import compiladores2.ASemantico.Tipo;

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
                case 0: // se for variável
                    visitVariavel(ctx.variavel());
                    break;
                case 1: //se for constante
                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
                        escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), visitTipo_basico(ctx.tipo_basico()));
                    }else{
                        System.out.println("Linha "+ ctx.getStart().getLine() +": identificador "+ ctx.IDENT().toString() +" ja declarado anteriormente ");
                    }
                    visitValor_constante(ctx.valor_constante());
                    break;
                case 2: //se for tipo
                    int posicaoAtual = 0;
                    String tipo = null;
                    EntradaTabelaDeSimbolos novaEntrada = null;

                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
                        posicaoAtual = escopoAtual.getUltimaPosicaoOcupada();
                        tipo = visitTipo(ctx.tipo());

                        if(tipo.equals("registro")){
                            novaEntrada = new EntradaTabelaDeSimbolos(ctx.IDENT().toString(),tipo);
                            if(escopoAtual.getUltimaPosicaoOcupada() != -1) {
                                for (int k = posicaoAtual + 1; k <= escopoAtual.getUltimaPosicaoOcupada(); k++) {
                                    String nome = escopoAtual.getNomeSimbolo(k);
                                    Tipo t = escopoAtual.getTipoSimbolo(nome);
                                    novaEntrada.addCampoNoTipo(nome, t.getValor());
                                }
                                escopoAtual.removeSimbolosAPartir(++posicaoAtual);
                                escopoAtual.adicionarSimbolo(novaEntrada);
                            }

                        }else {
                            escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), tipo, ctx.tipo().ehPonteiro);
                        }
                    }else{
                        System.out.println("Linha "+ ctx.getStart().getLine() +": identificador "+ ctx.IDENT().toString() +" ja declarado anteriormente ");
                    }
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitVariavel(GrammarLAParser.VariavelContext ctx) {
        TabelaDeSimbolos escopoAtual = pt.topo();
        EntradaTabelaDeSimbolos novaEntrada = null;

        int posicaoAtual = escopoAtual.getUltimaPosicaoOcupada();
        String tipo = visitTipo(ctx.tipo());

        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())){
            if(tipo.equals("registro")){
                novaEntrada = new EntradaTabelaDeSimbolos(ctx.IDENT().toString(),tipo);
                if(escopoAtual.getUltimaPosicaoOcupada() != -1) {
                   for (int k = posicaoAtual + 1; k <= escopoAtual.getUltimaPosicaoOcupada(); k++) {
                       String nome = escopoAtual.getNomeSimbolo(k);
                       Tipo t = escopoAtual.getTipoSimbolo(nome);
                       novaEntrada.addCampoNoTipo(nome, t.getValor());
                   }
                   escopoAtual.removeSimbolosAPartir(++posicaoAtual);
                   escopoAtual.adicionarSimbolo(novaEntrada);
                }
            }else {
                escopoAtual.adicionarSimbolo(ctx.IDENT().toString(), tipo, ctx.tipo().ehPonteiro);
            }
        }else{
            System.out.println("Linha "+ ctx.getStart().getLine() +": identificador "+ ctx.IDENT().toString() +" ja declarado anteriormente ");
        }

        //declara todas as mais_var com o tipo definido
        //neste caso existe várias variáveis com o mesmo tipo
        //existem mais variavies com o msm tipo separadas por ','
        GrammarLAParser.Mais_varContext m = ctx.mais_var();
        while (m.children != null){
            if(!escopoAtual.existeSimbolo(visitMais_var(m))){
                if(tipo.equals("registro")) {
                    if(novaEntrada == null){ //significa que deu erro na primeira declaração (a primeira variável não existe)
                        novaEntrada = new EntradaTabelaDeSimbolos(m.IDENT().toString(),tipo);
                        if(escopoAtual.getUltimaPosicaoOcupada() != -1) {
                            for (int k = posicaoAtual + 1; k <= escopoAtual.getUltimaPosicaoOcupada(); k++) {
                                String nome = escopoAtual.getNomeSimbolo(k);
                                Tipo t = escopoAtual.getTipoSimbolo(nome);
                                novaEntrada.addCampoNoTipo(nome, t.getValor());
                            }
                            escopoAtual.removeSimbolosAPartir(++posicaoAtual);
                            escopoAtual.adicionarSimbolo(novaEntrada);
                        }
                    }else{
                        // o tipo eh o mesmo para as variáveis , por isso só altera o nome add na tabela
                        EntradaTabelaDeSimbolos outraEntrada = new EntradaTabelaDeSimbolos(novaEntrada);
                        outraEntrada.setNome(m.IDENT().toString());
                        escopoAtual.adicionarSimbolo(outraEntrada);
                    }
                }else if(escopoAtual.existeSimbolo(tipo)){ //se for um tipo complexo
                    Tipo t = escopoAtual.getTipoSimbolo(tipo);
                    if(t.getValor().equals("registro")){
                        //pega o tipo da entrada na tabela de simbolos (que eh um tipo) e add a variável declarada
                        EntradaTabelaDeSimbolos outraEntrada = new EntradaTabelaDeSimbolos(m.IDENT().toString(),t);
                        escopoAtual.adicionarSimbolo(outraEntrada);
                    }
                }else {
                    escopoAtual.adicionarSimbolo(m.IDENT().toString(), tipo, ctx.tipo().ehPonteiro);
                }
            }else{
                System.out.println("Linha "+ m.getStart().getLine() +": identificador "+ m.IDENT().toString() +" ja declarado anteriormente ");
            }
            m = m.mais_var();
        }
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
        visitDimensao(ctx.dimensao());
        visitOutros_ident(ctx.outros_ident());

        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString()) && ctx.outros_ident().name == null) {
            System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
        }
        return null;
    }

    @Override
    public String visitPonteiros_opcionais(GrammarLAParser.Ponteiros_opcionaisContext ctx) {
        if(ctx.children != null){
            visitPonteiros_opcionais(ctx.ponteiros_opcionais());
            ctx.ehPonteiro = true;
        }else{
            ctx.ehPonteiro = false;
        }
        return null;
    }

    @Override
    public String visitOutros_ident(GrammarLAParser.Outros_identContext ctx) {
        if(ctx.children != null){
            //visitIdentificador(ctx.identificador());
            ctx.name = ctx.IDENT().toString();
        }else{
            ctx.name = null;
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
            String r = visitTipo_estendido(ctx.tipo_estendido());
            ctx.ehPonteiro = ctx.tipo_estendido().ehPonteiro;
            return r;
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
            //System.out.println("Erro, tipo declarado não compatível com tipo básico");
            return "undefined"; //tipo nao copativel
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
                return ctx.IDENT().toString();
            }else{
                //TODO melhorar mensagem de saida
                System.out.println("Linha "+ctx.getStart().getLine()+": tipo "+ctx.IDENT().toString()+" nao declarado");
                return "undefined"; //tipo nao existente de variavel
            }
        }
    }

    @Override
    public String visitTipo_estendido(GrammarLAParser.Tipo_estendidoContext ctx) {
        if(ctx.ponteiros_opcionais() != null){
            visitPonteiros_opcionais(ctx.ponteiros_opcionais());
            ctx.ehPonteiro = ctx.ponteiros_opcionais().ehPonteiro;
        }else{
            ctx.ehPonteiro = false;
        }

        return visitTipo_basico_ident(ctx.tipo_basico_ident());
    }

    @Override
    public String visitValor_constante(GrammarLAParser.Valor_constanteContext ctx) {
        if(ctx.children != null){
            switch (ctx.TipoConstante){
                case 0:
                    ctx.tipoSimbolo = "literal";
                    break;
                case 1:
                    ctx.tipoSimbolo = "inteiro";
                    break;
                case 2:
                    ctx.tipoSimbolo = "real";
                    break;
                case 3:
                    ctx.tipoSimbolo = "logico";
                    break;
                case 4:
                    ctx.tipoSimbolo = "logico";
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitRegistro(GrammarLAParser.RegistroContext ctx) {
        visitVariavel(ctx.variavel());
        visitMais_variaveis(ctx.mais_variaveis());
        return "registro";

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
        TabelaDeSimbolos escopoAtual = pt.topo();
        if(ctx != null){
            switch(ctx.tipoCmd) {
                case 0: //leia
                    visitIdentificador(ctx.identificador());
                    //TODO implementar mais_ident depois
                    visitMais_ident(ctx.mais_ident());
                    break;
                case 1: //escreva
                    visitExpressao(ctx.expressao());
                    visitMais_expressao(ctx.mais_expressao());
                    break;
                case 2: //se .. entao
                    visitExpressao(ctx.expressao());
                    visitComandos(ctx.comandos());
                    visitSenao_opcional(ctx.senao_opcional());
                    break;
                case 3: //caso ... seja
                    break;
                case 4://para
                    break;
                case 5://enquanto
                    visitExpressao(ctx.expressao());
                    break;
                case 6://faca
                    break;
                case 7: //atribuição de ponteiro
                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())) {
                        System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
                    }else{
                        String nameAtribuicao = ctx.IDENT().toString();
                        String tipoAtribuicao = escopoAtual.getValorTipoSimbolo(ctx.IDENT().toString());

                        if(escopoAtual.ehPonteiro(ctx.IDENT().toString())) {
                            visitExpressao(ctx.expressao());
                            String tipoSimbolo = ctx.expressao().tipoSimbolo;

                            if(tipoSimbolo.equals("error") || !tipoAtribuicao.equals(tipoSimbolo)){
                                if( !(tipoAtribuicao.equals("real") && tipoSimbolo.equals("inteiro"))) {
                                    System.out.println("Linha " + ctx.getStart().getLine() + ": atribuicao nao compativel para ^" + nameAtribuicao);
                                }
                            }
                        }else{ // a variável atribuida nao eh ponteiro
                            System.out.println("Linha " + ctx.getStart().getLine() + ": atribuicao nao compativel para " + nameAtribuicao);
                        }
                    }
                    break;
                case 8: //atribuição de variável
                    String nameAtribuicao = ctx.IDENT().toString();
                    String tipoAtribuicao = escopoAtual.getValorTipoSimbolo(ctx.IDENT().toString());

                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString()) || tipoAtribuicao == null) {
                        System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
                    }else {

                        visitChamada_atribuicao(ctx.chamada_atribuicao());

                        String tipoSimbolo = ctx.chamada_atribuicao().tipoSimbolo;
                        if (tipoAtribuicao.equals("registro")) {
                            String campo1 = ctx.chamada_atribuicao().outros_ident().name;
                            if (!escopoAtual.existeSimboloNoTipo(nameAtribuicao, campo1)) {
                                System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + nameAtribuicao + "." + campo1 + " nao declarado");
                            } else {
                                tipoAtribuicao = escopoAtual.getTipoSimbolo(nameAtribuicao).getValorCampo(campo1);
                                if (tipoSimbolo.equals("error") || !tipoAtribuicao.equals(tipoSimbolo)) {
                                    if (!(tipoAtribuicao.equals("real") && tipoSimbolo.equals("inteiro"))) {
                                        System.out.println("Linha " + ctx.getStart().getLine() + ": atribuicao nao compativel para " + nameAtribuicao +"."+campo1);
                                    }
                                }
                            }
                        }else {
                            if (tipoSimbolo.equals("error") || !tipoAtribuicao.equals(tipoSimbolo)) {
                                if (!(tipoAtribuicao.equals("real") && tipoSimbolo.equals("inteiro"))) {
                                    System.out.println("Linha " + ctx.getStart().getLine() + ": atribuicao nao compativel para " + nameAtribuicao);
                                }
                            }
                        }
                    }
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
        if (ctx.comandos() != null) {
            visitComandos(ctx.comandos());
        }
        return null;
    }

    @Override
    public String visitChamada_atribuicao(GrammarLAParser.Chamada_atribuicaoContext ctx) {
        visitOutros_ident(ctx.outros_ident());
        visitExpressao(ctx.expressao());
        ctx.tipoSimbolo = ctx.expressao().tipoSimbolo;
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

        ctx.tipoSimbolo = ctx.termo_logico().tipoSimbolo;

        return null;
    }

    /*
    * Caso os fatores termos e outro termos forem imcompatíveis, retornar
    * */
    @Override
    public String visitExp_aritmetica(GrammarLAParser.Exp_aritmeticaContext ctx) {

        visitTermo(ctx.termo());
        visitOutros_termos(ctx.outros_termos());

        ctx.tipoSimbolo = setTipoSimbolo(ctx.termo().tipoSimbolo, ctx.outros_termos().tipoSimbolo);

        return null;
    }

    @Override
    public String visitOp_multiplicacao(GrammarLAParser.Op_multiplicacaoContext ctx) {
        return ctx.getText();
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

        ctx.tipoSimbolo = ctx.fator().tipoSimbolo;
        return null;
    }

    @Override
    public String visitOutros_termos(GrammarLAParser.Outros_termosContext ctx) {
        if(ctx.children != null){
            if(ctx.op_adicao() != null){
                visitOp_adicao(ctx.op_adicao());
                visitTermo(ctx.termo());
                visitOutros_termos(ctx.outros_termos());

                ctx.tipoSimbolo = setTipoSimbolo(ctx.termo().tipoSimbolo, ctx.outros_termos().tipoSimbolo);
            }else{
                ctx.tipoSimbolo = "undefined";
                return null;
            }
        }else {
            ctx.tipoSimbolo = "undefined";
        }

        return null;
    }

    @Override
    public String visitFator(GrammarLAParser.FatorContext ctx) {
        visitParcela(ctx.parcela());
        visitOutras_parcelas(ctx.outras_parcelas());
        ctx.tipoSimbolo = ctx.parcela().tipoSimbolo;
        return null;
    }

    @Override
    public String visitOutros_fatores(GrammarLAParser.Outros_fatoresContext ctx) {
        //nao utilizado, portanto nao retornar tipo
        if(ctx.children != null){
            if(ctx.op_multiplicacao() != null){
                visitOp_multiplicacao(ctx.op_multiplicacao());
                visitFator(ctx.fator());
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public String visitParcela(GrammarLAParser.ParcelaContext ctx) {
        ctx.tipoSimbolo = "undefined";
        if(ctx.children != null) {
            if (ctx.parcela_nao_unario() == null) {
                visitOp_unario(ctx.op_unario());
                visitParcela_unario(ctx.parcela_unario());
                ctx.tipoSimbolo = ctx.parcela_unario().tipoSimbolo;

            } else {
                visitParcela_nao_unario(ctx.parcela_nao_unario());
                ctx.tipoSimbolo = ctx.parcela_nao_unario().tipoSimbolo;
            }
        }
        return null;
    }

    @Override
    public String visitParcela_unario(GrammarLAParser.Parcela_unarioContext ctx) {
        ctx.tipoSimbolo = "undefined";
        if(ctx.children != null){
            TabelaDeSimbolos escopoAtual = pt.topo();
            switch (ctx.tipoParcela){
                case 0: // caso por penteiro
                    if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())) {
                        System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
                    }else{
                        ctx.tipoSimbolo = escopoAtual.getValorTipoSimbolo(ctx.IDENT().toString());
                    }
                    visitOutros_ident(ctx.outros_ident());
                    visitDimensao(ctx.dimensao());
                    break;
                case 1: //caso por uma variável
                    visitChamada_partes(ctx.chamada_partes());

                    if(ctx.chamada_partes().ehRegistro){ // a variavel em questão eh um registro
                        String nameAtribuicao = ctx.IDENT().toString();
                        String campo1 = ctx.chamada_partes().outros_ident().IDENT().toString();

                        if (!escopoAtual.existeSimboloNoTipo(nameAtribuicao,campo1)) {
                            System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + nameAtribuicao + "." + campo1 + " nao declarado");
                        } else {
                            ctx.tipoSimbolo = escopoAtual.getTipoSimbolo(nameAtribuicao).getValorCampo(campo1);
                        }
                    }else{ //a variavel nao eh um registro
                        if(!escopoAtual.existeSimbolo(ctx.IDENT().toString())) {
                            System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
                        }else{
                            ctx.tipoSimbolo = escopoAtual.getValorTipoSimbolo(ctx.IDENT().toString());
                        }
                    }
                    break;
                case 2: //int
                    ctx.tipoSimbolo=  "inteiro";
                    break;
                case 3: //real
                    ctx.tipoSimbolo=  "real";
                    break;
                case 4: //caso for funcao
                    visitExpressao(ctx.expressao());
                    ctx.tipoSimbolo = ctx.expressao().tipoSimbolo;
                    break;
            }
        }
        return null;
    }

    @Override
    public String visitParcela_nao_unario(GrammarLAParser.Parcela_nao_unarioContext ctx) {
        if(ctx.tipoParcela == 0){
            TabelaDeSimbolos escopoAtual = pt.topo();
            if(escopoAtual.existeSimbolo(ctx.IDENT().toString())){
                ctx.tipoSimbolo = escopoAtual.getValorTipoSimbolo(ctx.IDENT().toString());
            }else{
                System.out.println("Linha " + ctx.getStart().getLine() + ": identificador " + ctx.IDENT().toString() + " nao declarado");
            }
        }else if(ctx.tipoParcela == 1){
            ctx.tipoSimbolo = "literal";
        }
        return null;
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
                ctx.ehRegistro = false;
            }
            else if(ctx.outros_ident() != null){
                visitOutros_ident(ctx.outros_ident());
                visitDimensao(ctx.dimensao());

                if(ctx.outros_ident().name != null){
                    ctx.ehRegistro = true;
                }else{
                    ctx.ehRegistro = false;
                }
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
        if(ctx.op_opcional().tipoSimbolo.equals("undefined")){
            ctx.tipoSimbolo = ctx.exp_aritmetica().tipoSimbolo;
        }else{
            ctx.tipoSimbolo = ctx.op_opcional().tipoSimbolo;
        }

        return null;
    }

    @Override
    public String visitOp_opcional(GrammarLAParser.Op_opcionalContext ctx) {
        if(ctx.children != null){
            if(ctx.op_relacional() != null){
                visitOp_relacional(ctx.op_relacional());
                visitExp_aritmetica(ctx.exp_aritmetica());
                ctx.tipoSimbolo = ctx.op_relacional().tipoSimbolo;
            }else{
                ctx.tipoSimbolo = "undefined";
                return null;
            }
        }else{
            ctx.tipoSimbolo = "undefined";
        }
        return null;
    }

    @Override
    public String visitOp_relacional(GrammarLAParser.Op_relacionalContext ctx) {
        ctx.tipoSimbolo = "logico";
        return ctx.getText();
    }

    @Override
    public String visitOp_nao(GrammarLAParser.Op_naoContext ctx) {
        ctx.tipoSimbolo = "undefined";

        if(ctx.children != null){
            if(ctx.getText().equals("nao")){
                ctx.tipoSimbolo = "logico";
                return ctx.getText();
            }
        }
        return null;
    }

    @Override
    public String visitTermo_logico(GrammarLAParser.Termo_logicoContext ctx) {

        visitFator_logico(ctx.fator_logico());
        visitOutros_fatores_logicos(ctx.outros_fatores_logicos());

        ctx.tipoSimbolo = ctx.fator_logico().tipoSimbolo;
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
        return null;
    }

    @Override
    public String visitFator_logico(GrammarLAParser.Fator_logicoContext ctx) {

        visitOp_nao(ctx.op_nao());
        visitParcela_logica(ctx.parcela_logica());
        ctx.tipoSimbolo = ctx.parcela_logica().tipoSimbolo;

        return null;
    }

    @Override
    public String visitParcela_logica(GrammarLAParser.Parcela_logicaContext ctx) {
        if(ctx.exp_relacional() != null){
           visitExp_relacional(ctx.exp_relacional());
           ctx.tipoSimbolo = ctx.exp_relacional().tipoSimbolo;
        }else{
            ctx.tipoSimbolo = "logico";
        }
        return null;
    }

    //Vefirica dois tipos e retorna erro se forem diferentes
    private String setTipoSimbolo(String t1, String t2){
        if(!t1.equals("error") && !t2.equals("error")){
            if(t1.equals(t2)|| t2.equals("undefined")){
                return t1;
            }else{
                if(t1.equals("undefined")){
                    return t2;
                }else{
                    return "error"; //variáveis incompatíveis
                }
            }
        }else{
            return "error";
        }
    }
}
