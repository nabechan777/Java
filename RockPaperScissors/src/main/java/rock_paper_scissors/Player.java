
package rock_papar_scissors;

class Player {
    private String name;
    private Hand hand;

    Player(String name){
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    Hand getHand() {
        return this.hand;
    }

    void setHand(Hand hand) {
        this.hand = hand;
    }
}
