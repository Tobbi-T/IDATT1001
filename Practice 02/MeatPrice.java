class MeatPrice {
  public static void main(String[] args) {
    final short brandAWeight = 450;
    final double brandAPrice = 35.9;

    final short brandBWeight = 500;
    final double brandBPrice = 39.5;

    boolean aCheaper = (brandAPrice / brandAWeight) < (brandBPrice / brandBWeight);

    System.out.println((aCheaper ? "Merke A er billigst." : "Merke B er billigst."));
  }
}
