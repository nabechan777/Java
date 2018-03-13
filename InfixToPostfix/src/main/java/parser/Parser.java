
package parser;

import java.io.*;
import java.util.*;
import lexer.*;

/**
 下向き構文解析を行うクラス
*/
public class Parser {
    /**
     先読みトークン
    */
    static Token lookahead;
    /**
     字句解析器
    */
    static Lexer lexer;

    /**
     先読みトークンの初期化(lexer.getNextToken()の呼び出し)と字句解析器の初期化を行う。
     @param lexer 字句解析器
    */
    public Parser (Lexer lexer) throws IOException {
        lookahead = lexer.getNextToken ();
        Parser.lexer = lexer;
    }

    /**
     構文解析を行う。
     開始記号は式である。
    */
    public void parse () throws IOException {
        this.expr ();
    }

    /**
     式を示す構文木を構築する。
     @throws java.io.IOException 構文エラーを示す。
    */
    void expr () throws IOException {
        term ();
        while(true) {
            if(lookahead.tag == Tag.ADD) {
                match (lookahead);
                term ();
                System.out.print ('+');
            }else if(lookahead.tag == Tag.SUB){
                match (lookahead);
                term ();
                System.out.print ('-');
            }else{
                return;
            }
        }
    }

    /**
     項を示す構文木を構築する。
     @throws java.io.IOException 構文エラーを示す。
    */
    void term () throws IOException {
        if(lookahead.tag == Tag.NUM) {
            System.out.print (((Num)lookahead).value);
            match (lookahead);
        } else if (lookahead.tag == Tag.EOF) {
            return;
        } else {
            throw new Error ("syntax error");
        }
    }

    /**
     先読みトークンを更新する。
     @throws java.io.IOException 構文エラーを示す。
    */
    void match (Token t) throws IOException {
        if (lookahead.equals (t)) {
            lookahead = lexer.getNextToken ();
        }else{
            throw new Error ("syntax error");
        }
    }

    /**
     Parserクラスの簡単なテスト
    */
    public static void main(String... args) throws IOException{
        Lexer lexer = new Lexer(new FileInputStream(args[0]));
        Parser parser = new Parser(lexer);
        parser.parse();
    }
}
