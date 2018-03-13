
import java.io.*;
import java.util.*;
import lexer.Token;
import lexer.Lexer;
import parser.Parser;

public class Main {
    public static void main (String... args) throws IOException {
        // BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        Lexer lexer = new Lexer (System.in);
        Parser parser = new Parser (lexer);
        parser.parse ();
        System.out.write ('\n');
    }
}
