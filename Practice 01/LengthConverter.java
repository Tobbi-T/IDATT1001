import javax.swing.JOptionPane;

public class LengthConverter {
    public static void main(String[] args) {
        String rawInput = "";
        boolean invalid;
        int inches = 0;

        do {
            invalid = false;
            rawInput = JOptionPane.showInputDialog(null, "Skriv inn antall tommer: ");

            try {
                inches = Integer.parseInt(rawInput);
            }
            catch (NumberFormatException e) {
                System.out.printf("Feil: Tallet du skrev er ikke gyldig. (%s)", e.getMessage());
                invalid = true;
            }
        } while(invalid);

        float centimeters = inches * 2.54f;
        JOptionPane.showMessageDialog(null, String.format("%s tommer er %s centimeter.", inches, centimeters));
    }
}