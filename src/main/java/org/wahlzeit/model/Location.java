package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Location{
    protected Coordinate coordinate;
    protected CoordinateType coordinateType;

    /**
     * Location constructor implements a new object with given features
     * @param coordinate type Coordinate
     * @methodtype initialization
     */
    public Location(CoordinateType coordinateType, Coordinate coordinate){
        this.coordinateType = coordinateType;
        this.coordinate = coordinate;
    }

    //checked exception
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateInt("coordinate_type", this.coordinateType.asInt());
        this.coordinate.writeOn(rset);

    }

}
