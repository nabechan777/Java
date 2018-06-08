package game.util;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
