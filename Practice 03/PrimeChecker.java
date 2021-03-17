import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int num;
        do {
            System.out.println("Skriv inn et tall for å sjekke om det er et primtall: (skriv 0 for å avslutte)");
            num = inputScanner.nextInt();

            boolean prime = isPrime(num);
            System.out.println(num + (prime ? " er et primtall." : " er ikke et primtall."));
        } while(num != 0);

        inputScanner.close();
    }

    private static Boolean isPrime(int n) {
        for(int i = (n - 1); i > 1; i--) {
            if(n % i == 0) { 
                return false;
            }
        }
        return true;
    }
}