package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/*
* 1. RodentManager.getOrCreateRodentType(rodentSpecies, averageWeight)
* 2. RodentType.RodentType(rodentSpecies, averageWeight)
* */
public class RodentType {
    private RodentType superType = null;
    private Set<RodentType> subTypes = new HashSet<RodentType>();
    protected int averageWeight;;

    public int getAverageWeight() {
        return averageWeight;
    }

    public String getRodentSpecies() {
        return rodentSpecies;
    }

    protected String rodentSpecies;

    public RodentType(String rodentSpecies, int averageWeight) {
        this.averageWeight = averageWeight;
        this.rodentSpecies = rodentSpecies;
    }

    public RodentType getSuperType(){
        return superType;
    }

    public void setSuperType(RodentType rt){
        superType = rt;
    }

    public Iterator<RodentType> getSubTypeIterator() {
        return subTypes.iterator();
    }

    public void addSubType(RodentType rt) {
        //assert not null check
        rt.setSuperType(this);
        subTypes.add(rt);
    }

    public boolean hasInstance(Rodent rodent){
        //assert check rodent not null
        if (rodent.getRodentType() == this)
            return true;

        for (RodentType type : subTypes){
            if (type.hasInstance(rodent))
                return true;
        }
        return false;
    }

    public boolean isSubtype(RodentType rt){
        RodentType curType = this.superType;
        while (curType != null) {
            if(curType.equals(rt)) {
                return true;
            }
            curType = curType.getSuperType();
        }
        return false;
    }

    public Rodent createInstance(String name) {
        return new Rodent(this, name);
    }

    public boolean isEqual(RodentType other) {
        boolean isSpeciesEqual = rodentSpecies.equals(other.rodentSpecies);
        boolean isWeightEqual = averageWeight == other.averageWeight;
        return isSpeciesEqual && isWeightEqual;
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
        if (!(obj instanceof RodentType)) return false;

        RodentType other = (RodentType) obj;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rodentSpecies, this.averageWeight);
    }
}
