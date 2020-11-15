package org.wahlzeit.model;

public class Location {
    protected Coordinate coordinate;

    /**
     * Location constructor implements a new object with given features
     * @param coordinate type Coordinate
     */
    public Location(Coordinate coordinate){
        this.coordinate = coordinate;
    }
}
