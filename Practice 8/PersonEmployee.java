import java.time.LocalDate;
import java.util.Scanner;

class PersonEmployee {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        String[] input;

        System.out.println("Starter...");
        Person p = new Person("Bjørn", "Saxe-Olsen", 10, 4, 2000);
        System.out.println("Lagde en ny person.");
        Employee e = new Employee(p, 1, 2013, 15000, 0.125);
        System.out.println("Lagde en ny ansatt.\n");

        while(running) {
            System.out.println("Kommandoer:");
            System.out.println("    'wage' <ny verdi>: Endrer månedslønn til ny verdi.");
            System.out.println("    'tax' <ny verdi>: Endrer skatteprosent til ny verdi (Format: %/100 = 0.XXX).");
            System.out.println("    'print': Skriver ut all data i objektet.");
            System.out.println("    'avslutt': Avslutter programmet.");
            input = in.nextLine().split(" ");

            switch(input[0]) {
                case "wage" -> {
                    e.setMonthlyWage(Integer.parseInt(input[1]));
                    System.out.printf("Endret månedslønn til %s\n", input[1]);
                }

                case "tax" -> {
                    e.setTaxRate(Double.parseDouble(input[1]));
                    System.out.printf("Endret skatt til %s\n", input[1]);
                }

                case "print" -> {
                    System.out.printf("Ansattid: %d\n", e.getEmployeeId());
                    System.out.printf("Ansatt år: %d\n", e.getEmployedYear());
                    System.out.printf("År ansatt: %d\n", e.getYearsEmployed());
                    System.out.printf("Navn: %s\n", e.getName());
                    System.out.printf("Fødselsdato: %s\n", e.getPerson().getDateOfBirth().toString());
                    System.out.printf("Alder: %d\n", e.getAge());
                    System.out.printf("Lønn / mnd: %.2f\n", e.getMonthlyWage());
                    System.out.printf("Lønn / år: %.2f\n", e.getYearlyWage());
                    System.out.printf("Skatt: %.4f\n", e.getTaxRate());
                    System.out.printf("Skatt / mnd: %.2f\n", e.getMonthlyTax());
                    System.out.printf("Skatt / år: %.2f\n", e.getYearlyTax());
                }

                case "avslutt" -> {
                    running = false;
                    System.out.println("Avslutter programmet...");
                }

                default -> System.out.println("Ukjent kommando.");
            }
        }

        in.close();
    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;

    public Person(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public Person(Person p) {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.dateOfBirth = p.getDateOfBirth();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonthValue(), dateOfBirth.getDayOfMonth());
    }
}

class Employee {
    private final Person person;
    private final int employeeId;
    private final int employedYear;
    private float monthlyWage;
    private double taxRate;

    public Employee(Person employee, int employeeId, int employedYear, float monthlyWage, double taxRate) {
        this.person = employee;
        this.employeeId = employeeId;
        this.employedYear = employedYear;
        this.monthlyWage = monthlyWage;
        this.taxRate = taxRate;
    }

    public Person getPerson() {
        return new Person(person);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getEmployedYear() {
        return employedYear;
    }

    public float getMonthlyWage() {
        return monthlyWage;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getMonthlyTax() {
        return monthlyWage * taxRate;
    }

    public float getYearlyWage() {
        return monthlyWage * 12;
    }

    public double getYearlyTax() {
        return (10.5 * monthlyWage * taxRate);
    }

    public String getName() {
        return person.getLastName() + ", " + person.getFirstName();
    }

    public int getAge() {
        return LocalDate.now().getYear() - person.getDateOfBirth().getYear();
    }

    public int getYearsEmployed() {
        return LocalDate.now().getYear() - employedYear;
    }

    public void setMonthlyWage(float monthlyWage) {
        this.monthlyWage = monthlyWage;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public boolean employedLongerThan(int years) {
        return years < this.getYearsEmployed();
    }
}