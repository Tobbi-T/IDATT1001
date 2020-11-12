import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        PropertyRegister pr = new PropertyRegister();
        Scanner in = new Scanner(System.in);
        String input;
        boolean quit = false;

        System.out.println("Velkommen til eiendomsregister for Gloppen kommune.");

        while(!quit) {
            System.out.println("Velg en kommando ved å skrive et tall og trykke Enter:\n" +
                    "1. Legg til eiendom.\n" +
                    "2. Fjern en eiendom.\n" +
                    "3. Vis info om eiendom.\n" +
                    "4. Vis antall eiendommer.\n" +
                    "5. Vis gjennomsnittlig areal av alle eiendommer.\n" +
                    "6. Vis alle eiendommer med gitt kommune- og gårdsnummer.\n" +
                    "7. Vis alle eiendommer.\n" +
                    "8. Avslutt.");


            input = in.nextLine();
            try {
                switch(Integer.parseInt(input)){
                    case 1 -> {
                        System.out.println("Skriv inn følgene verdier separert med komma \",\".");
                        System.out.println("Kommunenummer, kommunenavn, gårdsnummer, bruksnummer, areal, eiers navn og bruksnavn (valgfri).");
                        input = in.nextLine();
                        String[] values = input.split(",");

                        int munNumber = Integer.parseInt(values[0].trim());
                        String munName = values[1].trim();
                        int lotNumber = Integer.parseInt(values[2].trim());
                        int sectionNumber = Integer.parseInt(values[3].trim());
                        float area = Float.parseFloat(values[4].trim());
                        String ownerName = values[5].trim();

                        if(values.length == 7)
                            pr.addProperty(munNumber, munName, lotNumber, sectionNumber, area, ownerName, values[6].trim());
                        else
                            pr.addProperty(munNumber, munName, lotNumber, sectionNumber, area, ownerName, null);

                        System.out.printf("La til eiendom %s-%s/%s.%n", munNumber, lotNumber, sectionNumber);
                    }

                    case 2 -> {
                        System.out.println("Skriv inn følgene verdier separert med komma \",\".");
                        System.out.println("Kommunenummer, gårdsnummer, bruksnummer");
                        input = in.nextLine();
                        String[] values = input.split(",");

                        int munNumber = Integer.parseInt(values[0].trim());
                        int lotNumber = Integer.parseInt(values[1].trim());
                        int sectionNumber = Integer.parseInt(values[2].trim());

                        pr.removeProperty(munNumber, lotNumber, sectionNumber);
                        System.out.printf("Fjernet eiendom %s-%s/%s.%n", munNumber, lotNumber, sectionNumber);
                    }

                    case 3 -> {
                        System.out.println("Skriv inn følgene verdier separert med komma \",\".");
                        System.out.println("Kommunenummer, gårdsnummer, bruksnummer");
                        input = in.nextLine();
                        String[] values = input.split(",");

                        int munNumber = Integer.parseInt(values[0].trim());
                        int lotNumber = Integer.parseInt(values[1].trim());
                        int sectionNumber = Integer.parseInt(values[2].trim());

                        System.out.println(pr.getProperty(munNumber, lotNumber, sectionNumber).toString());
                    }

                    case 4 -> System.out.printf("Det er for øyeblikket registert %s eiendom(mer) i registeret.%n", pr.getPropertyCount());

                    case 5 -> System.out.printf("Gjennomsnittsarealet av alle eiendommene er %s m^2.%n", pr.getAveragePropertyArea());

                    case 6 -> {
                        System.out.println("Skriv inn følgene verdier separert med komma \",\".");
                        System.out.println("Kommunenummer, gårdsnummer");
                        input = in.nextLine();
                        String[] values = input.split(",");

                        int munNumber = Integer.parseInt(values[0].trim());
                        int lotNumber = Integer.parseInt(values[1].trim());

                        System.out.println(pr.getPropertiesByLot(munNumber, lotNumber));
                    }

                    case 7 -> System.out.println(pr.getProperties());

                    case 8 -> quit = true;

                    default -> System.out.println("Ukjent kommando.");
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Forventet et tall, men fikk en annen form for input.");
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            catch(IndexOutOfBoundsException e) {
                System.out.println("Feil antall argumenter. Sørg for å få med all informasjonen kommandoen ber om.");
            }
        }
    }
}