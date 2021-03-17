import java.util.Random;

public class DiceGame {
    public static void main(String[] args) {
        Player p1 = new Player("Player 1");
        Player p2 = new Player("Player 2");

        final int maxRounds = 5000;
        int roundCounter = 1;

        while(p1.getScore() != 100 && p2.getScore() != 100 && roundCounter <= maxRounds) {
            System.out.printf("Round %d is starting!%n", roundCounter);
            System.out.println(p1.doTurn());
            System.out.println(p2.doTurn());
            roundCounter++;
        }

        if(p1.getScore() == 100 && p2.getScore() == 100)
            System.out.println("The game is a tie!");
        else if(p1.getScore() == 100)
            System.out.println("Player 1 wins the game!");
        else if(p2.getScore() == 100)
            System.out.println("Player 2 wins the game!");
        else
            System.out.println("The max round number was reached. No one wins. :(");
    }
}

class Player  {
    private final Random dice = new Random();
    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String doTurn() {
        int roll = dice.nextInt(6) + 1;

        if(roll == 1)
            score = 0;
        else if(score < 100)
            score += roll;
        else
            score -= roll;

        return String.format("%s rolled a %s so now their score is %s.", name, roll, score);
    }
}