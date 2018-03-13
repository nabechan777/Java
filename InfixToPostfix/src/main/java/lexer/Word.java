package lexer;

/**
 識別子または予約語を示すクラス。
 @see Token
*/
public class Word extends Token {
    /**
     識別子または予約語を意味する文字列
    */
    public final String lexeme;

    /**
     スーパークラスのコンストラクタの呼び出しとフィールドの初期化を行う。
     @param tag 字句の種類
     @param s 識別子または予約語の文字列
     @return Wordのインスタンス
    */
    public Word (Tag tag, String s) {
        super (tag);
        lexeme = new String (s);
    }

    @Override
    public String toString (){
        return "Word: " + lexeme;
    }
}
