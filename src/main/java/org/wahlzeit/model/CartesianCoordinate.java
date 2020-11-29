package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class CartesianCoordinate implements Coordinate{
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
     * Calculates the distance between two cartesian coordinates
     * @param cartesianCoordinate type Coordinate
     * @return double with cartesian distance between current coordinate and given parameter coordinate
     * @methodtype get
     */
    public double getDistance(CartesianCoordinate cartesianCoordinate){
        return Math.sqrt(Math.pow(cartesianCoordinate.x - this.x, 2) + Math.pow(cartesianCoordinate.y - this.y, 2) + Math.pow(cartesianCoordinate.z - this.z, 2));
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

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * checks whether the x, y and z coordinates of a given object is equal to the current object
     * @param other type Coordinate
     * @return true if x, y, z value of a coordinate equals the x, y, z of the current object
     * @methodtype comparison
     */
    public boolean isEqual(Coordinate other){
        CartesianCoordinate otherCartesianCoordinate = other.asCartesianCoordinate();
        double tolerance = 0.001;
        boolean x_equals = Math.abs(otherCartesianCoordinate.x-this.x)<=tolerance;
        boolean y_equals = Math.abs(otherCartesianCoordinate.y-this.y)<=tolerance;
        boolean z_equals = Math.abs(otherCartesianCoordinate.z-this.z)<=tolerance;
        return x_equals && y_equals && z_equals;
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
     * returns the cartesian distance between coordinate and current object
     * @return distance between coordinate as double
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.getDistance(coordinate.asCartesianCoordinate());
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

    /**
     * returns the central angle between two coordinates
     * @return central angle as double
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return this.asSphericCoordinate().getCentralAngle(coordinate);
    }

}
