import javax.swing.*;

public class LeapYear {
  public static void main(String[] args) {
    short year = Short.parseShort(JOptionPane.showInputDialog(null, "Skriv inn et år."));

    boolean isCentury = (year % 100 == 0);
    boolean isLeapYear = (!isCentury && (year % 4 == 0) || isCentury && (year % 400 == 0));

    JOptionPane.showMessageDialog(
        null, year + (isLeapYear ? " er et skuddår." : " er ikke et skuddår."));
  }
}
