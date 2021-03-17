import java.util.ArrayList;

public class PropertyRegister {
  private final ArrayList<Property> register = new ArrayList<>();

  /***
   * Adds a new property to the registry
   * @param munNumber municipality number
   * @param munName municipality name
   * @param lotNumber lot number
   * @param sectionNumber section number
   * @param area property area
   * @param ownerName owner name
   * @param propertyName property name
   */
  public void addProperty(
      int munNumber,
      String munName,
      int lotNumber,
      int sectionNumber,
      float area,
      String ownerName,
      String propertyName)
      throws IllegalArgumentException {
    if (area == 0) {
      throw new IllegalArgumentException("Arealet til eiendommen kan ikke være 0.");
    }

    if (munName.isEmpty()
        || ownerName.isEmpty()
        || (propertyName != null && propertyName.isEmpty())) {
      throw new IllegalArgumentException("Navn må ha en tekstverdi.");
    }

    Property p =
        new Property(munNumber, munName, lotNumber, sectionNumber, area, ownerName, propertyName);

    if (register.contains(p)) {
      throw new IllegalArgumentException("Eiendommen eksisterer allerede.");
    }

    register.add(p);
  }

  /***
   * Removes a property from the registry
   * @param munNumber municipality number
   * @param lotNumber lot number
   * @param sectionNumber section number
   */
  public void removeProperty(int munNumber, int lotNumber, int sectionNumber) {
    Property p = getProperty(munNumber, lotNumber, sectionNumber);
    register.remove(p);
  }

  /***
   * Gets a property from the registry
   * @param munNumber municipality number
   * @param lotNumber lot number
   * @param sectionNumber section number
   * @return property requested
   */
  public Property getProperty(int munNumber, int lotNumber, int sectionNumber) {
    Property p = null;

    for (Property q : register) {
      if (q.getMunNumber() == munNumber
          && q.getLotNumber() == lotNumber
          && q.getSectionNumber() == sectionNumber) {
        p = q;
      }
    }

    if (p == null) {
      throw new IllegalArgumentException("Eiendommen eksisterer ikke.");
    }

    return register.get(register.indexOf(p));
  }

  /***
   * Gets a listed string of the properties in the registry
   * @return
   */
  public String getProperties() {
    StringBuilder sb = new StringBuilder();
    for (Property p : register) {
      sb.append(p.toString());
      sb.append("\n");
    }
    return sb.toString();
  }

  /***
   * Gets a property list string by municipality and lot number.
   * @param munNumber
   * @param lotNumber
   * @return
   */
  public String getPropertiesByLot(int munNumber, int lotNumber) {
    StringBuilder sb = new StringBuilder();
    for (Property p : register) {
      if (p.getMunNumber() == munNumber && p.getLotNumber() == lotNumber) {
        sb.append(p.toString());
        sb.append("\n");
      }
    }
    return sb.toString();
  }

  /***
   * Gets the number of properties in the registry.
   * @return
   */
  public int getPropertyCount() {
    return register.size();
  }

  /***
   * Gets the average property area of all properties in the registry.
   * @return
   */
  public float getAveragePropertyArea() {
    float areaSum = 0;
    int propertyCount = getPropertyCount();

    for (Property p : register) {
      areaSum += p.getArea();
    }

    return areaSum / propertyCount;
  }
}
