
package lexer;

import java.io.*;
import java.util.*;
import java.util.function.*;

/**
 字句解析を行うクラス
*/

public class Lexer {
    /**
     ファイルの行数を示す整数
    */
    public int line;
    // 現在のアルファベット
    private int peek;
    // 入力バッファ
    private final BufferedReader buffer;
    // 記号表
    Hashtable<String, Word> words;

    {
        line = 1;
        peek = ' ';
        words = new Hashtable<> ();
    }

    /**
     フィールドの初期化を行う。
     @param inputStream 字句を取得するStream
     @return Lexerのインスタンス
     @see InputStream
    */
    public Lexer (InputStream inputStream){
        // Consumer<Word> reserve = (Word t) -> words.put (t.lexeme, t);
        buffer = new BufferedReader (new InputStreamReader (inputStream));
    }


    private Token scan () throws IOException {
        while ((peek = buffer.read()) != -1) {
            if ((char)peek == ' ' || (char)peek == '\t') {
                continue;
            } else if ((char)peek == '\n') {
                line = line + 1;
                continue;
            } else {
                if (Character.isDigit((char)peek)) {
                    innt v = 0;
                    do {
                        v = v * 10 + Character.digit((char)peek, 10);
                        buffer.mark(1);
                        peek = buffer.read();
                    } while (Character.isDigit((char)peek));
                    buffer.reset();
                    return (new Num(v));
                } else if (Character.isLetter((char)peek)) {
                    StringBuffer b = new StringBuffer();
                    do {
                        b.append((char)peek);
                        buffer.mark(1);
                        peek = buffer.read();
                    } while (Character.isLetterOrDigit((char)peek));
                    buffer.reset();
                    String s = b.toString();
                    Word w = words.get(s);
                    if (w == null) {
                        w = new Word(Tag.ID, s);
                        words.put(s, w);
                    }
                    return w;
                } else if ((char)peek == '+') {
                    return (new Token(Tag.ADD));
                } else if ((char)peek == '-') {
                    return (new Token(Tag.SUB));
                } else {
                    return (new Token(Tag.UNDEFINED));
                }
            }
        }
        return (new Token(Tag.EOF));
    }

    /**
     字句解析を行い、その結果をTokenとして返すメソッド
     @return Tokenクラスのインスタンス
     @see Token
     @see IOException
    */
    public Token getNextToken () throws IOException{
        Token res = scan ();
        return res;
    }

    @Override
    public String toString () {
        String lineString   = "line = "   + String.valueOf(line);
        String peekString   = "peek = "   + String.valueOf(peek);
        String bufferString = "buffer = " + buffer.toString();
        String wordsString  = "words = "  + words.toString();
        return "Lexer { " + lineString + ", " + peekString + ", " + bufferString + ", " + wordsString + " }";
    }

    /**
     Lexerクラスの簡単なテスト
    */
    public static void main (String... args) throws IOException {
        Lexer lexer = new Lexer (new FileInputStream(new File(args[0])));
        List<Token> res = new ArrayList<>();
        for (Token token = lexer.getNextToken(); token.tag != Tag.EOF; token = lexer.getNextToken()) {
            res.add(token);
        }
        System.out.println(res);
    }
}
