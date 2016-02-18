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
public class Main {
  public static void main(String[] args) throws Exception {
    String filename = "resources/text.txt";
    ExprLexer lexer = new ExprLexer(new ANTLRFileStream(filename));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExprParser parser = new ExprParser(tokens);
    ParseTree tree = parser.prog();
    ParseTreeWalker walker = new ParseTreeWalker();
    walker.walk(new ExprWalker(), tree);

  }
}
