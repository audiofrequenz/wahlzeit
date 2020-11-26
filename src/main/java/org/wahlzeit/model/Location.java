package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Location{
    protected CartesianCoordinate cartesianCoordinate;

    /**
     * Location constructor implements a new object with given features
     * @param cartesianCoordinate type Coordinate
     * @methodtype initialization
     */
    public Location(CartesianCoordinate cartesianCoordinate){
        this.cartesianCoordinate = cartesianCoordinate;
    }

    public void writeOn(ResultSet rset) throws SQLException {
        this.cartesianCoordinate.writeOn(rset);

    }

}
