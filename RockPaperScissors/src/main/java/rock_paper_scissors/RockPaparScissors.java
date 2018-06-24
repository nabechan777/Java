
package rock_papar_scissors;

import java.io.*;

public class RockPaparScissors {
    private Player player1;
    private Player player2;

    public RockPaparScissors(String playerName1){
        this(playerName1, "コンピュータ");
    }

    public RockPaparScissors(String playerName1, String playerName2){
        this.player1 = new Player(playerName1);
        this.player2 = new Player(playerName2);
    }

    public void run() {
        Player winnerPlayer = null;
        String enteredString = null;
        try {
            while(true) {
                enteringHand();
                winnerPlayer = judgement();
                if (winnerPlayer == null) {
                    continue;
                }else{
                    StringBuffer sb = new StringBuffer("Winner ");
                    sb.append(winnerPlayer.getName());
                    System.out.println(sb);
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enteringHand() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String enteredString = null;
        while(true) {
            enteredString = br.readLine();
            if (enteredString.equals("")) {
                continue;
            }
            if (enteredString.substring(0, 1).equals("g")) {
                this.player1.setHand(Hand.ROCK);
                this.player2.setHand(Hand.PAPAR);
                break;
            }else if (enteredString.substring(0, 1).equals("p")) {
                this.player1.setHand(Hand.PAPAR);
                this.player2.setHand(Hand.SCISSORS);
                break;
            }else if (enteredString.substring(0, 1).equals("c")) {
                this.player1.setHand(Hand.SCISSORS);
                this.player2.setHand(Hand.ROCK);
                break;
            }else{
                System.out.println("もう一度入力してください。");
                continue;
            }
        }
    }

    private Player judgement() {
        Player winnerPlayer = null;
        Hand playerHand1 = this.player1.getHand();
        Hand playerHand2 = this.player2.getHand();

        int handValue1 = playerHand1.getValue();
        int handValue2 = playerHand2.getValue();
        int winningOrLosing = (handValue1 - handValue2 + 3) % 3;

        System.out.println(this.player1.getName() + ": " + playerHand1 + " - " + this.player2.getName() + ": " + playerHand2);

        switch (winningOrLosing) {
            case 0:
                winnerPlayer = null;
                break;
            case 1:
                winnerPlayer = this.player1;
                break;
            case 2:
                winnerPlayer = this.player2;
                break;
        }
        return winnerPlayer;
    }

    public static void main(String[] args) {
        System.out.println(Hand.ROCK);
    }
}
