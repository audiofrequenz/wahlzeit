package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class RodentPhoto extends Photo{
    private Rodent rodent;

    /**
     * RodentPhoto constructor implements a new object
     * @methodtype initialization
     */
    public RodentPhoto(){
        super();
    }

    /**
     * RodentPhoto constructor implements a new object with given features
     * @param id PhotoId of RodentPhoto
     * @methodtype initialization
     */
    public RodentPhoto(PhotoId id){
        super(id);
    }

    /**
     * RodentPhoto constructor implements a new object with given features
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype initialization
     */
    public RodentPhoto(ResultSet rset) throws SQLException {
        super(rset);
        readFrom(rset);
    }

    /**
     * reads ResulSet information into a rodent object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void readFrom(ResultSet rset) throws SQLException {
        this.rodent = new Rodent(
                rset.getString("rodenttype"),
                rset.getString("family"),
                rset.getInt("averageweight")
        );
        super.readFrom(rset);
    }

    /**
     * wirtes photo and rodentPhoto details from rset into update object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateString("rodenttype", "best one");
        rset.updateString("family", "Capybara");
        rset.updateInt("averageweight", 60);
        super.writeOn(rset);
    }

    /**
     * Getter for rodent value object
     * @return rodent
     * @methodtype get
     */
    public Rodent getRodent() {
        return rodent;
    }

    /**
     * Setter for rodent value
     * @param rodent Rodent object
     * @methodtype set
     */
    public void setRodent(Rodent rodent) {
        this.rodent = rodent;
    }

    public boolean isEqual(RodentPhoto other) {
        return other.rodent.equals(this.rodent);
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
        if (!(obj instanceof RodentPhoto)) return false;

        RodentPhoto other = (RodentPhoto) obj;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.rodent);
    }
}
