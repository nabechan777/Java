package game.tic_tac_toe;

import java.util.Optional;

public class Mass {
    private Optional<Color> optColor;

    public Mass(Color color) {
        optColor = Optional.ofNullable(color);
    }

    public void changeColor(Color color) {
        optColor = Optional.of(color);
    }

    public Optional<Color> getColor(){
        return optColor;
    }

    @Override
    public String toString() {
        return optColor.map(Color::toString).orElse("-");
    }
}
