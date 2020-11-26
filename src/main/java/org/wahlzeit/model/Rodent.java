package org.wahlzeit.model;

import java.util.Objects;

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

    public boolean isEqual(Rodent other) {
        boolean isRodentTypeEqual = this.rodentType.equals(other.rodentType);
        boolean isFamilyEqual = this.family.equals(other.family);;
        boolean isAverageWeightEqual = this.averageWeight == other.averageWeight;
        return isRodentTypeEqual && isFamilyEqual && isAverageWeightEqual;
    }

    /**
     * Override for equals to check if given object equals current object
     * @param obj type Object
     * @return true if object equals current instance
     * @methodtype comparison
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Rodent)) return false;

        Rodent other = (Rodent) obj;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rodentType, this.family, this.averageWeight);
    }
}
