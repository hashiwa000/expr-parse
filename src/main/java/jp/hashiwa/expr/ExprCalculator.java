package jp.hashiwa.expr;

import jp.hashiwa.antlr4.ExprLexer;
import jp.hashiwa.antlr4.ExprParser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by Hashiwa on 2016/02/18.
 */
public class ExprCalculator {
  public static final boolean DEBUG = false;

  public static void main(String[] args) throws Exception {
    String filename = "resources/text.txt";
    ExprLexer lexer = new ExprLexer(new ANTLRFileStream(filename));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExprParser parser = new ExprParser(tokens);
    ParseTree tree = parser.prog();
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(new ExprWalker(), tree);

    ExprCalculator calculator = new ExprCalculator();
    System.out.println("Result : " + tree.getText().replace("\r\n", "") + " = " + calculator.calc(tree));
  }

  private int calc(ParseTree tree) {
    if (DEBUG) System.out.println("DEBUG 0 " + tree.getText());

    int len = tree.getChildCount();
    if (len == 0) {
      throw new Error("length is 0");
    } else {
      String firstText = tree.getChild(0).getText();
      if ("(".equals(firstText)) {
        return calc0(tree, 1, len-2);
      } else {
        return calc0(tree, 0, len);
      }
    }
  }

  private int calc0(ParseTree tree, int start, int offset) {
    if (DEBUG) System.out.println("DEBUG 1 " + tree.getText());
    ParseTree child1 = tree.getChild(start);
    int value1 = getValue(child1);
    if (DEBUG) System.out.println("DEBUG 2 " + value1);
    for (int i=start+1 ; i<start+offset ; i+=2) {
      String operator = tree.getChild(i).getText();
      if (DEBUG) System.out.println("DEBUG op " + operator);

      if ("\r\n".equals(operator)) {
        continue;
      }

      ParseTree childTmp = tree.getChild(i+1);
      int valueTmp = getValue(childTmp);
      if (DEBUG) System.out.println("DEBUG 3 " + valueTmp);
      switch (operator) {
        case "+":
          value1 += valueTmp;
          break;
        case "-":
          value1 -= valueTmp;
          break;
        case "*":
          value1 *= valueTmp;
          break;
        case "/":
          value1 /= valueTmp;
          break;
        default:
          throw new Error(operator + " is invalid operator.");
      }
    }
    return value1;
  }

  private int getValue(ParseTree tree) {
    String valueStr = tree.getText();
    if (DEBUG) System.out.println("DEBUG 4 " + valueStr);

    try {
      int value = Integer.parseInt(valueStr);
      if (DEBUG) System.out.println("DEBUG   return2 " + value);
      return value;
    } catch(NumberFormatException e) {}

    if (DEBUG) System.out.println("DEBUG 5 " + valueStr);
    return calc(tree);
  }
}
