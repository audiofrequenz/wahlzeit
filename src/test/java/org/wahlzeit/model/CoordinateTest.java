package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

    Coordinate coordinate1 = null;
    Coordinate coordinate2 = null;
    Coordinate coordinate3 = null;
    Coordinate coordinate4 = null;
    Coordinate coordinate5 = null;
    Coordinate coordinate6 = null;
    Location location1 = null;

    @Before
	public void setUp() {
        coordinate1 = new Coordinate(0.0, 2.0, 0.0, CoordinateType.CARTESIAN);
        coordinate2 = new Coordinate(0.0, 4.0, 0.0, CoordinateType.CARTESIAN);

        coordinate3 = new Coordinate(-2.0, 1.0, 4.0, CoordinateType.CARTESIAN);
        coordinate4 = new Coordinate(-4.0, 3.0, 6.0, CoordinateType.CARTESIAN);

        coordinate5 = new Coordinate(0.0, 2.0, 0.0, CoordinateType.UNDEFINED); // identical to coordinate1
        coordinate6 = new Coordinate(0.0, 2.0, 0.0, CoordinateType.CARTESIAN); // coordinates identical to coordinate1 but type mismatching

        location1 = new Location(coordinate1);
    }

    @Test
	public void coordinateIsInstantiatedCorrectly() {
        Coordinate coordinate7 = new Coordinate(6.0, 7.0, 8.0, CoordinateType.CARTESIAN);
        assertTrue(coordinate7 != null);
        assertEquals(coordinate7.getX(), 6.0, 0.0);
        assertEquals(coordinate7.getY(), 7.0, 0.0);
        assertEquals(coordinate7.getZ(), 8.0, 0.0);
        assertEquals(coordinate7.getType(), CoordinateType.CARTESIAN);
    }

	/**
	 *
	 */
	@Test
	public void getDistanceReturnsCorrectValue() {
        assertEquals(coordinate1.getDistance(coordinate1), 0.0, 0.0);
        assertEquals(coordinate1.getDistance(coordinate2), 2.0, 0.0);
        assertEquals(coordinate3.getDistance(coordinate4), 3.4641016151377544, 0.0);
    }
    
    @Test
    public void equalsReturnsTrueIfIdenticalCoordinatesAreCompared() {
        assertTrue(coordinate1.equals(coordinate1));
        assertTrue(coordinate1.equals(coordinate6));
    }
    
    @Test
    public void equalsReturnsFalseIfCoordinateTypesAreNotMatching() {
        assertFalse(coordinate1.equals(coordinate5));
    }

    @Test
    public void equalsReturnsFalseIfObjectIsNotACoordinate() {
        assertFalse(coordinate1.equals(location1));
    }
}
