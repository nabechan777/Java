
package lexer;

/**
 数値（整数）を意味する字句を示すクラス
 @see Token
*/
public class Num extends Token {
    public final int value;

    /**
     スーパークラスのコンストラクタの呼び出しとフィールドの初期化を行う。
     @param value Numが持つ数値
     @return Numのインスタンス
    */
    public Num (int value) {
        super (Tag.NUM);
        this.value = value;
    }

    @Override
    public String toString (){
        return "Num: " + String.valueOf (value);
    }
}
