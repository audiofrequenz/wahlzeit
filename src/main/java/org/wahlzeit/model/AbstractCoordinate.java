package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate{

    /**
     * Calculates the distance between two cartesian coordinates
     * @param coordinate type Coordinate
     * @return double with cartesian distance between current coordinate and given parameter coordinate
     * @methodtype get
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        assertClassInvariant();
        assertObjectIsNotNull(coordinate);
        CartesianCoordinate currentObjectCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate givenCoordinate = coordinate.asCartesianCoordinate();
        double distance = Math.sqrt(Math.pow(givenCoordinate.getX() - currentObjectCoordinate.getX(), 2) +
                Math.pow(givenCoordinate.getY() - currentObjectCoordinate.getY(), 2) +
                Math.pow(givenCoordinate.getZ() - currentObjectCoordinate.getZ(), 2));
        assertArgumentIsNaN(distance);
        assertValueValid(distance);
        assertClassInvariant();
        return distance;
    }

    /**
     * returns the central angle between two coordinates
     * @param coordinate type Coordinate
     * @return central angle as double
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        assertClassInvariant();
        assertObjectIsNotNull(coordinate);
        SphericCoordinate currentObjectCoordinate = this.asSphericCoordinate();
        SphericCoordinate givenCoordinate = coordinate.asSphericCoordinate();

        //Formula for central Angle = arccos(sin(phi1)*sin(phi2)+cos(phi1)*cos(phi2)*cos())
        double centralAngle = doGetCentralAngle(currentObjectCoordinate, givenCoordinate);
        assertArgumentIsNaN(centralAngle);
        assertClassInvariant();
        return centralAngle;
    }

    public double doGetCentralAngle(SphericCoordinate currentObjectCoordinate, SphericCoordinate givenCoordinate) {
        assertClassInvariant();
        assertObjectIsNotNull(currentObjectCoordinate);
        assertObjectIsNotNull(givenCoordinate);
        double angle = Math.toDegrees(Math.acos(Math.sin(currentObjectCoordinate.getPhi()) *
                Math.sin(givenCoordinate.getPhi()) +
                Math.cos(currentObjectCoordinate.getPhi()) * Math.cos(givenCoordinate.getPhi()) *
                        Math.cos(givenCoordinate.getTheta() - currentObjectCoordinate.getTheta())));
        assertArgumentIsNaN(angle);
        assertClassInvariant();
        return angle;
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
     * @return true if x, y, z value of a coordinate equals the x, y, z of the current object
     * @methodtype comparison
     */
    @Override
    public boolean isEqual(Coordinate other){
        assertClassInvariant();
        assertObjectIsNotNull(other);
        CartesianCoordinate currentObjectCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate otherCartesianCoordinate = other.asCartesianCoordinate();
        boolean areCoordinatesEqual = isEqualCoordinate(currentObjectCoordinate, otherCartesianCoordinate);
        assertClassInvariant();
        return areCoordinatesEqual;
    }

    /**
     * checks whether the x, y and z coordinates of a given object is equal to another coordinate
     * @param currentObjectCoordinate currentObjectCoordinate type Coordinate
     * @param otherCartesianCoordinate otherCartesianCoordinate type Coordinate
     * @return true if x, y, z value of a coordinate equals the x, y, z of the other coordinate
     * @methodtype comparison
     */
    private boolean isEqualCoordinate(CartesianCoordinate currentObjectCoordinate,
            CartesianCoordinate otherCartesianCoordinate) {
        assertClassInvariant();
        assertObjectIsNotNull(currentObjectCoordinate);
        assertObjectIsNotNull(otherCartesianCoordinate);
        double tolerance = 0.001;
        boolean x_equals = Math.abs(otherCartesianCoordinate.getX()-currentObjectCoordinate.getX())<=tolerance;
        boolean y_equals = Math.abs(otherCartesianCoordinate.getY()-currentObjectCoordinate.getY())<=tolerance;
        boolean z_equals = Math.abs(otherCartesianCoordinate.getZ()-currentObjectCoordinate.getZ())<=tolerance;
        assertClassInvariant();
        return x_equals && y_equals && z_equals;
    }


    @Override
    public int hashCode() {
        assertClassInvariant();
        assertObjectIsNotNull(this);
        int hash = Objects.hash(
                this.asCartesianCoordinate().getX(),
                this.asCartesianCoordinate().getY(),
                this.asCartesianCoordinate().getZ());
        assertClassInvariant();
        return hash;
    }

    public abstract void writeOn(ResultSet rset) throws SQLException;

    /**
     * Check that the object is not null.
     * @param object
     * @methodtype condition
     */
    public void assertObjectIsNotNull(Object object) {
        if (object == null) {
            throw new NullPointerException("Object may not be null");
        }
    }

    /**
     * Check that the values are not NaN.
     * @methodtype invariant
     */
    protected abstract void assertClassInvariant();

    /**
     * Check that the values not smaller than 0.
     * @param value
     * @methodtype condition
     */
    protected void assertValueValid(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value should not be smaller than Zero");
        }
    }

    /**
     * Check that the values are not NaN.
     * @param value
     * @methodtype condition
     */
    public void assertArgumentIsNaN(double value) {
        if(Double.isNaN(value)) {
            throw new IllegalArgumentException("value has to be a number (double)");
        }
    }
    // public void assertValidArgument(Object object) {
    //     if (object.getClass() != SphericCoordinate.class)
    //             throw new IllegalArgumentException("object should be of type SphericCoordinate");
    //     }
    // };
}
