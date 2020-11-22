package org.wahlzeit.model;

public class Rodent {
    protected String rodentType;
    protected String family;
    protected int averageWeight;

    /**
     * RodentPhoto constructor implements a new object with given features
     * @param rodentType String containing type of Rodent
     * @param family String containing family of Rodent
     * @param averageWeight int representing average Weight of Rodent
     * @methodtype initialization
     */
    public Rodent(String rodentType, String family, int averageWeight){
        this.rodentType = rodentType;
        this.family = family;
        this.averageWeight = averageWeight;
    }

    /**
     * Getter for type of Rodent
     * @return rodentType String
     * @methodtype get
     */
    public String getRodentType() {
        return rodentType;
    }

    /**
     * Setter for rodentType
     * @param rodentType string
     * @methodtype set
     */
    public void setRodentType(String rodentType) {
        this.rodentType = rodentType;
    }

    /**
     * Getter for family of rodent
     * @return family String
     * @methodtype get
     */
    public String getFamily() {
        return family;
    }

    /**
     * Setter for family
     * @param family Rodent string
     * @methodtype set
     */
    public void setFamily(String family) {
        this.family = family;
    }

    /**
     * Getter for average weight of rodent
     * @return averageWeight Int
     * @methodtype get
     */
    public int getAverageWeight() {
        return averageWeight;
    }

    /**
     * Setter for averageWeight
     * @param averageWeight int
     * @methodtype set
     */
    public void setAverageWeight(int averageWeight) {
        this.averageWeight = averageWeight;
    }
}
