package org.wahlzeit.model;

import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;
import org.wahlzeit.utils.StringUtil;

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

    public RodentPhoto(Rodent rodent){
        super();
        this.rodent = rodent;
    }

    public RodentPhoto(ResultSet rset) throws SQLException {
        super(rset);
        readFrom(rset);
    }

    public void readFrom(ResultSet rset) throws SQLException {
        super.readFrom(rset);
        this.rodent = new Rodent(
                rset.getString("rodentType"),
                rset.getString("family"),
                rset.getInt("averageWeight")
        );
    }

    public Rodent getRodent() {
        return rodent;
    }

    public void setRodent(Rodent rodent) {
        this.rodent = rodent;
    }
}
