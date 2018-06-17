package game.tic_tac_toe;

import game.util.Player;

public class TicTacToePlayer {
    private Player player;
    private Color color;

    TicTacToePlayer(Player p, Color color){
        this.player = p;
        this.color = color;
    }

    public Color ofColor(){
        return this.color;
    }

    public String getName() {
        return this.player.getName();
    }

    @Override
    public String toString() {
        return getName() + this.color.toString();
    }

    public static void main() {
        ;
    }
}
