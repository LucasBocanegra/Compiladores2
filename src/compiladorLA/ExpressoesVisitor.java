// Generated from Expressoes.g4 by ANTLR 4.5.3
package compiladorLA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressoesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressoesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressoesParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(ExpressoesParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressoesParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(ExpressoesParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressoesParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(ExpressoesParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressoesParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(ExpressoesParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressoesParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(ExpressoesParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressoesParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(ExpressoesParser.Op2Context ctx);
}