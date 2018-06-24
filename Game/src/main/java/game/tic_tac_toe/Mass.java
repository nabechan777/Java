package game.tic_tac_toe;

import java.util.Optional;

/**
 * ボードに存在する各マスの情報を持つクラス。
 */
public class Mass {
    /**
     * マスを書き始める頂点のx座標
     */
    private int pointX;

    /**
     * マスを書き始める頂点のy座標
     */
    private int pointY;

    /**
     * マスの大きさ（マスを構成する為の辺の長さ）
     */
    private int size;

    /**
     * そのマスが持つ色
     */
    private Optional<Color> optColor;

    /**
     * コンストラクタ
     * @param color マスの色
     */
    public Mass(Color color) {
        optColor = Optional.ofNullable(color);
    }

    /**
     * マスの色を変更する。
     * @param color 変更するマスの色
     */
    public void changeColor(Color color) {
        optColor = Optional.of(color);
    }

    /**
     * マスの色を取得する。
     * @return マスの色を持つOptionalインスタンス
     */
    public Optional<Color> getColor(){
        return optColor;
    }

    public void show() {

    }

    @Override
    public String toString() {
        return optColor.map(Color::toString).orElse("-");
    }
}
