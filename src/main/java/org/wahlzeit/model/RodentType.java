package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RodentType {
    private RodentType superType = null;
    private Set<RodentType> subTypes = new HashSet<RodentType>();
    protected int averageWeight;;
    private String rodentSpecies;

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

    public boolean hasSubType(RodentType rt){
        //check not null

        if (rt.equals(this))
            return true;

        return false;

    }

    public Rodent createInstance(String name) {
        return new Rodent(this, name);
    }

    public boolean isEqual(RodentType other) {
        boolean isRodentTypeEqual = this.rodentSpecies.equals(other.rodentSpecies);
        boolean isNameEqual = averageWeight == other.averageWeight;
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
        if (!(obj instanceof RodentType)) return false;

        RodentType other = (RodentType) obj;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rodentSpecies, this.averageWeight);
    }
}
