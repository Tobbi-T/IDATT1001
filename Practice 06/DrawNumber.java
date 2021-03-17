import java.util.Random;

class DrawNumber {
  public static void main(String[] args) {
    final int maxRounds = 10000;
    final int maxNumber = 10;
    final Random r = new Random();

    int[] amount = new int[maxNumber];

    for (int i = 0; i < maxRounds; i++) {
      amount[r.nextInt(maxNumber)]++;
    }

    for (int i = 0; i < amount.length; i++) {
      System.out.printf(
          "%s -> %s -> %s", (i + 1), amount[i], "*".repeat(Math.round((float) amount[i] / 100)));
    }
  }
}
