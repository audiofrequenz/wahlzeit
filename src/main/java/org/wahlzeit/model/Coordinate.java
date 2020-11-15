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
    private CoordinateType type = CoordinateType.UNDEFINED;

    /**
     *
     */

    public Coordinate(double x, double y, double z, CoordinateType type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.type = type;
    }

    public double getDistance(Coordinate coordinate){
        return Math.sqrt(Math.pow(coordinate.x - this.x, 2) + Math.pow(coordinate.y - this.y, 2) + Math.pow(coordinate.z - this.z, 2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;

        Coordinate other = (Coordinate) obj;
        return isEqual(other);
    }

    public boolean isEqual(Coordinate other){
        return other.x == this.x && other.y == this.y && other.z == this.z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public CoordinateType getType() {
        return type;
    }

    public void setType(CoordinateType type) {
        this.type = type;
    }
}
