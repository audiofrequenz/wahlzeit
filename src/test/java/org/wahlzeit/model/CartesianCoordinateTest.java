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

    CartesianCoordinate cartesian1 = null;
    CartesianCoordinate cartesian2 = null;
    CartesianCoordinate cartesian3 = null;
    CartesianCoordinate cartesian4 = null;
    CartesianCoordinate cartesian5 = null;
    CartesianCoordinate cartesian6 = null;
    CartesianCoordinate cartesianCoordinate1 = null;
    SphericCoordinate sphericCoordinate1 = null;
    Location location1 = null;

    @Before
	public void setUp() {
        cartesian1 = new CartesianCoordinate(0.0, 2.0, 0.0);
        cartesian2 = new CartesianCoordinate(0.0, 4.0, 0.0);

        cartesian3 = new CartesianCoordinate(-2.0, 1.0, 4.0);
        cartesian4 = new CartesianCoordinate(-4.0, 3.0, 6.0);

        cartesian5 = new CartesianCoordinate(0.0, 2.0, 0.0); // identical to coordinate1

        cartesianCoordinate1 = new CartesianCoordinate(3, 4, 5);
        sphericCoordinate1 = new SphericCoordinate(0.78539816339745, 0.92729521800161, 7.0710678118655);
        
        location1 = new Location(CoordinateType.CARTESIAN, cartesian1);
    }

    @Test
	public void coordinateIsInstantiatedCorrectly() {
        CartesianCoordinate cartesian6 = new CartesianCoordinate(6.0, 7.0, 8.0);
        assertTrue(cartesian6 != null);
        assertEquals(cartesian6.getX(), 6.0, 0.0);
        assertEquals(cartesian6.getY(), 7.0, 0.0);
        assertEquals(cartesian6.getZ(), 8.0, 0.0);
    }

	@Test
	public void getDistanceReturnsCorrectValue() {
        assertEquals(cartesian1.getCartesianDistance(cartesian1), 0.0, 0.0);
        assertEquals(cartesian1.getCartesianDistance(cartesian2), 2.0, 0.0);
        assertEquals(cartesian3.getCartesianDistance(cartesian4), 3.4641016151377544, 0.0);
    }
    
    @Test
    public void equalsReturnsTrueIfIdenticalCoordinatesAreCompared() {
        assertTrue(cartesian1.equals(cartesian1)); // same instance
        assertTrue(cartesian1.equals(cartesian5)); // different instances, but same coordinates
    }

    @Test
    public void equalsReturnsFalseIfObjectIsNotACoordinate() {
        assertFalse(cartesian1.equals(location1));
    }

    @Test
    public void asSphericCoordinateReturnsCorrectCoordinate() {
        assertTrue(cartesianCoordinate1.asSphericCoordinate().equals(sphericCoordinate1));
    }

    @Test
    public void getCentralAngleReturnsCorrectValue() {
        //angle should be 0.0 as identical coordinates are compared
        assertEquals(cartesianCoordinate1.getCentralAngle(sphericCoordinate1), 0.0, 0.1); 

        //angle should be 90 degrees due to given coordinates
        CartesianCoordinate car1 = new CartesianCoordinate(0, 0, 4); //coordinate on z-axis
        CartesianCoordinate car2 = new CartesianCoordinate(5, 0, 0); //coordinate on x-axis
        double centralAngle1 = car1.getCentralAngle(car2);
        assertEquals(centralAngle1, 90.0, 0.0);
    }

    @Test
    public void correctHashCodeIsGenerated() {
        assertTrue(cartesian1.hashCode() == cartesian5.hashCode());
        assertFalse(cartesian1.hashCode() == cartesian2.hashCode());
    }

    @Test
    public void testAssertClassInvariantMethod() {  
        try
        {
            new CartesianCoordinate(6.0, Double.NaN, 3.0);
        }
        catch(Exception ex)
        {
            Exception expectedException = new IllegalArgumentException("cartesian coordinate has invalid properties");
            assertTrue(ex.getClass().equals(expectedException.getClass()));
            assertTrue(ex.getMessage().equals(expectedException.getMessage()));
        }
    }
}
