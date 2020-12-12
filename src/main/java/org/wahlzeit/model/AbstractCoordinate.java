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
        assertCoordinateIsNotNull(coordinate);
        CartesianCoordinate currentObjectCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate givenCoordinate = coordinate.asCartesianCoordinate();
        return  Math.sqrt(Math.pow(givenCoordinate.getX() - currentObjectCoordinate.getX(), 2) +
                Math.pow(givenCoordinate.getY() - currentObjectCoordinate.getY(), 2) +
                Math.pow(givenCoordinate.getZ() - currentObjectCoordinate.getZ(), 2));
    }

    /**
     * returns the central angle between two coordinates
     * @param coordinate type Coordinate
     * @return central angle as double
     * @methodtype get
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        assertCoordinateIsNotNull(coordinate);
        SphericCoordinate currentObjectCoordinate = this.asSphericCoordinate();
        SphericCoordinate givenCoordinate = coordinate.asSphericCoordinate();
        // assert that asSphericCoordinate returned valid objects = post condition and pre condition

        //Formula for central Angle = arccos(sin(phi1)*sin(phi2)+cos(phi1)*cos(phi2)*cos())
        return doGetCentralAngle(currentObjectCoordinate, givenCoordinate);
        // check for class invariant
    }

    public double doGetCentralAngle(SphericCoordinate currentObjectCoordinate, SphericCoordinate givenCoordinate) {
        return Math.toDegrees(Math.acos(Math.sin(currentObjectCoordinate.getPhi()) *
            Math.sin(givenCoordinate.getPhi()) +
            Math.cos(currentObjectCoordinate.getPhi()) * Math.cos(givenCoordinate.getPhi()) *
            Math.cos(givenCoordinate.getTheta() - currentObjectCoordinate.getTheta())));
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
        assertCoordinateIsNotNull(other);
        CartesianCoordinate currentObjectCoordinate = this.asCartesianCoordinate();
        CartesianCoordinate otherCartesianCoordinate = other.asCartesianCoordinate();
        //assert that valid CartesianCoordinate objects where created
        return isEqualCoordinate(currentObjectCoordinate, otherCartesianCoordinate);
        //assertClassInvariant();
    }

    private boolean isEqualCoordinate(CartesianCoordinate currentObjectCoordinate,
            CartesianCoordinate otherCartesianCoordinate) {
        double tolerance = 0.001;
        boolean x_equals = Math.abs(otherCartesianCoordinate.getX()-currentObjectCoordinate.getX())<=tolerance;
        boolean y_equals = Math.abs(otherCartesianCoordinate.getY()-currentObjectCoordinate.getY())<=tolerance;
        boolean z_equals = Math.abs(otherCartesianCoordinate.getZ()-currentObjectCoordinate.getZ())<=tolerance;
        return x_equals && y_equals && z_equals;
    }


    @Override
    public int hashCode() {
        assertCoordinateIsNotNull(this);
        return Objects.hash(
                this.asCartesianCoordinate().getX(),
                this.asCartesianCoordinate().getY(),
                this.asCartesianCoordinate().getZ()
        );
    }

    public abstract void writeOn(ResultSet rset) throws SQLException;

    public void assertCoordinateIsNotNull(Coordinate coordinate) {
        if (coordinate == null) {
            throw new NullPointerException("coordinate may not be null");
        }
    }

    protected abstract void assertClassInvariant();

    // public void assertValidArgument(Object object) {
    //     if (object.getClass() != SphericCoordinate.class)
    //             throw new IllegalArgumentException("object should be of type SphericCoordinate");
    //     }
    // };
}
