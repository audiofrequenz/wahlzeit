package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
