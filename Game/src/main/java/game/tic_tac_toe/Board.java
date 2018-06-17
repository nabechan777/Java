package game.tic_tac_toe;

import java.util.stream.Stream;
import game.tic_tac_toe.Color;
import game.tic_tac_toe.Mass;

/**
 * ボードクラス
 *
 */
public class Board {
    private int width;
    private int height;
    private Mass[][] board;


    /**
     * Boardインスタンスを生成する。
     * @param w 横方向のマスの数
     * @param h 縦方向のマスの数
     */
    public Board(int w, int h){
        this.board = new Mass[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                this.board[i][j] = new Mass(null);
            }
        }
    }

    /**
     * 正方形型のBoardインスタンスを生成する。
     * @param size 縦横のマスの数
     */
    public Board(int size){
        this(size, size);
    }

    /**
     * 勝利判定のロジック
     * @param  x     マスの横方向の位置
     * @param  y     マスの縦方向の位置
     * @param  color 勝利判定をする色
     * @param  dx    横方向の変化量
     * @param  dy    縦方向の変化量
     * @return       任意の方向の直線に並ぶマスの色が引数の色と同じであればtrue、そうでなければfalse
     */
    private boolean judgement(int x, int y, Color color, int dx, int dy) {
        x += dx;
        y += dy;

        boolean res = ((0 <= x && x < this.board.length) && (0 <= y && y < this.board[x].length)) ? true : false;

        for (int i = x, j = y; (0 <= i && i < this.board.length) && (0 <= j && j < this.board[i].length); i += dx, j += dy) {
            res &= this.board[i][j].getColor().map(mass -> (mass == color) ? true : false).orElse(false);
        }

        return res;
    }

    /**
     * 左右の勝利判定をする。
     * @param  x     マスの横方向の位置
     * @param  y     マスの縦方向の位置
     * @param  color 勝利判定をする色
     * @return       左右の色が引数の色と同じ場合true、そうでなければfalse
     */
    private boolean holizontal(int x, int y, Color color){
        boolean positive = judgement(x, y, color, 1, 0);
        boolean negative = judgement(x, y, color, -1, 0);
        return positive || negative;
    }

    /**
     * 上下の勝利判定をする。
     * @param  x     マスの横方向の位置
     * @param  y     マスの縦方向の位置
     * @param  color 勝利判定をする色
     * @return       上下のマスが引数の色と同じ場合true、そうでなければfalse
     */
    private boolean vertical(int x, int y, Color color){
        boolean positive = judgement(x, y, color, 0, 1);
        boolean negative = judgement(x, y, color, 0, -1);
        return positive || negative;
    }

    /**
     * 斜めの勝利判定をする。
     * @param  x     マスの横方向の位置
     * @param  y     マスの縦方向の位置
     * @param  color 勝利判定する色
     * @return       斜めのマスが引数の色と同じ場合true、そうでなければfalse
     */
    private boolean diagonal(int x, int y, Color color) {
        boolean positiveOfRightUp = judgement(x, y, color, 1, 1);
        boolean positiveOfRightDown = judgement(x, y, color, 1, -1);
        boolean negativeOfRightUp = judgement(x, y, color, -1, -1);
        boolean negativeOfRightDown = judgement(x, y, color, -1, 1);
        boolean rightUp = positiveOfRightUp || negativeOfRightUp;
        boolean rightDown = positiveOfRightDown || negativeOfRightDown;
        return rightUp || rightDown;
    }

    /**
     * 任意のマスを中心に勝利判定をする。<br>
     * 各方向の勝利判定は別のメソッドで行う。<br>
     * 横方向の判定  ：{@link game.tic_tac_toe.Board#holizontal(int, int, Color)}<br>
     * 縦方向の判定  ：{@link game.tic_tac_toe.Board#vertical(int, int, Color)}<br>
     * 斜め方向の判定：{@link game.tic_tac_toe.Board#diagonal(int, int, Color)}<br>
     * @param  x     マスの横方向の位置
     * @param  y     マスの縦方向の位置
     * @param  color 勝利判定をする色
     * @return       勝負が決まった場合true, そうでなければfalse
     */
    public boolean whetherWin(int x, int y, Color color){
        boolean h = holizontal(x, y, color);
        boolean v = vertical(x, y, color);
        boolean d = diagonal(x, y, color);
        return h || v || d;
    }

    /**
     * 任意のマスの色を変更する。
     * @param x     横方向のマスの位置
     * @param y     縦方向のマスの位置
     * @param color マスの色
     */
    public void changeColor(int x, int y, Color color) {
        this.board[x][y].changeColor(color);
    }

    @Override
    public String toString(){
        String res = Stream.of(this.board).map(row -> {
            return Stream.of(row).map(mass -> {
                return mass.toString();
            }).reduce("", (x, y) -> x + y + " ");
        }).reduce("", (x, y) -> x + y + "\n");
        return res;
    }

    public static void main(String ... args) {
        Board target = new Board(3);
        System.out.println(target);
        target.changeColor(0, 0, Color.BLACK);
        target.changeColor(1, 0, Color.BLACK);
        target.changeColor(2, 0, Color.BLACK);
        System.out.println(target);
        System.out.println("whetherWin: " + String.valueOf(target.whetherWin(0, 0, Color.BLACK)));
        System.out.println("holizontal: " + String.valueOf(target.holizontal(0, 0, Color.BLACK)));
        System.out.println("vertical: " + String.valueOf(target.vertical(0, 0, Color.BLACK)));
        System.out.println("diagonal: " + String.valueOf(target.diagonal(0, 0, Color.BLACK)));
    }
}
