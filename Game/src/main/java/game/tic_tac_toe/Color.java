package game.tic_tac_toe;

public enum Color {
    WHITE{
        @Override
        public String toString(){
            return "○";
        }
    },
    BLACK{
        @Override
        public String toString() {
            return "×";
        }
    };
}
