class FractionCalculator {
    public static void main(String[] args) {
        try {
            Fraction a = new Fraction(2, 4);
            Fraction b = new Fraction(1, 5);

            a.multiply(b);

            System.out.println(a.getString());
            System.out.println(b.getString());
        }
        catch(IllegalArgumentException e) {
            System.out.printf("Programmet avsluttes fordi følgende feil oppsto: %s", e.getMessage());
        }
    }
}

class Fraction {
    private int num;
    private int den;

    //Constructors
    public Fraction(int numerator, int denominator) {
        num = numerator;
        den = denominator;

        if(den == 0)
            throw new IllegalArgumentException("Nevner kan ikke være 0.");

        this.abbreviate();
    }

    public Fraction(int numerator) {
        num = numerator;
        den = 1;
    }

    public void multiply(Fraction f) {
        num *= f.num;
        den *= f.den;
    }

    public void divide(Fraction f) {
        num *= f.den;
        den *= f.num;
    }

    public void add(Fraction f) {
        num = f.num * den + num * f.den;
        den *= f.den;
        this.abbreviate();
    }

    public void subtract(Fraction f) {
        num = f.num * den - num * f.den;
        den *= f.den;
        this.abbreviate();
    }

    public void abbreviate() {
        int h = Math.max(num, den);

        for(int i = h; i >= 2; i--) {
            if(num % i == 0 && den % i == 0) {
                num /= i;
                den /= i;
            }
        }
    }

    public String getString() {
        return num + "/" + den;
    }

    public float getFloat() {
        return (float) num / den;
    }
}