package game.tic_tac_toe;

import java.util.function.BiFunction;
import java.util.Optional;

public class Mass {
    private int size; // まるばつゲーム用
    public BiFunction<Integer, Integer, Boolean> ofRange;
    private Optional<Color> optColor;

    public Mass(int x, int y, Color color) {
        this.size = 100;
        optColor = Optional.ofNullable(color);
        this.ofRange = makePredicate(x, y);
    }

    public void changeColor(Color color) {
        optColor = Optional.of(color);
    }

    // 領域を判定する関数オブジェクトの生成
    // 座標が線上である場合、Flaseを返す。
    private BiFunction<Integer, Integer, Boolean> makePredicate(int w, int h) {
        return (x, y) -> {
            return (x < w && y < h && x > w - size && y > h - size) ? true : false;
        };
    }

    @Override
    public String toString() {
        return optColor.map(Color::toString).orElse("-");
    }
}
