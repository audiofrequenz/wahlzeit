package org.wahlzeit.model;

import org.wahlzeit.utils.PatternInstance;

import java.sql.ResultSet;
import java.sql.SQLException;

@PatternInstance(
        patternName = "Bridge Pattern",
        participants = { "Abstraction" },
        participantObjects = {"Coordinate", "AbstractCoordinate", "SphericCoordinate", "CarthesianCoordinate"}
)
public interface Coordinate {
    CartesianCoordinate asCartesianCoordinate();
    double getCartesianDistance(Coordinate coordinate);
    SphericCoordinate asSphericCoordinate();
    double getCentralAngle(Coordinate coordinate);
    boolean isEqual(Coordinate coordinate);
    int hashCode();
    boolean equals(Object obj);
    void writeOn(ResultSet rset) throws SQLException;
}
