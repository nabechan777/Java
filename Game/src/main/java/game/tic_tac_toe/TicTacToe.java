package game.tic_tac_toe;

import game.util.Player;
import game.tic_tac_toe.Board;


public class TicTacToe {
    private Board board;
    private Turn turn;
    private TicTacToePlayer player1;
    private TicTacToePlayer player2;


    public static void start(Player player1, Player player2) {
        TicTacToePlayer p1 = new TicTacToePlayer(player1, Color.BLACK);
        TicTacToePlayer p2 = new TicTacToePlayer(player2, Color.WHITE);
        TicTacToe game = new TicTacToe(p1, p2);
        while(turn.whetherGameWillWin()){
            turn.putStone();
            System.out.println(game);
            turn.change()
        }
    }

    private TicTacToe(TicTacToePlayer p1, TicTacToePlayer p2){
        this.player1 = p1;
        this.player2 = p2;
        this.board = new Board(3);
        this.turn = new Turn(this.player1, this.board);
    }



    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(this.board.toString());
        sb.append(player1.getName() + player2.getName());
        return sb.toString();
    }

}
