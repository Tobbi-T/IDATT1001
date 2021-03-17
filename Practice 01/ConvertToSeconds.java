import javax.swing.JOptionPane;

public class ConvertToSeconds {
    public static void main(String[] args) {
        final String[] timeDesc = {"timer", "minutter", "sekunder"};
        int[] timeInput = new int[3];

        for(int i = 0; i < 3; i++) {
            timeInput[i] = Integer.parseInt(JOptionPane.showInputDialog(null, String.format("Skriv inn antall %s.", timeDesc[i])));
        }

        int seconds = timeInput[0] * 3600 + timeInput[1] * 60 + timeInput[2];
        JOptionPane.showMessageDialog(null, "Totalt antall sekunder: " + seconds);
    }
}