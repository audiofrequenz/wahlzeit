package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SphericCoordinate implements Coordinate{
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
        double x = this.radius * Math.sin(this.phi)*Math.cos(this.theta);
        double y = this.radius * Math.sin(this.phi)*Math.sin(this.theta);
        double z = this.radius * Math.cos(this.phi);
        return new CartesianCoordinate(x,y,z);
    }

    /**
     * returns the distance between two coordinates
     * @return distance as double
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    /**
     * returns coordinate as spheric coordinate
     * @return this object
     * @methodtype get
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    /**
     * returns the central angle between two coordinates
     * @return central angle as double
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        SphericCoordinate sphericCoordinate = coordinate.asSphericCoordinate();
        //Formula for central Angle = arccos(sin(phi1)*sin(phi2)+cos(phi1)*cos(phi2)*cos())
        double result = 
            Math.toDegrees(Math.acos(Math.sin(this.phi) *
            Math.sin(sphericCoordinate.getPhi()) +
            Math.cos(this.phi) * Math.cos(sphericCoordinate.getPhi()) *
            Math.cos(sphericCoordinate.getTheta() - this.theta)));
        return result;
    }

    /**
     * wirtes coordinate details from rset into update object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateDouble("coordinate_unit_1", this.phi);
        rset.updateDouble("coordinate_unit_2", this.theta);
        rset.updateDouble("coordinate_unit_3", this.radius);
    }

    /**
     * checks whether the phi, theta and radius of coordinates of a given object is equal to the current object
     * @param coordinate type Coordinate
     * @return true if phi, theta and radius value of a coordinate equals the phi, theta and radius of the current object
     * @methodtype comparison
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        SphericCoordinate otherSphericCoordinate = coordinate.asSphericCoordinate();
        double tolerance = 0.001;
        boolean phi_equals = Math.abs(otherSphericCoordinate.phi-this.phi)<=tolerance;
        boolean theta_equals = Math.abs(otherSphericCoordinate.theta-this.theta)<=tolerance;
        boolean radius_equals = Math.abs(otherSphericCoordinate.radius-this.radius)<=tolerance;
        return phi_equals && theta_equals && radius_equals;
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
        return Objects.hash(this.radius, this.theta, this.phi);
    }
}
