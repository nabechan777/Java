
package rock_papar_scissors;

public enum Hand {
    ROCK(1){
        @Override
        public String toString() {
            return "✊";
        }
    },
    PAPAR(2) {
        @Override
        public String toString() {
            return "🖐";
        }
    },
    SCISSORS(3) {
        @Override
        public String toString() {
            return "✌️";
        }
    };

    private final int value;

    private Hand(int value){
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
