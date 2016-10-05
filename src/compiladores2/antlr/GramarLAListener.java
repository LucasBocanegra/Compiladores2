// Generated from /home/lucas/Documents/bcc/2016/2sem/cc2/Compiladores2/src/compiladores2/antlr/GramarLA.g4 by ANTLR 4.5.3
package compiladores2.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramarLAParser}.
 */
public interface GramarLAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(GramarLAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(GramarLAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(GramarLAParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(GramarLAParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(GramarLAParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(GramarLAParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(GramarLAParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(GramarLAParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(GramarLAParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(GramarLAParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_var}.
	 * @param ctx the parse tree
	 */
	void enterMais_var(GramarLAParser.Mais_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_var}.
	 * @param ctx the parse tree
	 */
	void exitMais_var(GramarLAParser.Mais_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(GramarLAParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(GramarLAParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#ponteiros_opcionais}.
	 * @param ctx the parse tree
	 */
	void enterPonteiros_opcionais(GramarLAParser.Ponteiros_opcionaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#ponteiros_opcionais}.
	 * @param ctx the parse tree
	 */
	void exitPonteiros_opcionais(GramarLAParser.Ponteiros_opcionaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#outros_ident}.
	 * @param ctx the parse tree
	 */
	void enterOutros_ident(GramarLAParser.Outros_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#outros_ident}.
	 * @param ctx the parse tree
	 */
	void exitOutros_ident(GramarLAParser.Outros_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(GramarLAParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(GramarLAParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(GramarLAParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(GramarLAParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_ident}.
	 * @param ctx the parse tree
	 */
	void enterMais_ident(GramarLAParser.Mais_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_ident}.
	 * @param ctx the parse tree
	 */
	void exitMais_ident(GramarLAParser.Mais_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_variaveis}.
	 * @param ctx the parse tree
	 */
	void enterMais_variaveis(GramarLAParser.Mais_variaveisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_variaveis}.
	 * @param ctx the parse tree
	 */
	void exitMais_variaveis(GramarLAParser.Mais_variaveisContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(GramarLAParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(GramarLAParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(GramarLAParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(GramarLAParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(GramarLAParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(GramarLAParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(GramarLAParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(GramarLAParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(GramarLAParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(GramarLAParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#registro2}.
	 * @param ctx the parse tree
	 */
	void enterRegistro2(GramarLAParser.Registro2Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#registro2}.
	 * @param ctx the parse tree
	 */
	void exitRegistro2(GramarLAParser.Registro2Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(GramarLAParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(GramarLAParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#parametros_opcional}.
	 * @param ctx the parse tree
	 */
	void enterParametros_opcional(GramarLAParser.Parametros_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#parametros_opcional}.
	 * @param ctx the parse tree
	 */
	void exitParametros_opcional(GramarLAParser.Parametros_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(GramarLAParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(GramarLAParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#var_opcional}.
	 * @param ctx the parse tree
	 */
	void enterVar_opcional(GramarLAParser.Var_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#var_opcional}.
	 * @param ctx the parse tree
	 */
	void exitVar_opcional(GramarLAParser.Var_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_parametros}.
	 * @param ctx the parse tree
	 */
	void enterMais_parametros(GramarLAParser.Mais_parametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_parametros}.
	 * @param ctx the parse tree
	 */
	void exitMais_parametros(GramarLAParser.Mais_parametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#declaracoes_locais}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes_locais(GramarLAParser.Declaracoes_locaisContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#declaracoes_locais}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes_locais(GramarLAParser.Declaracoes_locaisContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(GramarLAParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(GramarLAParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(GramarLAParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(GramarLAParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(GramarLAParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(GramarLAParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_expressao}.
	 * @param ctx the parse tree
	 */
	void enterMais_expressao(GramarLAParser.Mais_expressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_expressao}.
	 * @param ctx the parse tree
	 */
	void exitMais_expressao(GramarLAParser.Mais_expressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#senao_opcional}.
	 * @param ctx the parse tree
	 */
	void enterSenao_opcional(GramarLAParser.Senao_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#senao_opcional}.
	 * @param ctx the parse tree
	 */
	void exitSenao_opcional(GramarLAParser.Senao_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#chamada_atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterChamada_atribuicao(GramarLAParser.Chamada_atribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#chamada_atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitChamada_atribuicao(GramarLAParser.Chamada_atribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#argumentos_opcional}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos_opcional(GramarLAParser.Argumentos_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#argumentos_opcional}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos_opcional(GramarLAParser.Argumentos_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(GramarLAParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(GramarLAParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_selecao}.
	 * @param ctx the parse tree
	 */
	void enterMais_selecao(GramarLAParser.Mais_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_selecao}.
	 * @param ctx the parse tree
	 */
	void exitMais_selecao(GramarLAParser.Mais_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(GramarLAParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(GramarLAParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#mais_constantes}.
	 * @param ctx the parse tree
	 */
	void enterMais_constantes(GramarLAParser.Mais_constantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#mais_constantes}.
	 * @param ctx the parse tree
	 */
	void exitMais_constantes(GramarLAParser.Mais_constantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(GramarLAParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(GramarLAParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#intervalo_opcional}.
	 * @param ctx the parse tree
	 */
	void enterIntervalo_opcional(GramarLAParser.Intervalo_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#intervalo_opcional}.
	 * @param ctx the parse tree
	 */
	void exitIntervalo_opcional(GramarLAParser.Intervalo_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(GramarLAParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(GramarLAParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(GramarLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(GramarLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op_multiplicacao}.
	 * @param ctx the parse tree
	 */
	void enterOp_multiplicacao(GramarLAParser.Op_multiplicacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op_multiplicacao}.
	 * @param ctx the parse tree
	 */
	void exitOp_multiplicacao(GramarLAParser.Op_multiplicacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op_adicao}.
	 * @param ctx the parse tree
	 */
	void enterOp_adicao(GramarLAParser.Op_adicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op_adicao}.
	 * @param ctx the parse tree
	 */
	void exitOp_adicao(GramarLAParser.Op_adicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GramarLAParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GramarLAParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#outros_termos}.
	 * @param ctx the parse tree
	 */
	void enterOutros_termos(GramarLAParser.Outros_termosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#outros_termos}.
	 * @param ctx the parse tree
	 */
	void exitOutros_termos(GramarLAParser.Outros_termosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(GramarLAParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(GramarLAParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#outros_fatores}.
	 * @param ctx the parse tree
	 */
	void enterOutros_fatores(GramarLAParser.Outros_fatoresContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#outros_fatores}.
	 * @param ctx the parse tree
	 */
	void exitOutros_fatores(GramarLAParser.Outros_fatoresContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(GramarLAParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(GramarLAParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(GramarLAParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(GramarLAParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(GramarLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(GramarLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#outras_parcelas}.
	 * @param ctx the parse tree
	 */
	void enterOutras_parcelas(GramarLAParser.Outras_parcelasContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#outras_parcelas}.
	 * @param ctx the parse tree
	 */
	void exitOutras_parcelas(GramarLAParser.Outras_parcelasContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#chamada_partes}.
	 * @param ctx the parse tree
	 */
	void enterChamada_partes(GramarLAParser.Chamada_partesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#chamada_partes}.
	 * @param ctx the parse tree
	 */
	void exitChamada_partes(GramarLAParser.Chamada_partesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(GramarLAParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(GramarLAParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op_opcional}.
	 * @param ctx the parse tree
	 */
	void enterOp_opcional(GramarLAParser.Op_opcionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op_opcional}.
	 * @param ctx the parse tree
	 */
	void exitOp_opcional(GramarLAParser.Op_opcionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(GramarLAParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(GramarLAParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(GramarLAParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(GramarLAParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op_nao}.
	 * @param ctx the parse tree
	 */
	void enterOp_nao(GramarLAParser.Op_naoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op_nao}.
	 * @param ctx the parse tree
	 */
	void exitOp_nao(GramarLAParser.Op_naoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(GramarLAParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(GramarLAParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#outros_termos_logicos}.
	 * @param ctx the parse tree
	 */
	void enterOutros_termos_logicos(GramarLAParser.Outros_termos_logicosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#outros_termos_logicos}.
	 * @param ctx the parse tree
	 */
	void exitOutros_termos_logicos(GramarLAParser.Outros_termos_logicosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#outros_fatores_logicos}.
	 * @param ctx the parse tree
	 */
	void enterOutros_fatores_logicos(GramarLAParser.Outros_fatores_logicosContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#outros_fatores_logicos}.
	 * @param ctx the parse tree
	 */
	void exitOutros_fatores_logicos(GramarLAParser.Outros_fatores_logicosContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(GramarLAParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(GramarLAParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(GramarLAParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(GramarLAParser.Parcela_logicaContext ctx);
}