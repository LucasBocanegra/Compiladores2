// Generated from Expressoes.g4 by ANTLR 4.5.3
package compiladorLA;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressoesParser}.
 */
public interface ExpressoesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ExpressoesParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ExpressoesParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(ExpressoesParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(ExpressoesParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(ExpressoesParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(ExpressoesParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(ExpressoesParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(ExpressoesParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(ExpressoesParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(ExpressoesParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressoesParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(ExpressoesParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressoesParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(ExpressoesParser.Op2Context ctx);
}