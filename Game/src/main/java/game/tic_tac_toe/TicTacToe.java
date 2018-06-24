package game.tic_tac_toe;

import java.io.*;
import game.util.Player;
import game.tic_tac_toe.Board;

/**
 * 三目並べを行うクラス。<br>
 *
 * @author DaikiWatanabe
 * @version 1.8.161
 */
public class TicTacToe {
    /**
     * 実際にゲームを行うBoardインスタンス
     * @see game.tic_tac_toe.Board
     */
    private Board board;

    /**
     * 標準入力からプレイする場合、このファイルストリームから駒をおく座標を取得する。
     */
    private BufferedReader br;

    /**
     * 現在、駒を置く権利のあるプレイヤーの参照
     */
    private TicTacToePlayer turnPlayer;

    /**
     * ゲームに参加している{@link game.tic_tac_toe.TicTacToePlayer TicTacToePlayer}インスタンス
     */
    private TicTacToePlayer player1;

    /**
     * ゲームに参加しているPlayer{@link game.tic_tac_toe.TicTacToePlayer TicTacToePlayer}インスタンス
     */
    private TicTacToePlayer player2;

    /**
     * 三目並べ（まるばつゲーム）を起動させる。
     * @param player1 プレイヤー1
     * @param player2 プレイヤー2
     */
    public static void start(Player player1, Player player2) {
        int[] point;
        TicTacToePlayer p1 = new TicTacToePlayer(player1, Color.BLACK);
        TicTacToePlayer p2 = new TicTacToePlayer(player2, Color.WHITE);
        TicTacToe game = new TicTacToe(p1, p2);
        try {
            while(true) {
                point = game.stdin();
                game.putStone(point[0], point[1], game.turnPlayer);
                if (game.whetherWin(point[0], point[1], game.turnPlayer)) {
                    String winningMessage = "Congratulation!! " + game.turnPlayer.getName() + " is win !!";
                    System.out.println(game.toString() + "\n" + winningMessage);
                    break;
                }else{
                    System.out.println(game);
                }
                game.changePlayer();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // コンストラクタ
    public TicTacToe(TicTacToePlayer p1, TicTacToePlayer p2){
        this.player1 = p1;
        this.player2 = p2;
        this.turnPlayer = this.player1;
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.board = new Board(3);
    }

    /**
     * プレイヤーの交代（ターンの切り替え）
     * @throws Exception ゲームに参加しているプレイヤー以外の参照を得た時、例外を発生させる。
     */
    private void changePlayer() throws Exception {
        if (turnPlayer == this.player1) {
            turnPlayer = this.player2;
        }else if (turnPlayer == this.player2) {
            turnPlayer = this.player1;
        }else{
            throw new Exception("Exception on changePlayer");
        }
    }

    /**
     * 標準入力から座標を取得する。
     * @return (x, y)の座標を持つ要素数2の配列
     */
    private int[] stdin(){
        int[] res = new int[2];
        try {
            String point = br.readLine();
            res[0] = Integer.valueOf(point.substring(0, point.indexOf(",")));
            res[1] = Integer.valueOf(point.substring(point.indexOf(",") + 1, point.length()));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * ボードに駒をおく。
     * @param x      駒の横方向の位置
     * @param y      駒の縦方向の位置
     * @param player 駒をおくプレイヤー
     */
    public void putStone(int x, int y, TicTacToePlayer player) {
        this.board.changeColor(x, y, player.ofColor());
    }

    /**
     * 勝敗を判定する。<br>
     * 勝敗の判定の実際の実装は、Boardクラスの{@link game.tic_tac_toe.Board#whetherWin(int, int, TicTacToePlayer)}である。
     * @param  x      置いた駒の横方向の位置
     * @param  y      置いた駒の縦方向の位置
     * @param  player 駒を置いたプレイヤー
     * @return        引数のプレイヤーが勝利していればtrue、そうでなければfalse
     */
    public boolean whetherWin(int x, int y, TicTacToePlayer player){
        return this.board.whetherWin(x, y, player.ofColor());
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.board.toString());
        sb.append(player1.getName() + player2.getName());
        return sb.toString();
    }

    public static void main(String... args) {
        Player p1 = new Player("aaa");
        Player p2 = new Player("bbb");
        TicTacToe.start(p1, p2);
    }
}
