package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RodentPhoto extends Photo{
    private Rodent rodent;

    public RodentPhoto(){
        super();
    }

    public RodentPhoto(PhotoId id){
        super(id);
    }

    public RodentPhoto(ResultSet rset) throws SQLException {
        super(rset);
        readFrom(rset);
    }

    public void readFrom(ResultSet rset) throws SQLException {
        this.rodent = new Rodent(
                rset.getString("rodenttype"),
                rset.getString("family"),
                rset.getInt("averageweight")
        );
        super.readFrom(rset);
    }

    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateString("rodenttype", "best one");
        rset.updateString("family", "Capybara");
        rset.updateInt("averageweight", 60);
        super.writeOn(rset);
    }

    public Rodent getRodent() {
        return rodent;
    }

    public void setRodent(Rodent rodent) {
        this.rodent = rodent;
    }
}
