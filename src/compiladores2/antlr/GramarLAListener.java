// Generated from /home/lucas/Documents/bcc/2016/2sem/CC2/Compiladores2/src/compiladores2/antlr/GramarLA.g4 by ANTLR 4.5.3
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
	 * Enter a parse tree produced by {@link GramarLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(GramarLAParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(GramarLAParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link GramarLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(GramarLAParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link GramarLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(GramarLAParser.Op2Context ctx);
}