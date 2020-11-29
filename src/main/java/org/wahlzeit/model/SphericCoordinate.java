package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SphericCoordinate implements Coordinate{
    private double phi;
    private double theta;

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;

    public SphericCoordinate(double phi, double theta, double radius) {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.radius * Math.sin(this.phi)*Math.cos(this.theta);
        double y = this.radius * Math.sin(this.phi)*Math.sin(this.theta);
        double z = this.radius * Math.cos(this.phi);
        return new CartesianCoordinate(x,y,z);
    }

    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return this.asCartesianCoordinate().getCartesianDistance(coordinate);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

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

    public void writeOn(ResultSet rset) throws SQLException {
        rset.updateDouble("coordinate_unit_1", this.phi);
        rset.updateDouble("coordinate_unit_2", this.theta);
        rset.updateDouble("coordinate_unit_3", this.radius);
    }

    @Override
    public boolean isEqual(Coordinate coordinate) {
        SphericCoordinate otherSphericCoordinate = coordinate.asSphericCoordinate();
        double tolerance = 0.001;
        boolean x_equals = Math.abs(otherSphericCoordinate.phi-this.phi)<=tolerance;
        boolean y_equals = Math.abs(otherSphericCoordinate.theta-this.theta)<=tolerance;
        boolean z_equals = Math.abs(otherSphericCoordinate.radius-this.radius)<=tolerance;
        return x_equals && y_equals && z_equals;
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
        if (!(obj instanceof SphericCoordinate)) return false;

        SphericCoordinate other = (SphericCoordinate) obj;
        return isEqual(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.radius, this.theta, this.phi);
    }
}
