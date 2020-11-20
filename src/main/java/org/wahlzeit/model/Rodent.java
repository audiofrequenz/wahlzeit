package org.wahlzeit.model;

public class Rodent {
    protected String rodentType;
    protected String family;
    protected int averageWeight;

    public Rodent(String rodentType, String family, int averageWeight){
        this.rodentType = rodentType;
        this.family = family;
        this.averageWeight = averageWeight;
    }

    public String getRodentType() {
        return rodentType;
    }

    public void setRodentType(String rodentType) {
        this.rodentType = rodentType;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(int averageWeight) {
        this.averageWeight = averageWeight;
    }
}
