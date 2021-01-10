package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate{
    private final double phi;
    private final double theta;
    private final double radius;

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
        assertClassInvariant();
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
     * Getter for theta value
     * @return theta
     * @methodtype get
     */
    public double getTheta() {
        return theta;
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
     * returns coordinate as cartesian coordinate
     * @return cartesian coordinate
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariant();
        assertObjectIsNotNull(this);
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
        assertObjectIsNotNull(this);
        return this;
    }


    /**
     * wirtes coordinate details from rset into update object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void writeOn(ResultSet rset) throws SQLException {
        assertClassInvariant();
        assertObjectIsNotNull(rset);
        rset.updateDouble("coordinate_unit_1", this.phi);
        rset.updateDouble("coordinate_unit_2", this.theta);
        rset.updateDouble("coordinate_unit_3", this.radius);
        assertClassInvariant();
    }

    @Override
    public int hashCode() {
        assertClassInvariant();
        assertObjectIsNotNull(this);
        int hash = Objects.hash(this.radius, this.theta, this.phi);
        assertClassInvariant();
        return hash;
    }

    @Override
    public void assertClassInvariant() {
        if (Double.isNaN(this.getPhi()) 
            || Double.isNaN(this.getTheta())
            || Double.isNaN(this.getRadius())) {
                throw new IllegalArgumentException("spherical coordinate has invalid properties");
        }
    };
}
