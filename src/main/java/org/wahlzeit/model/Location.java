package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Location{
    protected Coordinate coordinate;

    /**
     * Location constructor implements a new object with given features
     * @param coordinate type Coordinate
     * @methodtype initialization
     */
    public Location(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public void writeOn(ResultSet rset) throws SQLException {
        this.coordinate.writeOn(rset);

    }

}
