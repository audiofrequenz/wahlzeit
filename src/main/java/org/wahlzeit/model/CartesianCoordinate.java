package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate{
    private double x;
    private double y;
    private double z;

    /**
     * Coordinate constructor implements a new object with given features
     * @param x x-value of Coordinate
     * @param y y-value of Coordinate
     * @param z z-value of Coordinate
     * @methodtype initialization
     */
    public CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * wirtes coordinate details from rset into update object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateDouble("coordinate_unit_1", this.x);
        rset.updateDouble("coordinate_unit_2", this.y);
        rset.updateDouble("coordinate_unit_3", this.z);
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
     * returns coordinate as cartesian coordinate
     * @return this object
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
     * returns coordinate as spheric coordinate
     * @return spheric coordinate
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        double theta = 0;
        if(this.x != 0) {
            theta = Math.atan(this.y / this.x);
        }
        double phi = Math.atan(Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2))/this.z);
        return new SphericCoordinate(phi, theta, radius);
    }

}
