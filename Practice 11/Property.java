import java.util.Objects;

public class Property {
    private final int munNumber;
    private final String munName;
    private final int lotNumber;
    private final int sectionNumber;
    private final float area;
    private final String ownerName;
    private final String propertyName;

    /***
     * Constructs a new Property object with all class objects defined.
     * @param munNumber Municipality number
     * @param munName Municipality name
     * @param lotNumber Lot number (gårdsnummer)
     * @param sectionNumber Section number (bruksnummer)
     * @param area Property area (m^2)
     * @param ownerName Owner name
     * @param propertyName Property name
     */
    public Property(int munNumber, String munName, int lotNumber, int sectionNumber, float area, String ownerName, String propertyName) {
        this.munNumber = munNumber;
        this.munName = munName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.area = area;
        this.ownerName = ownerName;
        this.propertyName = propertyName;
    }

    /***
     * Returns all information about a property as one printable string.
     * @return Printable property information String.
     */
    @Override
    public String toString() {
        String propertyName = this.propertyName != null ? String.format(" har navnet %s,", this.propertyName) : "";
        return String.format("Eiendom \"%s-%s/%s\"%s er eid av %s og har et areal på %s m^2.", munNumber, lotNumber, sectionNumber, propertyName, ownerName, area);
    }

    /***
     * Determines if an object is the same as this. If munNumber, lotNumber and sectionNumber is the same. The property is the same.
     * @param o The object to compare to
     * @return true if equal and false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return munNumber == property.munNumber &&
                lotNumber == property.lotNumber &&
                sectionNumber == property.sectionNumber &&
                area == property.area &&
                Objects.equals(munName, property.munName) &&
                Objects.equals(ownerName, property.ownerName) &&
                Objects.equals(propertyName, property.propertyName);
    }

    /***
     * Makes a property id from munNumber, lotNumber and sectionNumber.
     * @return string id on form xx-xx/xx.
     */
    public String getId() {
        return String.format("%s-%s/%s", munNumber, lotNumber, sectionNumber);
    }

    public int getMunNumber() {
        return munNumber;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public float getArea() {
        return area;
    }
}
