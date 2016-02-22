package jp.hashiwa.expr;

import jp.hashiwa.antlr4.ExprBaseListener;
import jp.hashiwa.antlr4.ExprParser;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by Hashiwa on 2016/02/18.
 */
public class ExprWalker extends ExprBaseListener {
  public static final boolean DEBUG = false;

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterProg(ExprParser.ProgContext ctx) {
    if (DEBUG) System.out.println("enterProg: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitProg(ExprParser.ProgContext ctx) {
    if (DEBUG) System.out.println(" exitProg: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterExpr(ExprParser.ExprContext ctx) {
    if (DEBUG) System.out.println("enterExpr: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitExpr(ExprParser.ExprContext ctx) {
    if (DEBUG) System.out.println(" exitExpr: " + ctx.getText());
  }

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterTerm(ExprParser.TermContext ctx) {
    if (DEBUG) System.out.println("enterTerm: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitTerm(ExprParser.TermContext ctx) {
    if (DEBUG) System.out.println(" exitTerm: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterUnary(ExprParser.UnaryContext ctx) {
    if (DEBUG) System.out.println("enterUnary: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitUnary(ExprParser.UnaryContext ctx) {
    if (DEBUG) System.out.println(" exitUnary: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterFactor(ExprParser.FactorContext ctx) {
    if (DEBUG) System.out.println("enterFactor: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitFactor(ExprParser.FactorContext ctx) {
    if (DEBUG) System.out.println(" exitFactor: " + ctx.getText());
  }

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void visitTerminal(TerminalNode node) {
    if (DEBUG) System.out.println("visitTerminal: " + node.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void visitErrorNode(ErrorNode node) {
    if (DEBUG) System.out.println("visitErrorNode: " + node.getText());
  }
}
