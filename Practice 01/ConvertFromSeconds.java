import javax.swing.*;

public class ConvertFromSeconds {
  public static void main(String[] args) {
    String rawInput = JOptionPane.showInputDialog(null, "Skriv inn antall sekunder.");
    int seconds = Integer.parseInt(rawInput);

    int h = seconds / 3600;
    int m = (seconds % 3600) / 60;
    int s = (seconds % 3600) % 60;

    String result =
        String.format("%s sekunder er %s timer, %s minutter og %s sekunder.", rawInput, h, m, s);
    JOptionPane.showMessageDialog(null, result);
  }
}
