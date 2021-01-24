package org.wahlzeit.model;

import java.util.Objects;

public class Rodent {
    protected String name;

    protected RodentType rodentType;


    /**
     * RodentPhoto constructor implements a new object with given features
     * @param rodentType String containing type of Rodent
     * @param family String containing family of Rodent
     * @param averageWeight int representing average Weight of Rodent
     * @methodtype initialization
     */
    public Rodent(RodentType rodentType){
        //assert check not null, string not blank
        this.rodentType = rodentType;
    }

    /**
     * RodentPhoto constructor implements a new object with given features
     * @param rodentType String containing type of Rodent
     * @param family String containing family of Rodent
     * @param averageWeight int representing average Weight of Rodent
     * @methodtype initialization
     */
    public Rodent(RodentType rodentType, String name){
        //assert check not null, string not blank
        this.rodentType = rodentType;
        this.name = name;
    }

    /**
     * Getter for type of Rodent
     * @return rodentType String
     * @methodtype get
     */
    public RodentType getRodentType() {
        return rodentType;
    }

    /**
     * Setter for rodentType
     * @param rodentType string
     * @methodtype set
     */
    public void setRodentType(RodentType rodentType) {
        this.rodentType = rodentType;
    }


    public boolean isEqual(Rodent other) {
        boolean isRodentTypeEqual = this.rodentType.equals(other.rodentType);
        boolean isNameEqual = this.name.equals(other.name);
        return isRodentTypeEqual && isNameEqual;
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
        return Objects.hash(this.rodentType, this.name);
    }
}
