
package lexer;

/**
    字句の種類を示す列挙型
*/
public enum Tag {
    /**
     入力の終端を示す。
    */
    EOF(-1),
    /**
     未定義の字句を示す。
    */
    UNDEFINED(256),
    /**
     加算記号を示す。
    */
    ADD((int)'+'),
    /**
     原産記号を示す。
    */
    SUB((int)'-'),
    /**
     数値を示す。
    */
    NUM(257),
    /**
     識別子を示す。
    */
    ID(258);

    private final int tag;

    private Tag(int tag){
        this.tag = tag;
    }

}
