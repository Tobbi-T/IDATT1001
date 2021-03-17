import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
    Scanner inputScanner = new Scanner(System.in);

    System.out.println("Skriv inn den første gangetabellen du vil vise (eks. 3):");
    byte from = inputScanner.nextByte();

    System.out.println("Skriv inn den siste gangetabellen du vil vise (eks. 10):");
    byte to = inputScanner.nextByte();

    inputScanner.close();

    for (byte i = from; i <= to; i++) {
      System.out.printf("Gangetabell for %s-gangen:%n", i);
      for (byte j = 1; j <= 10; j++) {
        System.out.printf("%s * %s = %s%n", i, j, i * j);
      }
    }
  }
}
