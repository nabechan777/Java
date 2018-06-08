
package game.tic_tac_toe;

import java.io.*;

public class Turn {
    private BufferedReader br;
    private TicTacToePlayer player;
    private final Board board;

    Turn(TicTacToePlayer player, Board board) {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.player = player;
        this.board = board;
    }

    public void change(TicTacToePlayer player){
        this.player = player;
    }

    private void putStone() {
        try {
            String point = br.readLine();
            int x = Integer.valueOf(point.substring(0, point.indexOf(",")));
            int y = Integer.valueOf(point.substring(point.indexOf(",") + 1, point.length()));
            this.board.changeColor(x, y, player.ofColor());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Boolean whetherGameWillWin() {

    }
}
