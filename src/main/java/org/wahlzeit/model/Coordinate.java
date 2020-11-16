package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;
import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;
import org.wahlzeit.utils.StringUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class Coordinate {
    private double x;
    private double y;
    private double z;
    //not part of homework cw2 but nice addon
    private CoordinateType type = CoordinateType.UNDEFINED;

    /**
     * Coordinate constructor implements a new object with given features
     * @param x x-value of Coordinate
     * @param y y-value of Coordinate
     * @param z z-value of Coordinate
     * @param type needs to be a CoordinateType Object
     * @methodtype initialization
     */
    public Coordinate(double x, double y, double z, CoordinateType type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    /**
     * Calculates the distance between two cartesian coordinates
     * @param coordinate type Coordinate
     * @return double with cartesian distance between current coordinate and given parameter coordinate
     * @methodtype get
     */
    public double getDistance(Coordinate coordinate){
        return Math.sqrt(Math.pow(coordinate.x - this.x, 2) + Math.pow(coordinate.y - this.y, 2) + Math.pow(coordinate.z - this.z, 2));
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
        if (!(obj instanceof Coordinate)) return false;

        Coordinate other = (Coordinate) obj;
        return isEqual(other);
    }

    /**
     * checks whether the x, y and z coordinates of a given object is equal to the current object
     * @param other type Coordinate
     * @return true if x, y, z and type value of a coordinate equals the x, y, z, type coordinate of the current object
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate other){
        return other.x == this.x && other.y == this.y && other.z == this.z && other.type == this.type;
    }

    /**
     * Getter for x value
     * @return x
     * @methodtype get
     */
    public double getX() {
        return x;
    }

    /**
     * Setter for x value
     * @param x value of the x-coordinate in an cartesian coordinate system
     * @methodtype set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter for y value
     * @return y
     * @methodtype get
     */
    public double getY() {
        return y;
    }

    /**
     * Setter for y value
     * @param y value of the y-coordinate in an cartesian coordinate system
     * @methodtype set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter for z value
     * @return z
     * @methodtype get
     */
    public double getZ() {
        return z;
    }

    /**
     * Setter for z value
     * @param z value of the z-coordinate in an cartesian coordinate system
     * @methodtype set
     */
    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Getter for type value
     * @return type
     * @methodtype get
     */
    public CoordinateType getType() {
        return type;
    }

    /**
     * Setter for type value
     * @param type enum of the coordinate type
     * @methodtype set
     */
    public void setType(CoordinateType type) {
        this.type = type;
    }
}
