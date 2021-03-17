class Analyzer {
  private final String text;

  public Analyzer(String text) {
    this.text = text;
  }

  public static void main(String[] args) {
    Analyzer a =
        new Analyzer(
            "Hei! Dette er en tekst som består av flere deler. Den er delt opp i tre avsnitt med forskjellig lengde.");

    System.out.printf(
        "Antall ord: %d\n"
            + "Gjennomsnittlig ordlengde: %d\n"
            + "Gjennomsnittlig ord per del: %d\n"
            + "Tekst etter man erstatter er med ere: %s\n"
            + "Teksten: %s\n"
            + "TEKSTEN: %s",
        a.numberOfWords(),
        a.averageWordLength(),
        a.averageWordsPerPeriod(),
        a.replaceAll("er", "ere"),
        a.getText(),
        a.getUpperCaseText());
  }

  public int numberOfWords() {
    return text.split(" ").length;
  }

  public int averageWordLength() {
    int sum = text.replaceAll("[.,:;?! ]", "").length();
    return Math.round((float) sum / numberOfWords());
  }

  public int averageWordsPerPeriod() {
    int periods = 0;

    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == ':'
          || text.charAt(i) == '.'
          || text.charAt(i) == '!'
          || text.charAt(i) == '?') periods++;
    }

    if (periods == 0) return 0;

    return Math.round((float) numberOfWords() / periods);
  }

  public String replaceAll(String target, String replaceWith) {
    return text.replaceAll(" " + target + " ", " " + replaceWith + " ");

    /* This code works a little better. But takes a lot more space.
    String[] words = text.split(" ");

    for(int i = 0; i < words.length; i++) {
        if(words[i].equals(target))
            words[i] = replaceWith;
    }

    return String.join(" ", words);
     */
  }

  public String getText() {
    return text;
  }

  public String getUpperCaseText() {
    return text.toUpperCase();
  }
}
