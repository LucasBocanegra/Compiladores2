// Generated from /home/lucas/Documents/bcc/2016/2sem/cc2/Compiladores2/src/compiladores2/antlr/GramarLA.g4 by ANTLR 4.5.3
package compiladores2.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramarLAParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, IDENT=63, NUM_INT=64, NUM_REAL=65, CADEIA=66, 
		WS=67, COMENTARIOS=68;
	public static final int
		RULE_programa = 0, RULE_declaracoes = 1, RULE_decl_local_global = 2, RULE_declaracao_local = 3, 
		RULE_variavel = 4, RULE_mais_var = 5, RULE_identificador = 6, RULE_ponteiros_opcionais = 7, 
		RULE_outros_ident = 8, RULE_dimensao = 9, RULE_tipo = 10, RULE_mais_ident = 11, 
		RULE_mais_variaveis = 12, RULE_tipo_basico = 13, RULE_tipo_basico_ident = 14, 
		RULE_tipo_estendido = 15, RULE_valor_constante = 16, RULE_registro = 17, 
		RULE_registro2 = 18, RULE_declaracao_global = 19, RULE_parametros_opcional = 20, 
		RULE_parametro = 21, RULE_var_opcional = 22, RULE_mais_parametros = 23, 
		RULE_declaracoes_locais = 24, RULE_corpo = 25, RULE_comandos = 26, RULE_cmd = 27, 
		RULE_mais_expressao = 28, RULE_senao_opcional = 29, RULE_chamada_atribuicao = 30, 
		RULE_argumentos_opcional = 31, RULE_selecao = 32, RULE_mais_selecao = 33, 
		RULE_constantes = 34, RULE_mais_constantes = 35, RULE_numero_intervalo = 36, 
		RULE_intervalo_opcional = 37, RULE_op_unario = 38, RULE_exp_aritmetica = 39, 
		RULE_op_multiplicacao = 40, RULE_op_adicao = 41, RULE_termo = 42, RULE_outros_termos = 43, 
		RULE_fator = 44, RULE_outros_fatores = 45, RULE_parcela = 46, RULE_parcela_unario = 47, 
		RULE_parcela_nao_unario = 48, RULE_outras_parcelas = 49, RULE_chamada_partes = 50, 
		RULE_exp_relacional = 51, RULE_op_opcional = 52, RULE_op_relacional = 53, 
		RULE_expressao = 54, RULE_op_nao = 55, RULE_termo_logico = 56, RULE_outros_termos_logicos = 57, 
		RULE_outros_fatores_logicos = 58, RULE_fator_logico = 59, RULE_parcela_logica = 60;
	public static final String[] ruleNames = {
		"programa", "declaracoes", "decl_local_global", "declaracao_local", "variavel", 
		"mais_var", "identificador", "ponteiros_opcionais", "outros_ident", "dimensao", 
		"tipo", "mais_ident", "mais_variaveis", "tipo_basico", "tipo_basico_ident", 
		"tipo_estendido", "valor_constante", "registro", "registro2", "declaracao_global", 
		"parametros_opcional", "parametro", "var_opcional", "mais_parametros", 
		"declaracoes_locais", "corpo", "comandos", "cmd", "mais_expressao", "senao_opcional", 
		"chamada_atribuicao", "argumentos_opcional", "selecao", "mais_selecao", 
		"constantes", "mais_constantes", "numero_intervalo", "intervalo_opcional", 
		"op_unario", "exp_aritmetica", "op_multiplicacao", "op_adicao", "termo", 
		"outros_termos", "fator", "outros_fatores", "parcela", "parcela_unario", 
		"parcela_nao_unario", "outras_parcelas", "chamada_partes", "exp_relacional", 
		"op_opcional", "op_relacional", "expressao", "op_nao", "termo_logico", 
		"outros_termos_logicos", "outros_fatores_logicos", "fator_logico", "parcela_logica"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'constante'", "':'", 
		"'='", "'tipo'", "'IDENT'", "','", "'^'", "'.'", "'['", "']'", "'literal'", 
		"'inteiro'", "'real'", "'logico'", "'CADEIA'", "'NUM_INT'", "'NUM_REAL'", 
		"'verdadeiro'", "'falso'", "'fim_registro'", "'procedimento'", "'('", 
		"')'", "'fim_procedimento'", "'funcao'", "'fim_funcao'", "'var'", "'leia'", 
		"'escreva'", "'se'", "'entao'", "'fim_se'", "'caso'", "'seja'", "'fim_caso'", 
		"'para'", "'<-'", "'ate'", "'faca'", "'fim_para'", "'enquanto'", "'fim_enquanto'", 
		"'retorne'", "'senao'", "'..'", "'-'", "'*'", "'/'", "'+'", "'&'", "'%'", 
		"'<>'", "'>='", "'<='", "'>'", "'<'", "'nao'", "'ou'", "'e'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "IDENT", "NUM_INT", "NUM_REAL", "CADEIA", "WS", "COMENTARIOS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GramarLA.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GramarLAParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			declaracoes();
			setState(123);
			match(T__0);
			setState(124);
			corpo();
			setState(125);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracoesContext extends ParserRuleContext {
		public Decl_local_globalContext decl_local_global() {
			return getRuleContext(Decl_local_globalContext.class,0);
		}
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaracoes);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__6:
			case T__23:
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				decl_local_global();
				setState(128);
				declaracoes();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_local_globalContext extends ParserRuleContext {
		public Declaracao_localContext declaracao_local() {
			return getRuleContext(Declaracao_localContext.class,0);
		}
		public Declaracao_globalContext declaracao_global() {
			return getRuleContext(Declaracao_globalContext.class,0);
		}
		public Decl_local_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_local_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterDecl_local_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitDecl_local_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitDecl_local_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_local_globalContext decl_local_global() throws RecognitionException {
		Decl_local_globalContext _localctx = new Decl_local_globalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_local_global);
		try {
			setState(135);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				declaracao_local();
				}
				break;
			case T__23:
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				declaracao_global();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracao_localContext extends ParserRuleContext {
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Declaracao_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterDeclaracao_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitDeclaracao_local(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitDeclaracao_local(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_localContext declaracao_local() throws RecognitionException {
		Declaracao_localContext _localctx = new Declaracao_localContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracao_local);
		try {
			setState(150);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(T__2);
				setState(138);
				variavel();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(T__3);
				setState(140);
				match(IDENT);
				setState(141);
				match(T__4);
				setState(142);
				tipo_basico();
				setState(143);
				match(T__5);
				setState(144);
				valor_constante();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(T__6);
				setState(147);
				match(T__7);
				setState(148);
				match(T__4);
				setState(149);
				tipo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariavelContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Mais_varContext mais_var() {
			return getRuleContext(Mais_varContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variavel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(IDENT);
			setState(153);
			dimensao();
			setState(154);
			mais_var();
			setState(155);
			match(T__4);
			setState(156);
			tipo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_varContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Mais_varContext mais_var() {
			return getRuleContext(Mais_varContext.class,0);
		}
		public Mais_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_varContext mais_var() throws RecognitionException {
		Mais_varContext _localctx = new Mais_varContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mais_var);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(T__8);
				setState(159);
				match(IDENT);
				setState(160);
				dimensao();
				setState(161);
				mais_var();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentificadorContext extends ParserRuleContext {
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_identificador);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			ponteiros_opcionais();
			setState(167);
			match(IDENT);
			setState(168);
			dimensao();
			setState(169);
			outros_ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ponteiros_opcionaisContext extends ParserRuleContext {
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public Ponteiros_opcionaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ponteiros_opcionais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterPonteiros_opcionais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitPonteiros_opcionais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitPonteiros_opcionais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ponteiros_opcionaisContext ponteiros_opcionais() throws RecognitionException {
		Ponteiros_opcionaisContext _localctx = new Ponteiros_opcionaisContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ponteiros_opcionais);
		try {
			setState(174);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(T__9);
				setState(172);
				ponteiros_opcionais();
				}
				break;
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_identContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Outros_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOutros_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOutros_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOutros_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_identContext outros_ident() throws RecognitionException {
		Outros_identContext _localctx = new Outros_identContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_outros_ident);
		try {
			setState(179);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(T__10);
				setState(177);
				identificador();
				}
				break;
			case T__1:
			case T__4:
			case T__5:
			case T__8:
			case T__9:
			case T__11:
			case T__12:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimensaoContext extends ParserRuleContext {
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public DimensaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterDimensao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitDimensao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitDimensao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensaoContext dimensao() throws RecognitionException {
		DimensaoContext _localctx = new DimensaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dimensao);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(T__11);
				setState(182);
				exp_aritmetica();
				setState(183);
				match(T__12);
				setState(184);
				dimensao();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				registro();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				tipo_estendido();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_identContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public Mais_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_identContext mais_ident() throws RecognitionException {
		Mais_identContext _localctx = new Mais_identContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mais_ident);
		try {
			setState(198);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				match(T__8);
				setState(194);
				identificador();
				setState(195);
				mais_ident();
				}
				break;
			case T__4:
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_variaveisContext extends ParserRuleContext {
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public Mais_variaveisContext mais_variaveis() {
			return getRuleContext(Mais_variaveisContext.class,0);
		}
		public Mais_variaveisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_variaveis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_variaveis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_variaveis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_variaveis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_variaveisContext mais_variaveis() throws RecognitionException {
		Mais_variaveisContext _localctx = new Mais_variaveisContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mais_variaveis);
		try {
			setState(204);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				variavel();
				setState(201);
				mais_variaveis();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_basicoContext extends ParserRuleContext {
		public Tipo_basicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterTipo_basico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitTipo_basico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitTipo_basico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basicoContext tipo_basico() throws RecognitionException {
		Tipo_basicoContext _localctx = new Tipo_basicoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo_basico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_basico_identContext extends ParserRuleContext {
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public Tipo_basico_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterTipo_basico_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitTipo_basico_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitTipo_basico_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basico_identContext tipo_basico_ident() throws RecognitionException {
		Tipo_basico_identContext _localctx = new Tipo_basico_identContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tipo_basico_ident);
		try {
			setState(210);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
			case T__15:
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				tipo_basico();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_estendidoContext extends ParserRuleContext {
		public Ponteiros_opcionaisContext ponteiros_opcionais() {
			return getRuleContext(Ponteiros_opcionaisContext.class,0);
		}
		public Tipo_basico_identContext tipo_basico_ident() {
			return getRuleContext(Tipo_basico_identContext.class,0);
		}
		public Tipo_estendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_estendido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterTipo_estendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitTipo_estendido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitTipo_estendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_estendidoContext tipo_estendido() throws RecognitionException {
		Tipo_estendidoContext _localctx = new Tipo_estendidoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipo_estendido);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			ponteiros_opcionais();
			setState(213);
			tipo_basico_ident();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Valor_constanteContext extends ParserRuleContext {
		public Valor_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterValor_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitValor_constante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitValor_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_constanteContext valor_constante() throws RecognitionException {
		Valor_constanteContext _localctx = new Valor_constanteContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_valor_constante);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegistroContext extends ParserRuleContext {
		public Registro2Context registro2() {
			return getRuleContext(Registro2Context.class,0);
		}
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_registro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			registro2();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Registro2Context extends ParserRuleContext {
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public Mais_variaveisContext mais_variaveis() {
			return getRuleContext(Mais_variaveisContext.class,0);
		}
		public Registro2Context registro2() {
			return getRuleContext(Registro2Context.class,0);
		}
		public Registro2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterRegistro2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitRegistro2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitRegistro2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Registro2Context registro2() throws RecognitionException {
		Registro2Context _localctx = new Registro2Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_registro2);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				variavel();
				setState(220);
				mais_variaveis();
				setState(221);
				match(T__22);
				setState(222);
				registro2();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracao_globalContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public Parametros_opcionalContext parametros_opcional() {
			return getRuleContext(Parametros_opcionalContext.class,0);
		}
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public Declaracao_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterDeclaracao_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitDeclaracao_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitDeclaracao_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_globalContext declaracao_global() throws RecognitionException {
		Declaracao_globalContext _localctx = new Declaracao_globalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_declaracao_global);
		try {
			setState(247);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(T__23);
				setState(228);
				match(IDENT);
				setState(229);
				match(T__24);
				setState(230);
				parametros_opcional();
				setState(231);
				match(T__25);
				setState(232);
				declaracoes_locais();
				setState(233);
				comandos();
				setState(234);
				match(T__26);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__27);
				setState(237);
				match(IDENT);
				setState(238);
				match(T__24);
				setState(239);
				parametros_opcional();
				setState(240);
				match(T__25);
				setState(241);
				match(T__4);
				setState(242);
				tipo_estendido();
				setState(243);
				declaracoes_locais();
				setState(244);
				comandos();
				setState(245);
				match(T__28);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parametros_opcionalContext extends ParserRuleContext {
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public Parametros_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterParametros_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitParametros_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitParametros_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametros_opcionalContext parametros_opcional() throws RecognitionException {
		Parametros_opcionalContext _localctx = new Parametros_opcionalContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parametros_opcional);
		try {
			setState(251);
			switch (_input.LA(1)) {
			case T__9:
			case T__29:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				parametro();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametroContext extends ParserRuleContext {
		public Var_opcionalContext var_opcional() {
			return getRuleContext(Var_opcionalContext.class,0);
		}
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public Mais_parametrosContext mais_parametros() {
			return getRuleContext(Mais_parametrosContext.class,0);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			var_opcional();
			setState(254);
			identificador();
			setState(255);
			mais_ident();
			setState(256);
			match(T__4);
			setState(257);
			tipo_estendido();
			setState(258);
			mais_parametros();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_opcionalContext extends ParserRuleContext {
		public Var_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterVar_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitVar_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitVar_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_opcionalContext var_opcional() throws RecognitionException {
		Var_opcionalContext _localctx = new Var_opcionalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_var_opcional);
		try {
			setState(262);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(T__29);
				}
				break;
			case T__9:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_parametrosContext extends ParserRuleContext {
		public ParametroContext parametro() {
			return getRuleContext(ParametroContext.class,0);
		}
		public Mais_parametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_parametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_parametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_parametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_parametrosContext mais_parametros() throws RecognitionException {
		Mais_parametrosContext _localctx = new Mais_parametrosContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mais_parametros);
		try {
			setState(267);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(T__8);
				setState(265);
				parametro();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Declaracoes_locaisContext extends ParserRuleContext {
		public Declaracao_localContext declaracao_local() {
			return getRuleContext(Declaracao_localContext.class,0);
		}
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public Declaracoes_locaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes_locais; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterDeclaracoes_locais(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitDeclaracoes_locais(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitDeclaracoes_locais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracoes_locaisContext declaracoes_locais() throws RecognitionException {
		Declaracoes_locaisContext _localctx = new Declaracoes_locaisContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_declaracoes_locais);
		try {
			setState(273);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				declaracao_local();
				setState(270);
				declaracoes_locais();
				}
				break;
			case T__1:
			case T__9:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__35:
			case T__38:
			case T__41:
			case T__43:
			case T__45:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public Declaracoes_locaisContext declaracoes_locais() {
			return getRuleContext(Declaracoes_locaisContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_corpo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			declaracoes_locais();
			setState(276);
			comandos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandosContext extends ParserRuleContext {
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public ComandosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comandos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterComandos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitComandos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitComandos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandosContext comandos() throws RecognitionException {
		ComandosContext _localctx = new ComandosContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_comandos);
		try {
			setState(282);
			switch (_input.LA(1)) {
			case T__9:
			case T__30:
			case T__31:
			case T__32:
			case T__35:
			case T__38:
			case T__41:
			case T__43:
			case T__45:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				cmd();
				setState(279);
				comandos();
				}
				break;
			case T__1:
			case T__26:
			case T__28:
			case T__34:
			case T__37:
			case T__40:
			case T__42:
			case T__44:
			case T__46:
			case T__48:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public Mais_identContext mais_ident() {
			return getRuleContext(Mais_identContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Senao_opcionalContext senao_opcional() {
			return getRuleContext(Senao_opcionalContext.class,0);
		}
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Chamada_atribuicaoContext chamada_atribuicao() {
			return getRuleContext(Chamada_atribuicaoContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cmd);
		try {
			setState(342);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(T__30);
				setState(285);
				match(T__24);
				setState(286);
				identificador();
				setState(287);
				mais_ident();
				setState(288);
				match(T__25);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(T__31);
				setState(291);
				match(T__24);
				setState(292);
				expressao();
				setState(293);
				mais_expressao();
				setState(294);
				match(T__25);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				match(T__32);
				setState(297);
				expressao();
				setState(298);
				match(T__33);
				setState(299);
				comandos();
				setState(300);
				senao_opcional();
				setState(301);
				match(T__34);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
				match(T__35);
				setState(304);
				exp_aritmetica();
				setState(305);
				match(T__36);
				setState(306);
				selecao();
				setState(307);
				senao_opcional();
				setState(308);
				match(T__37);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 5);
				{
				setState(310);
				match(T__38);
				setState(311);
				match(IDENT);
				setState(312);
				match(T__39);
				setState(313);
				exp_aritmetica();
				setState(314);
				match(T__40);
				setState(315);
				exp_aritmetica();
				setState(316);
				match(T__41);
				setState(317);
				comandos();
				setState(318);
				match(T__42);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 6);
				{
				setState(320);
				match(T__43);
				setState(321);
				expressao();
				setState(322);
				match(T__41);
				setState(323);
				comandos();
				setState(324);
				match(T__44);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 7);
				{
				setState(326);
				match(T__41);
				setState(327);
				comandos();
				setState(328);
				match(T__40);
				setState(329);
				expressao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 8);
				{
				setState(331);
				match(T__9);
				setState(332);
				match(IDENT);
				setState(333);
				outros_ident();
				setState(334);
				dimensao();
				setState(335);
				match(T__39);
				setState(336);
				expressao();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 9);
				{
				setState(338);
				match(IDENT);
				setState(339);
				chamada_atribuicao();
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 10);
				{
				setState(340);
				match(T__45);
				setState(341);
				expressao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_expressaoContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Mais_expressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_expressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_expressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_expressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_expressaoContext mais_expressao() throws RecognitionException {
		Mais_expressaoContext _localctx = new Mais_expressaoContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_mais_expressao);
		try {
			setState(349);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(T__8);
				setState(345);
				expressao();
				setState(346);
				mais_expressao();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Senao_opcionalContext extends ParserRuleContext {
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Senao_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_senao_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterSenao_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitSenao_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitSenao_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Senao_opcionalContext senao_opcional() throws RecognitionException {
		Senao_opcionalContext _localctx = new Senao_opcionalContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_senao_opcional);
		try {
			setState(354);
			switch (_input.LA(1)) {
			case T__46:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(T__46);
				setState(352);
				comandos();
				}
				break;
			case T__34:
			case T__37:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Chamada_atribuicaoContext extends ParserRuleContext {
		public Argumentos_opcionalContext argumentos_opcional() {
			return getRuleContext(Argumentos_opcionalContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Chamada_atribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterChamada_atribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitChamada_atribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitChamada_atribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamada_atribuicaoContext chamada_atribuicao() throws RecognitionException {
		Chamada_atribuicaoContext _localctx = new Chamada_atribuicaoContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_chamada_atribuicao);
		try {
			setState(365);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(356);
				match(T__24);
				setState(357);
				argumentos_opcional();
				setState(358);
				match(T__25);
				}
				break;
			case T__10:
			case T__11:
			case T__39:
				enterOuterAlt(_localctx, 2);
				{
				setState(360);
				outros_ident();
				setState(361);
				dimensao();
				setState(362);
				match(T__39);
				setState(363);
				expressao();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argumentos_opcionalContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Argumentos_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterArgumentos_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitArgumentos_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitArgumentos_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argumentos_opcionalContext argumentos_opcional() throws RecognitionException {
		Argumentos_opcionalContext _localctx = new Argumentos_opcionalContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_argumentos_opcional);
		try {
			setState(371);
			switch (_input.LA(1)) {
			case T__9:
			case T__20:
			case T__21:
			case T__24:
			case T__48:
			case T__52:
			case T__59:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
			case CADEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				expressao();
				setState(368);
				mais_expressao();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelecaoContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public ComandosContext comandos() {
			return getRuleContext(ComandosContext.class,0);
		}
		public Mais_selecaoContext mais_selecao() {
			return getRuleContext(Mais_selecaoContext.class,0);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitSelecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_selecao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			constantes();
			setState(374);
			match(T__4);
			setState(375);
			comandos();
			setState(376);
			mais_selecao();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_selecaoContext extends ParserRuleContext {
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public Mais_selecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_selecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_selecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_selecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_selecaoContext mais_selecao() throws RecognitionException {
		Mais_selecaoContext _localctx = new Mais_selecaoContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_mais_selecao);
		try {
			setState(380);
			switch (_input.LA(1)) {
			case T__48:
			case NUM_INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				selecao();
				}
				break;
			case T__37:
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantesContext extends ParserRuleContext {
		public Numero_intervaloContext numero_intervalo() {
			return getRuleContext(Numero_intervaloContext.class,0);
		}
		public Mais_constantesContext mais_constantes() {
			return getRuleContext(Mais_constantesContext.class,0);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitConstantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_constantes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			numero_intervalo();
			setState(383);
			mais_constantes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mais_constantesContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public Mais_constantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mais_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterMais_constantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitMais_constantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitMais_constantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mais_constantesContext mais_constantes() throws RecognitionException {
		Mais_constantesContext _localctx = new Mais_constantesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_mais_constantes);
		try {
			setState(388);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(385);
				match(T__8);
				setState(386);
				constantes();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numero_intervaloContext extends ParserRuleContext {
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(GramarLAParser.NUM_INT, 0); }
		public Intervalo_opcionalContext intervalo_opcional() {
			return getRuleContext(Intervalo_opcionalContext.class,0);
		}
		public Numero_intervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero_intervalo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterNumero_intervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitNumero_intervalo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitNumero_intervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numero_intervaloContext numero_intervalo() throws RecognitionException {
		Numero_intervaloContext _localctx = new Numero_intervaloContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_numero_intervalo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			op_unario();
			setState(391);
			match(NUM_INT);
			setState(392);
			intervalo_opcional();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Intervalo_opcionalContext extends ParserRuleContext {
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(GramarLAParser.NUM_INT, 0); }
		public Intervalo_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalo_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterIntervalo_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitIntervalo_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitIntervalo_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Intervalo_opcionalContext intervalo_opcional() throws RecognitionException {
		Intervalo_opcionalContext _localctx = new Intervalo_opcionalContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_intervalo_opcional);
		try {
			setState(399);
			switch (_input.LA(1)) {
			case T__47:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				match(T__47);
				setState(395);
				op_unario();
				setState(396);
				match(NUM_INT);
				}
				break;
			case T__4:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_unarioContext extends ParserRuleContext {
		public Op_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOp_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOp_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOp_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_unarioContext op_unario() throws RecognitionException {
		Op_unarioContext _localctx = new Op_unarioContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_op_unario);
		try {
			setState(403);
			switch (_input.LA(1)) {
			case T__48:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(T__48);
				}
				break;
			case T__9:
			case T__24:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_aritmeticaContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Outros_termosContext outros_termos() {
			return getRuleContext(Outros_termosContext.class,0);
		}
		public Exp_aritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_aritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterExp_aritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitExp_aritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_exp_aritmetica);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			termo();
			setState(406);
			outros_termos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_multiplicacaoContext extends ParserRuleContext {
		public Op_multiplicacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_multiplicacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOp_multiplicacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOp_multiplicacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOp_multiplicacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_multiplicacaoContext op_multiplicacao() throws RecognitionException {
		Op_multiplicacaoContext _localctx = new Op_multiplicacaoContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_op_multiplicacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_la = _input.LA(1);
			if ( !(_la==T__49 || _la==T__50) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_adicaoContext extends ParserRuleContext {
		public Op_adicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_adicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOp_adicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOp_adicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOp_adicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_adicaoContext op_adicao() throws RecognitionException {
		Op_adicaoContext _localctx = new Op_adicaoContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_op_adicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			_la = _input.LA(1);
			if ( !(_la==T__48 || _la==T__51) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public Outros_fatoresContext outros_fatores() {
			return getRuleContext(Outros_fatoresContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			fator();
			setState(413);
			outros_fatores();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_termosContext extends ParserRuleContext {
		public Op_adicaoContext op_adicao() {
			return getRuleContext(Op_adicaoContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public Outros_termosContext outros_termos() {
			return getRuleContext(Outros_termosContext.class,0);
		}
		public Outros_termosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_termos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOutros_termos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOutros_termos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOutros_termos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_termosContext outros_termos() throws RecognitionException {
		Outros_termosContext _localctx = new Outros_termosContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_outros_termos);
		try {
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(415);
				op_adicao();
				setState(416);
				termo();
				setState(417);
				outros_termos();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public ParcelaContext parcela() {
			return getRuleContext(ParcelaContext.class,0);
		}
		public Outras_parcelasContext outras_parcelas() {
			return getRuleContext(Outras_parcelasContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_fator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			parcela();
			setState(423);
			outras_parcelas();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_fatoresContext extends ParserRuleContext {
		public Op_multiplicacaoContext op_multiplicacao() {
			return getRuleContext(Op_multiplicacaoContext.class,0);
		}
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public Outros_fatoresContext outros_fatores() {
			return getRuleContext(Outros_fatoresContext.class,0);
		}
		public Outros_fatoresContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_fatores; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOutros_fatores(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOutros_fatores(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOutros_fatores(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_fatoresContext outros_fatores() throws RecognitionException {
		Outros_fatoresContext _localctx = new Outros_fatoresContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_outros_fatores);
		try {
			setState(430);
			switch (_input.LA(1)) {
			case T__49:
			case T__50:
				enterOuterAlt(_localctx, 1);
				{
				setState(425);
				op_multiplicacao();
				setState(426);
				fator();
				setState(427);
				outros_fatores();
				}
				break;
			case T__1:
			case T__5:
			case T__8:
			case T__9:
			case T__12:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__48:
			case T__51:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParcelaContext extends ParserRuleContext {
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public Parcela_unarioContext parcela_unario() {
			return getRuleContext(Parcela_unarioContext.class,0);
		}
		public Parcela_nao_unarioContext parcela_nao_unario() {
			return getRuleContext(Parcela_nao_unarioContext.class,0);
		}
		public ParcelaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterParcela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitParcela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_parcela);
		try {
			setState(436);
			switch (_input.LA(1)) {
			case T__9:
			case T__24:
			case T__48:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				op_unario();
				setState(433);
				parcela_unario();
				}
				break;
			case T__52:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				parcela_nao_unario();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parcela_unarioContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Chamada_partesContext chamada_partes() {
			return getRuleContext(Chamada_partesContext.class,0);
		}
		public TerminalNode NUM_INT() { return getToken(GramarLAParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(GramarLAParser.NUM_REAL, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Parcela_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterParcela_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitParcela_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_parcela_unario);
		try {
			setState(451);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				match(T__9);
				setState(439);
				match(IDENT);
				setState(440);
				outros_ident();
				setState(441);
				dimensao();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				match(IDENT);
				setState(444);
				chamada_partes();
				}
				break;
			case NUM_INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(445);
				match(NUM_INT);
				}
				break;
			case NUM_REAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(446);
				match(NUM_REAL);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(447);
				match(T__24);
				setState(448);
				expressao();
				setState(449);
				match(T__25);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parcela_nao_unarioContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(GramarLAParser.IDENT, 0); }
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(GramarLAParser.CADEIA, 0); }
		public Parcela_nao_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_nao_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterParcela_nao_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitParcela_nao_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_parcela_nao_unario);
		try {
			setState(459);
			switch (_input.LA(1)) {
			case T__52:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				match(T__52);
				setState(454);
				match(IDENT);
				setState(455);
				outros_ident();
				setState(456);
				dimensao();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				match(CADEIA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outras_parcelasContext extends ParserRuleContext {
		public ParcelaContext parcela() {
			return getRuleContext(ParcelaContext.class,0);
		}
		public Outras_parcelasContext outras_parcelas() {
			return getRuleContext(Outras_parcelasContext.class,0);
		}
		public Outras_parcelasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outras_parcelas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOutras_parcelas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOutras_parcelas(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOutras_parcelas(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outras_parcelasContext outras_parcelas() throws RecognitionException {
		Outras_parcelasContext _localctx = new Outras_parcelasContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_outras_parcelas);
		try {
			setState(466);
			switch (_input.LA(1)) {
			case T__53:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				match(T__53);
				setState(462);
				parcela();
				setState(463);
				outras_parcelas();
				}
				break;
			case T__1:
			case T__5:
			case T__8:
			case T__9:
			case T__12:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__36:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__60:
			case T__61:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Chamada_partesContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public Mais_expressaoContext mais_expressao() {
			return getRuleContext(Mais_expressaoContext.class,0);
		}
		public Outros_identContext outros_ident() {
			return getRuleContext(Outros_identContext.class,0);
		}
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public Chamada_partesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chamada_partes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterChamada_partes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitChamada_partes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitChamada_partes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Chamada_partesContext chamada_partes() throws RecognitionException {
		Chamada_partesContext _localctx = new Chamada_partesContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_chamada_partes);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(468);
				match(T__24);
				setState(469);
				expressao();
				setState(470);
				mais_expressao();
				setState(471);
				match(T__25);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(473);
				outros_ident();
				setState(474);
				dimensao();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Exp_relacionalContext extends ParserRuleContext {
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public Op_opcionalContext op_opcional() {
			return getRuleContext(Op_opcionalContext.class,0);
		}
		public Exp_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterExp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitExp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_exp_relacional);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			exp_aritmetica();
			setState(480);
			op_opcional();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_opcionalContext extends ParserRuleContext {
		public Op_relacionalContext op_relacional() {
			return getRuleContext(Op_relacionalContext.class,0);
		}
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public Op_opcionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_opcional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOp_opcional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOp_opcional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOp_opcional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_opcionalContext op_opcional() throws RecognitionException {
		Op_opcionalContext _localctx = new Op_opcionalContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_op_opcional);
		try {
			setState(486);
			switch (_input.LA(1)) {
			case T__5:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
				enterOuterAlt(_localctx, 1);
				{
				setState(482);
				op_relacional();
				setState(483);
				exp_aritmetica();
				}
				break;
			case T__1:
			case T__8:
			case T__9:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__48:
			case T__60:
			case T__61:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_relacionalContext extends ParserRuleContext {
		public Op_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_relacionalContext op_relacional() throws RecognitionException {
		Op_relacionalContext _localctx = new Op_relacionalContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_op_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public Outros_termos_logicosContext outros_termos_logicos() {
			return getRuleContext(Outros_termos_logicosContext.class,0);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_expressao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			termo_logico();
			setState(491);
			outros_termos_logicos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Op_naoContext extends ParserRuleContext {
		public Op_naoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_nao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOp_nao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOp_nao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOp_nao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_naoContext op_nao() throws RecognitionException {
		Op_naoContext _localctx = new Op_naoContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_op_nao);
		try {
			setState(495);
			switch (_input.LA(1)) {
			case T__59:
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				match(T__59);
				}
				break;
			case T__9:
			case T__20:
			case T__21:
			case T__24:
			case T__48:
			case T__52:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Termo_logicoContext extends ParserRuleContext {
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Outros_fatores_logicosContext outros_fatores_logicos() {
			return getRuleContext(Outros_fatores_logicosContext.class,0);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitTermo_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_termo_logico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			fator_logico();
			setState(498);
			outros_fatores_logicos();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_termos_logicosContext extends ParserRuleContext {
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public Outros_termos_logicosContext outros_termos_logicos() {
			return getRuleContext(Outros_termos_logicosContext.class,0);
		}
		public Outros_termos_logicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_termos_logicos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOutros_termos_logicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOutros_termos_logicos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOutros_termos_logicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_termos_logicosContext outros_termos_logicos() throws RecognitionException {
		Outros_termos_logicosContext _localctx = new Outros_termos_logicosContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_outros_termos_logicos);
		try {
			setState(505);
			switch (_input.LA(1)) {
			case T__60:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				match(T__60);
				setState(501);
				termo_logico();
				setState(502);
				outros_termos_logicos();
				}
				break;
			case T__1:
			case T__8:
			case T__9:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__48:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Outros_fatores_logicosContext extends ParserRuleContext {
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Outros_fatores_logicosContext outros_fatores_logicos() {
			return getRuleContext(Outros_fatores_logicosContext.class,0);
		}
		public Outros_fatores_logicosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outros_fatores_logicos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterOutros_fatores_logicos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitOutros_fatores_logicos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitOutros_fatores_logicos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Outros_fatores_logicosContext outros_fatores_logicos() throws RecognitionException {
		Outros_fatores_logicosContext _localctx = new Outros_fatores_logicosContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_outros_fatores_logicos);
		try {
			setState(512);
			switch (_input.LA(1)) {
			case T__61:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				match(T__61);
				setState(508);
				fator_logico();
				setState(509);
				outros_fatores_logicos();
				}
				break;
			case T__1:
			case T__8:
			case T__9:
			case T__25:
			case T__26:
			case T__28:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
			case T__37:
			case T__38:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__48:
			case T__60:
			case IDENT:
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fator_logicoContext extends ParserRuleContext {
		public Op_naoContext op_nao() {
			return getRuleContext(Op_naoContext.class,0);
		}
		public Parcela_logicaContext parcela_logica() {
			return getRuleContext(Parcela_logicaContext.class,0);
		}
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitFator_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitFator_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_fator_logico);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			op_nao();
			setState(515);
			parcela_logica();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parcela_logicaContext extends ParserRuleContext {
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).enterParcela_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GramarLAListener ) ((GramarLAListener)listener).exitParcela_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GramarLAVisitor ) return ((GramarLAVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_parcela_logica);
		try {
			setState(520);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				match(T__21);
				}
				break;
			case T__9:
			case T__24:
			case T__48:
			case T__52:
			case IDENT:
			case NUM_INT:
			case NUM_REAL:
			case CADEIA:
				enterOuterAlt(_localctx, 3);
				{
				setState(519);
				exp_relacional();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3F\u020d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\u0086\n\3\3\4\3\4\5\4\u008a"+
		"\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0099\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a7\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\5\t\u00b1\n\t\3\n\3\n\3\n\5\n\u00b6\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u00be\n\13\3\f\3\f\5\f\u00c2\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16\3\16\5\16\u00cf\n\16\3\17"+
		"\3\17\3\20\3\20\5\20\u00d5\n\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00e4\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00fa\n\25\3\26\3\26\5\26\u00fe\n\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\5\30\u0109\n\30\3\31\3\31\3\31\5\31\u010e\n\31\3\32"+
		"\3\32\3\32\3\32\5\32\u0114\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\5\34"+
		"\u011d\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u0159\n\35\3\36\3\36\3\36\3\36\3\36\5\36\u0160"+
		"\n\36\3\37\3\37\3\37\5\37\u0165\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u0170"+
		"\n \3!\3!\3!\3!\5!\u0176\n!\3\"\3\"\3\"\3\"\3\"\3#\3#\5#\u017f\n#\3$\3"+
		"$\3$\3%\3%\3%\5%\u0187\n%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u0192\n"+
		"\'\3(\3(\5(\u0196\n(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\5-\u01a7"+
		"\n-\3.\3.\3.\3/\3/\3/\3/\3/\5/\u01b1\n/\3\60\3\60\3\60\3\60\5\60\u01b7"+
		"\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\5\61\u01c6\n\61\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u01ce\n\62\3\63\3"+
		"\63\3\63\3\63\3\63\5\63\u01d5\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\5\64\u01e0\n\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\5\66\u01e9"+
		"\n\66\3\67\3\67\38\38\38\39\39\59\u01f2\n9\3:\3:\3:\3;\3;\3;\3;\3;\5;"+
		"\u01fc\n;\3<\3<\3<\3<\3<\5<\u0203\n<\3=\3=\3=\3>\3>\3>\5>\u020b\n>\3>"+
		"\2\2?\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz\2\7\3\2\20\23\3\2\24\30\3\2\64\65\4\2"+
		"\63\63\66\66\4\2\b\b9=\u0204\2|\3\2\2\2\4\u0085\3\2\2\2\6\u0089\3\2\2"+
		"\2\b\u0098\3\2\2\2\n\u009a\3\2\2\2\f\u00a6\3\2\2\2\16\u00a8\3\2\2\2\20"+
		"\u00b0\3\2\2\2\22\u00b5\3\2\2\2\24\u00bd\3\2\2\2\26\u00c1\3\2\2\2\30\u00c8"+
		"\3\2\2\2\32\u00ce\3\2\2\2\34\u00d0\3\2\2\2\36\u00d4\3\2\2\2 \u00d6\3\2"+
		"\2\2\"\u00d9\3\2\2\2$\u00db\3\2\2\2&\u00e3\3\2\2\2(\u00f9\3\2\2\2*\u00fd"+
		"\3\2\2\2,\u00ff\3\2\2\2.\u0108\3\2\2\2\60\u010d\3\2\2\2\62\u0113\3\2\2"+
		"\2\64\u0115\3\2\2\2\66\u011c\3\2\2\28\u0158\3\2\2\2:\u015f\3\2\2\2<\u0164"+
		"\3\2\2\2>\u016f\3\2\2\2@\u0175\3\2\2\2B\u0177\3\2\2\2D\u017e\3\2\2\2F"+
		"\u0180\3\2\2\2H\u0186\3\2\2\2J\u0188\3\2\2\2L\u0191\3\2\2\2N\u0195\3\2"+
		"\2\2P\u0197\3\2\2\2R\u019a\3\2\2\2T\u019c\3\2\2\2V\u019e\3\2\2\2X\u01a6"+
		"\3\2\2\2Z\u01a8\3\2\2\2\\\u01b0\3\2\2\2^\u01b6\3\2\2\2`\u01c5\3\2\2\2"+
		"b\u01cd\3\2\2\2d\u01d4\3\2\2\2f\u01df\3\2\2\2h\u01e1\3\2\2\2j\u01e8\3"+
		"\2\2\2l\u01ea\3\2\2\2n\u01ec\3\2\2\2p\u01f1\3\2\2\2r\u01f3\3\2\2\2t\u01fb"+
		"\3\2\2\2v\u0202\3\2\2\2x\u0204\3\2\2\2z\u020a\3\2\2\2|}\5\4\3\2}~\7\3"+
		"\2\2~\177\5\64\33\2\177\u0080\7\4\2\2\u0080\3\3\2\2\2\u0081\u0082\5\6"+
		"\4\2\u0082\u0083\5\4\3\2\u0083\u0086\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0081\3\2\2\2\u0085\u0084\3\2\2\2\u0086\5\3\2\2\2\u0087\u008a\5\b\5\2"+
		"\u0088\u008a\5(\25\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\7\3"+
		"\2\2\2\u008b\u008c\7\5\2\2\u008c\u0099\5\n\6\2\u008d\u008e\7\6\2\2\u008e"+
		"\u008f\7A\2\2\u008f\u0090\7\7\2\2\u0090\u0091\5\34\17\2\u0091\u0092\7"+
		"\b\2\2\u0092\u0093\5\"\22\2\u0093\u0099\3\2\2\2\u0094\u0095\7\t\2\2\u0095"+
		"\u0096\7\n\2\2\u0096\u0097\7\7\2\2\u0097\u0099\5\26\f\2\u0098\u008b\3"+
		"\2\2\2\u0098\u008d\3\2\2\2\u0098\u0094\3\2\2\2\u0099\t\3\2\2\2\u009a\u009b"+
		"\7A\2\2\u009b\u009c\5\24\13\2\u009c\u009d\5\f\7\2\u009d\u009e\7\7\2\2"+
		"\u009e\u009f\5\26\f\2\u009f\13\3\2\2\2\u00a0\u00a1\7\13\2\2\u00a1\u00a2"+
		"\7A\2\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4\5\f\7\2\u00a4\u00a7\3\2\2\2"+
		"\u00a5\u00a7\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\r\3"+
		"\2\2\2\u00a8\u00a9\5\20\t\2\u00a9\u00aa\7A\2\2\u00aa\u00ab\5\24\13\2\u00ab"+
		"\u00ac\5\22\n\2\u00ac\17\3\2\2\2\u00ad\u00ae\7\f\2\2\u00ae\u00b1\5\20"+
		"\t\2\u00af\u00b1\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"\21\3\2\2\2\u00b2\u00b3\7\r\2\2\u00b3\u00b6\5\16\b\2\u00b4\u00b6\3\2\2"+
		"\2\u00b5\u00b2\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\23\3\2\2\2\u00b7\u00b8"+
		"\7\16\2\2\u00b8\u00b9\5P)\2\u00b9\u00ba\7\17\2\2\u00ba\u00bb\5\24\13\2"+
		"\u00bb\u00be\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd\u00bc"+
		"\3\2\2\2\u00be\25\3\2\2\2\u00bf\u00c2\5$\23\2\u00c0\u00c2\5 \21\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\27\3\2\2\2\u00c3\u00c4\7\13\2"+
		"\2\u00c4\u00c5\5\16\b\2\u00c5\u00c6\5\30\r\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c9\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\31\3\2\2"+
		"\2\u00ca\u00cb\5\n\6\2\u00cb\u00cc\5\32\16\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\33\3\2\2"+
		"\2\u00d0\u00d1\t\2\2\2\u00d1\35\3\2\2\2\u00d2\u00d5\5\34\17\2\u00d3\u00d5"+
		"\7A\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\37\3\2\2\2\u00d6"+
		"\u00d7\5\20\t\2\u00d7\u00d8\5\36\20\2\u00d8!\3\2\2\2\u00d9\u00da\t\3\2"+
		"\2\u00da#\3\2\2\2\u00db\u00dc\5&\24\2\u00dc%\3\2\2\2\u00dd\u00de\5\n\6"+
		"\2\u00de\u00df\5\32\16\2\u00df\u00e0\7\31\2\2\u00e0\u00e1\5&\24\2\u00e1"+
		"\u00e4\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00dd\3\2\2\2\u00e3\u00e2\3\2"+
		"\2\2\u00e4\'\3\2\2\2\u00e5\u00e6\7\32\2\2\u00e6\u00e7\7A\2\2\u00e7\u00e8"+
		"\7\33\2\2\u00e8\u00e9\5*\26\2\u00e9\u00ea\7\34\2\2\u00ea\u00eb\5\62\32"+
		"\2\u00eb\u00ec\5\66\34\2\u00ec\u00ed\7\35\2\2\u00ed\u00fa\3\2\2\2\u00ee"+
		"\u00ef\7\36\2\2\u00ef\u00f0\7A\2\2\u00f0\u00f1\7\33\2\2\u00f1\u00f2\5"+
		"*\26\2\u00f2\u00f3\7\34\2\2\u00f3\u00f4\7\7\2\2\u00f4\u00f5\5 \21\2\u00f5"+
		"\u00f6\5\62\32\2\u00f6\u00f7\5\66\34\2\u00f7\u00f8\7\37\2\2\u00f8\u00fa"+
		"\3\2\2\2\u00f9\u00e5\3\2\2\2\u00f9\u00ee\3\2\2\2\u00fa)\3\2\2\2\u00fb"+
		"\u00fe\5,\27\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe+\3\2\2\2\u00ff\u0100\5.\30\2\u0100\u0101\5\16\b\2\u0101\u0102"+
		"\5\30\r\2\u0102\u0103\7\7\2\2\u0103\u0104\5 \21\2\u0104\u0105\5\60\31"+
		"\2\u0105-\3\2\2\2\u0106\u0109\7 \2\2\u0107\u0109\3\2\2\2\u0108\u0106\3"+
		"\2\2\2\u0108\u0107\3\2\2\2\u0109/\3\2\2\2\u010a\u010b\7\13\2\2\u010b\u010e"+
		"\5,\27\2\u010c\u010e\3\2\2\2\u010d\u010a\3\2\2\2\u010d\u010c\3\2\2\2\u010e"+
		"\61\3\2\2\2\u010f\u0110\5\b\5\2\u0110\u0111\5\62\32\2\u0111\u0114\3\2"+
		"\2\2\u0112\u0114\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\63\3\2\2\2\u0115\u0116\5\62\32\2\u0116\u0117\5\66\34\2\u0117\65\3\2\2"+
		"\2\u0118\u0119\58\35\2\u0119\u011a\5\66\34\2\u011a\u011d\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u011b\3\2\2\2\u011d\67\3\2\2"+
		"\2\u011e\u011f\7!\2\2\u011f\u0120\7\33\2\2\u0120\u0121\5\16\b\2\u0121"+
		"\u0122\5\30\r\2\u0122\u0123\7\34\2\2\u0123\u0159\3\2\2\2\u0124\u0125\7"+
		"\"\2\2\u0125\u0126\7\33\2\2\u0126\u0127\5n8\2\u0127\u0128\5:\36\2\u0128"+
		"\u0129\7\34\2\2\u0129\u0159\3\2\2\2\u012a\u012b\7#\2\2\u012b\u012c\5n"+
		"8\2\u012c\u012d\7$\2\2\u012d\u012e\5\66\34\2\u012e\u012f\5<\37\2\u012f"+
		"\u0130\7%\2\2\u0130\u0159\3\2\2\2\u0131\u0132\7&\2\2\u0132\u0133\5P)\2"+
		"\u0133\u0134\7\'\2\2\u0134\u0135\5B\"\2\u0135\u0136\5<\37\2\u0136\u0137"+
		"\7(\2\2\u0137\u0159\3\2\2\2\u0138\u0139\7)\2\2\u0139\u013a\7A\2\2\u013a"+
		"\u013b\7*\2\2\u013b\u013c\5P)\2\u013c\u013d\7+\2\2\u013d\u013e\5P)\2\u013e"+
		"\u013f\7,\2\2\u013f\u0140\5\66\34\2\u0140\u0141\7-\2\2\u0141\u0159\3\2"+
		"\2\2\u0142\u0143\7.\2\2\u0143\u0144\5n8\2\u0144\u0145\7,\2\2\u0145\u0146"+
		"\5\66\34\2\u0146\u0147\7/\2\2\u0147\u0159\3\2\2\2\u0148\u0149\7,\2\2\u0149"+
		"\u014a\5\66\34\2\u014a\u014b\7+\2\2\u014b\u014c\5n8\2\u014c\u0159\3\2"+
		"\2\2\u014d\u014e\7\f\2\2\u014e\u014f\7A\2\2\u014f\u0150\5\22\n\2\u0150"+
		"\u0151\5\24\13\2\u0151\u0152\7*\2\2\u0152\u0153\5n8\2\u0153\u0159\3\2"+
		"\2\2\u0154\u0155\7A\2\2\u0155\u0159\5> \2\u0156\u0157\7\60\2\2\u0157\u0159"+
		"\5n8\2\u0158\u011e\3\2\2\2\u0158\u0124\3\2\2\2\u0158\u012a\3\2\2\2\u0158"+
		"\u0131\3\2\2\2\u0158\u0138\3\2\2\2\u0158\u0142\3\2\2\2\u0158\u0148\3\2"+
		"\2\2\u0158\u014d\3\2\2\2\u0158\u0154\3\2\2\2\u0158\u0156\3\2\2\2\u0159"+
		"9\3\2\2\2\u015a\u015b\7\13\2\2\u015b\u015c\5n8\2\u015c\u015d\5:\36\2\u015d"+
		"\u0160\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u015a\3\2\2\2\u015f\u015e\3\2"+
		"\2\2\u0160;\3\2\2\2\u0161\u0162\7\61\2\2\u0162\u0165\5\66\34\2\u0163\u0165"+
		"\3\2\2\2\u0164\u0161\3\2\2\2\u0164\u0163\3\2\2\2\u0165=\3\2\2\2\u0166"+
		"\u0167\7\33\2\2\u0167\u0168\5@!\2\u0168\u0169\7\34\2\2\u0169\u0170\3\2"+
		"\2\2\u016a\u016b\5\22\n\2\u016b\u016c\5\24\13\2\u016c\u016d\7*\2\2\u016d"+
		"\u016e\5n8\2\u016e\u0170\3\2\2\2\u016f\u0166\3\2\2\2\u016f\u016a\3\2\2"+
		"\2\u0170?\3\2\2\2\u0171\u0172\5n8\2\u0172\u0173\5:\36\2\u0173\u0176\3"+
		"\2\2\2\u0174\u0176\3\2\2\2\u0175\u0171\3\2\2\2\u0175\u0174\3\2\2\2\u0176"+
		"A\3\2\2\2\u0177\u0178\5F$\2\u0178\u0179\7\7\2\2\u0179\u017a\5\66\34\2"+
		"\u017a\u017b\5D#\2\u017bC\3\2\2\2\u017c\u017f\5B\"\2\u017d\u017f\3\2\2"+
		"\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017fE\3\2\2\2\u0180\u0181"+
		"\5J&\2\u0181\u0182\5H%\2\u0182G\3\2\2\2\u0183\u0184\7\13\2\2\u0184\u0187"+
		"\5F$\2\u0185\u0187\3\2\2\2\u0186\u0183\3\2\2\2\u0186\u0185\3\2\2\2\u0187"+
		"I\3\2\2\2\u0188\u0189\5N(\2\u0189\u018a\7B\2\2\u018a\u018b\5L\'\2\u018b"+
		"K\3\2\2\2\u018c\u018d\7\62\2\2\u018d\u018e\5N(\2\u018e\u018f\7B\2\2\u018f"+
		"\u0192\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u018c\3\2\2\2\u0191\u0190\3\2"+
		"\2\2\u0192M\3\2\2\2\u0193\u0196\7\63\2\2\u0194\u0196\3\2\2\2\u0195\u0193"+
		"\3\2\2\2\u0195\u0194\3\2\2\2\u0196O\3\2\2\2\u0197\u0198\5V,\2\u0198\u0199"+
		"\5X-\2\u0199Q\3\2\2\2\u019a\u019b\t\4\2\2\u019bS\3\2\2\2\u019c\u019d\t"+
		"\5\2\2\u019dU\3\2\2\2\u019e\u019f\5Z.\2\u019f\u01a0\5\\/\2\u01a0W\3\2"+
		"\2\2\u01a1\u01a2\5T+\2\u01a2\u01a3\5V,\2\u01a3\u01a4\5X-\2\u01a4\u01a7"+
		"\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6\u01a1\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7"+
		"Y\3\2\2\2\u01a8\u01a9\5^\60\2\u01a9\u01aa\5d\63\2\u01aa[\3\2\2\2\u01ab"+
		"\u01ac\5R*\2\u01ac\u01ad\5Z.\2\u01ad\u01ae\5\\/\2\u01ae\u01b1\3\2\2\2"+
		"\u01af\u01b1\3\2\2\2\u01b0\u01ab\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1]\3"+
		"\2\2\2\u01b2\u01b3\5N(\2\u01b3\u01b4\5`\61\2\u01b4\u01b7\3\2\2\2\u01b5"+
		"\u01b7\5b\62\2\u01b6\u01b2\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7_\3\2\2\2"+
		"\u01b8\u01b9\7\f\2\2\u01b9\u01ba\7A\2\2\u01ba\u01bb\5\22\n\2\u01bb\u01bc"+
		"\5\24\13\2\u01bc\u01c6\3\2\2\2\u01bd\u01be\7A\2\2\u01be\u01c6\5f\64\2"+
		"\u01bf\u01c6\7B\2\2\u01c0\u01c6\7C\2\2\u01c1\u01c2\7\33\2\2\u01c2\u01c3"+
		"\5n8\2\u01c3\u01c4\7\34\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01b8\3\2\2\2\u01c5"+
		"\u01bd\3\2\2\2\u01c5\u01bf\3\2\2\2\u01c5\u01c0\3\2\2\2\u01c5\u01c1\3\2"+
		"\2\2\u01c6a\3\2\2\2\u01c7\u01c8\7\67\2\2\u01c8\u01c9\7A\2\2\u01c9\u01ca"+
		"\5\22\n\2\u01ca\u01cb\5\24\13\2\u01cb\u01ce\3\2\2\2\u01cc\u01ce\7D\2\2"+
		"\u01cd\u01c7\3\2\2\2\u01cd\u01cc\3\2\2\2\u01cec\3\2\2\2\u01cf\u01d0\7"+
		"8\2\2\u01d0\u01d1\5^\60\2\u01d1\u01d2\5d\63\2\u01d2\u01d5\3\2\2\2\u01d3"+
		"\u01d5\3\2\2\2\u01d4\u01cf\3\2\2\2\u01d4\u01d3\3\2\2\2\u01d5e\3\2\2\2"+
		"\u01d6\u01d7\7\33\2\2\u01d7\u01d8\5n8\2\u01d8\u01d9\5:\36\2\u01d9\u01da"+
		"\7\34\2\2\u01da\u01e0\3\2\2\2\u01db\u01dc\5\22\n\2\u01dc\u01dd\5\24\13"+
		"\2\u01dd\u01e0\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01d6\3\2\2\2\u01df\u01db"+
		"\3\2\2\2\u01df\u01de\3\2\2\2\u01e0g\3\2\2\2\u01e1\u01e2\5P)\2\u01e2\u01e3"+
		"\5j\66\2\u01e3i\3\2\2\2\u01e4\u01e5\5l\67\2\u01e5\u01e6\5P)\2\u01e6\u01e9"+
		"\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8\u01e4\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9"+
		"k\3\2\2\2\u01ea\u01eb\t\6\2\2\u01ebm\3\2\2\2\u01ec\u01ed\5r:\2\u01ed\u01ee"+
		"\5t;\2\u01eeo\3\2\2\2\u01ef\u01f2\7>\2\2\u01f0\u01f2\3\2\2\2\u01f1\u01ef"+
		"\3\2\2\2\u01f1\u01f0\3\2\2\2\u01f2q\3\2\2\2\u01f3\u01f4\5x=\2\u01f4\u01f5"+
		"\5v<\2\u01f5s\3\2\2\2\u01f6\u01f7\7?\2\2\u01f7\u01f8\5r:\2\u01f8\u01f9"+
		"\5t;\2\u01f9\u01fc\3\2\2\2\u01fa\u01fc\3\2\2\2\u01fb\u01f6\3\2\2\2\u01fb"+
		"\u01fa\3\2\2\2\u01fcu\3\2\2\2\u01fd\u01fe\7@\2\2\u01fe\u01ff\5x=\2\u01ff"+
		"\u0200\5v<\2\u0200\u0203\3\2\2\2\u0201\u0203\3\2\2\2\u0202\u01fd\3\2\2"+
		"\2\u0202\u0201\3\2\2\2\u0203w\3\2\2\2\u0204\u0205\5p9\2\u0205\u0206\5"+
		"z>\2\u0206y\3\2\2\2\u0207\u020b\7\27\2\2\u0208\u020b\7\30\2\2\u0209\u020b"+
		"\5h\65\2\u020a\u0207\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u0209\3\2\2\2\u020b"+
		"{\3\2\2\2)\u0085\u0089\u0098\u00a6\u00b0\u00b5\u00bd\u00c1\u00c8\u00ce"+
		"\u00d4\u00e3\u00f9\u00fd\u0108\u010d\u0113\u011c\u0158\u015f\u0164\u016f"+
		"\u0175\u017e\u0186\u0191\u0195\u01a6\u01b0\u01b6\u01c5\u01cd\u01d4\u01df"+
		"\u01e8\u01f1\u01fb\u0202\u020a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}