package lexer;

/**
 一般的な字句を示すクラス
*/
public class Token {
    /**
     字句の種類
    */
    public final Tag tag;

    /**
     Tokenのコンストラクタ。
     フィールドの初期化を行う。
     @param tag 字句の種類を示す定数オブジェクト
     @return Tokenのインスタンス
     @see Tag
    */
    public Token (Tag tag){
        this.tag = tag;
    }

    @Override
    public String toString (){
        return "Token: " + tag.toString ();
    }
}
