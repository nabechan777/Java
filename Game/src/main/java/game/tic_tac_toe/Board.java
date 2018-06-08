package game.tic_tac_toe;

import java.util.stream.Stream;
import game.tic_tac_toe.Color;
import game.tic_tac_toe.Mass;


public class Board {
    private Mass[][] board;

    public Board(int size){
        this.board = new Mass[3][3];
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                board[i][j] = new Mass((j + 1) * 100, (i + 1) * 100, null);
            }
        }
    }

    public Boolean whetherWin(Color color) {
        String[][] colors = Stream.of(this.board).map(row -> {
            return Stream.of(row).map(mass -> mass.toString()).toArray();
        }).toArray();
        return true;
    }

    public void changeColor(int x, int y, Color color) {
        Stream.of(this.board).forEach(row -> {
            Stream.of(row).filter(mass -> {
                return mass.ofRange.apply((int)x, (int)y);
            }).forEach(mass -> {
                mass.changeColor(color);
            });
        });
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

    public static void main(String... args) {
        Board target = new Board(3);
        System.out.println(target);
        target.changeColor(50, 1, Color.BLACK);
        System.out.println(target);
        target.changeColor(150, 1, Color.WHITE);
        System.out.println(target);
    }
}
