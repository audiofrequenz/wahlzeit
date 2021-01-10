package org.wahlzeit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

public class CartesianCoordinate extends AbstractCoordinate{
    private final double x;
    private final double y;
    private final double z;
    private static ConcurrentHashMap<Integer, CartesianCoordinate> coordinateHashMap = new ConcurrentHashMap<>();
    /**
     * Coordinate constructor implements a new object with given features
     * @param x x-value of Coordinate
     * @param y y-value of Coordinate
     * @param z z-value of Coordinate
     * @methodtype initialization
     */
    private CartesianCoordinate(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        assertClassInvariant();
    }

    /**
     * Returns coordinates of type Cartesian with given parameters if coordinate does not exist
     * @param x double
     * @param y double
     * @param z double
     * @methodtype getter
     */
    public static CartesianCoordinate doGetOrCreateCoordinate(double x, double y, double z) {
        CartesianCoordinate coord = new CartesianCoordinate(x, y, z);
        int coordHash = coord.hashCode();
        synchronized (coordinateHashMap) {
            if (coordinateHashMap.get(coordHash) != null) {
                coordinateHashMap.put(coordHash, coord);
            }
            return coord;
        }
    }

    /**
     * wirtes coordinate details from rset into update object
     * @param rset ResultSet containing RodentPhoto information
     * @methodtype command
     */
    public void writeOn(ResultSet rset) throws SQLException {
        assertClassInvariant();
        rset.updateDouble("coordinate_unit_1", this.x);
        rset.updateDouble("coordinate_unit_2", this.y);
        rset.updateDouble("coordinate_unit_3", this.z);
        assertClassInvariant();
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
     * Getter for y value
     * @return y
     * @methodtype get
     */
    public double getY() {
        return y;
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
     * returns coordinate as cartesian coordinate
     * @return this object
     * @methodtype conversion
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        assertClassInvariant();
        assertObjectIsNotNull(this);
        return this;
    }

    /**
     * returns coordinate as spheric coordinate
     * @return spheric coordinate
     * @methodtype conversion
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariant();
        assertObjectIsNotNull(this);
        double radius = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        double theta = 0;
        if(this.x != 0) {
            theta = Math.atan(this.y / this.x);
        }
        double phi = Math.atan(Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2))/this.z);
        SphericCoordinate coordinate = SphericCoordinate.doGetOrCreateCoordinate(phi, theta, radius);
        assertClassInvariant();
        return coordinate;
    }

    @Override
    public void assertClassInvariant() {
        if (Double.isNaN(this.getX())
            || Double.isNaN(this.getY())
            || Double.isNaN(this.getZ())) {
                throw new IllegalArgumentException("cartesian coordinate has invalid properties");
        }
    };
}
