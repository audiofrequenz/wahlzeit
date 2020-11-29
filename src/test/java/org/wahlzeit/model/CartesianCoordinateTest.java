package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Test cases for the Coordinate class.
 */
public class CartesianCoordinateTest {

    CartesianCoordinate coordinate1 = null;
    CartesianCoordinate coordinate2 = null;
    CartesianCoordinate coordinate3 = null;
    CartesianCoordinate coordinate4 = null;
    CartesianCoordinate coordinate5 = null;
    CartesianCoordinate coordinate6 = null;
    Location location1 = null;

    @Before
	public void setUp() {
        coordinate1 = new CartesianCoordinate(0.0, 2.0, 0.0);
        coordinate2 = new CartesianCoordinate(0.0, 4.0, 0.0);

        coordinate3 = new CartesianCoordinate(-2.0, 1.0, 4.0);
        coordinate4 = new CartesianCoordinate(-4.0, 3.0, 6.0);

        coordinate5 = new CartesianCoordinate(0.0, 2.0, 0.0); // identical to coordinate1

        //location1 = new Location(coordinate1);
    }

    @Test
	public void coordinateIsInstantiatedCorrectly() {
        CartesianCoordinate coordinate6 = new CartesianCoordinate(6.0, 7.0, 8.0);
        assertTrue(coordinate6 != null);
        assertEquals(coordinate6.getX(), 6.0, 0.0);
        assertEquals(coordinate6.getY(), 7.0, 0.0);
        assertEquals(coordinate6.getZ(), 8.0, 0.0);
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
        assertTrue(coordinate1.equals(coordinate1)); // same instance
        assertTrue(coordinate1.equals(coordinate5)); // different instances, but same coordinates
    }

    @Test
    public void equalsReturnsFalseIfObjectIsNotACoordinate() {
        assertFalse(coordinate1.equals(location1));
    }
}
