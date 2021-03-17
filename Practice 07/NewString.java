class NewString {
  private final String s;

  public NewString(String s) {
    this.s = s;
  }

  public static void main(String[] args) {
    NewString s = new NewString("This sentence will be abbreviated.");
    System.out.println(s.abbreviate());
    System.out.println(s.removeChar("e"));
  }

  public String abbreviate() {
    StringBuilder result = new StringBuilder();

    for (String word : s.split(" ")) {
      result.append(word.charAt(0));
    }

    return result.toString();
  }

  public String removeChar(String character) {
    return s.replaceAll(character, "");
  }

  public String getString() {
    return s;
  }
}
