package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate{
    private double phi;
    private double theta;
    private double radius;

    /**
     * Coordinate constructor implements a new object with given features
     * @param phi phi-value of Coordinate
     * @param theta theta-value of Coordinate
     * @param radius radius-value of Coordinate
     * @methodtype initialization
     */
    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    /**
     * Getter for phi value
     * @return phi
     * @methodtype get
     */
    public double getPhi() {
        return phi;
    }

    /**
     * Setter for phi value
     * @param phi value of the phi-coordinate in an cartesian coordinate system
     * @methodtype set
     */
    public void setPhi(double phi) {
        this.phi = phi;
    }

    /**
     * Getter for theta value
     * @return theta
     * @methodtype get
     */
    public double getTheta() {
        return theta;
    }

    /**
     * Setter for theta value
     * @param theta value of the theta-coordinate in an cartesian coordinate system
     * @methodtype set
     */
    public void setTheta(double theta) {
        this.theta = theta;
    }

    /**
     * Getter for radius value
     * @return radius
     * @methodtype get
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for radius value
     * @param radius value of the x-coordinate in an cartesian coordinate system
     * @methodtype set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * returns coordinate as cartesian coordinate
     * @return cartesian coordinate
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariant();
        assertCoordinateIsNotNull(this);
        double x = this.radius * Math.sin(this.phi)*Math.cos(this.theta);
        double y = this.radius * Math.sin(this.phi)*Math.sin(this.theta);
        double z = this.radius * Math.cos(this.phi);
        CartesianCoordinate coordinate = new CartesianCoordinate(x,y,z);
        assertClassInvariant();
        return coordinate;
    }

    /**
     * returns coordinate as spheric coordinate
     * @return this object
     * @methodtype get
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariant();
        assertCoordinateIsNotNull(this);
        return this;
    }


    /**
     * wirtes coordinate details from rset into update object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void writeOn(ResultSet rset) throws SQLException {
        assertClassInvariant();
        rset.updateDouble("coordinate_unit_1", this.phi);
        rset.updateDouble("coordinate_unit_2", this.theta);
        rset.updateDouble("coordinate_unit_3", this.radius);
        assertClassInvariant();
    }

    @Override
    public int hashCode() {
        assertClassInvariant();
        int hash = Objects.hash(this.radius, this.theta, this.phi);
        assertClassInvariant();
        return hash;
    }

    @Override
    public void assertClassInvariant() {
        if (Double.isNaN(this.getPhi()) || this.getPhi() <= 0 
            || Double.isNaN(this.getTheta()) || this.getRadius() <= 0 
            || Double.isNaN(this.getRadius()) || this.getTheta() <= 0) {
                // TO DO: find better exception or write own one
                throw new IllegalArgumentException();
        }
    };
}
