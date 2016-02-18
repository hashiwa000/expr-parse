package jp.hashiwa.expr;

import jp.hashiwa.antlr4.ExprBaseListener;
import jp.hashiwa.antlr4.ExprParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by Hashiwa on 2016/02/18.
 */
public class ExprWalker extends ExprBaseListener {
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterProg(ExprParser.ProgContext ctx) {
    System.out.println("enterProg: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitProg(ExprParser.ProgContext ctx) {
    System.out.println("exitProg: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterExpr(ExprParser.ExprContext ctx) {
    System.out.println("enterExpr: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitExpr(ExprParser.ExprContext ctx) {
    System.out.println("exitExpr: " + ctx.getText());
  }

  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void enterEveryRule(ParserRuleContext ctx) {
    System.out.println("enterEveryRule: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void exitEveryRule(ParserRuleContext ctx) {
    System.out.println("exitEveryRule: " + ctx.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void visitTerminal(TerminalNode node) {
    System.out.println("visitTerminal: " + node.getText());
  }
  /**
   * {@inheritDoc}
   *
   * <p>The default implementation does nothing.</p>
   */
  @Override public void visitErrorNode(ErrorNode node) {
    System.out.println("visitErrorNode: " + node.getText());
  }
}
