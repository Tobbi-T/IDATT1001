import java.util.Scanner;

public class CurrencyConverter {
  public static void main(String[] args) {
    final Currency[] currencies = {
      new Currency("Amerikanske dollar", 9.0),
      new Currency("Europeiske euro", 10.6),
      new Currency("Svenske kroner", 1.02),
      new Currency("Japanske Yen", (float) 1 / 13)
    };

    final Scanner scanner = new Scanner(System.in);

    System.out.println("Velg valuta:");
    int i;
    for (i = 0; i < currencies.length; i++) {
      System.out.printf("%d. %s%n", (i + 1), currencies[i].getName());
    }
    System.out.printf("%d. Avslutt%n", i + 1);
    final int currencyChoice = scanner.nextInt() - 1; // Trekk fra en pga. 0-index.

    if (currencyChoice == i) {
      scanner.close(); // Avslutt leseren
      System.exit(0);
    }

    System.out.printf(
        "%s er valgt.%nØnsker du å konvertere til(1) eller fra(2) Norske kroner?%n",
        currencies[currencyChoice].getName());
    final boolean toNOK = scanner.nextInt() == 1;

    System.out.printf(
        "%s er valgt.%nHvor mye ønsker du å konvertere?%n",
        toNOK ? "Til Norske kroner" : "Fra Norske kroner");
    final double amount = scanner.nextDouble();

    if (toNOK)
      System.out.printf(
          "%.2f %s er %.2f Norske kroner.",
          amount, currencies[currencyChoice].getName(), currencies[currencyChoice].toNOK(amount));
    else
      System.out.printf(
          "%.2f Norske kroner er %.2f %s.",
          amount, currencies[currencyChoice].fromNOK(amount), currencies[currencyChoice].getName());

    scanner.close();
  }
}

class Currency {
  private final String name;
  private final Double inNOK;

  public Currency(String name, double inNOK) {
    this.name = name;
    this.inNOK = inNOK;
  }

  public double toNOK(double amount) {
    return amount * inNOK;
  }

  public double fromNOK(double amount) {
    return amount / inNOK;
  }

  public String getName() {
    return name;
  }
}
