package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Test cases for the SphericCoordinate class.
 */
public class SphericCoordinateTest {
    SphericCoordinate spheric0 = null;
    SphericCoordinate spheric1 = null;
    SphericCoordinate spheric2 = null;
    SphericCoordinate spheric3 = null;
    SphericCoordinate spheric4 = null;
    SphericCoordinate spheric5 = null;
    SphericCoordinate spheric6 = null;
    SphericCoordinate sphericCoordinate1 = null;
    CartesianCoordinate cartesianCoordinate1 = null;
    Location location1 = null;
    SphericCoordinate nullSphere = null;

    @Before
	public void setUp() {
        spheric0 = new SphericCoordinate(0.0, 0.0, 0.0); // zero-point of coordinate system
        spheric1 = new SphericCoordinate(0.0, 2.0, 0.0);
        spheric2 = new SphericCoordinate(0.0, 4.0, 0.0);

        spheric3 = new SphericCoordinate(0.0, 0.0, Math.sqrt(2.0)); // cartesian point = (0,1,1)
        spheric4 = new SphericCoordinate(-4.0, 3.0, 6.0);

        spheric5 = new SphericCoordinate(0.0, 2.0, 0.0); // identical to coordinate1

        sphericCoordinate1 = new SphericCoordinate(0.78539816339745, 0.92729521800161, 7.0710678118655);
        cartesianCoordinate1 = new CartesianCoordinate(3.0, 4.0, 5.0); //same coordinate as shpericCoordinate1 in cartesian representation
        
        location1 = new Location(CoordinateType.SPHERIC, spheric1);
    }

    @Test
	public void sphericCoordinateIsInstantiatedCorrectly() {
        SphericCoordinate spheric6 = new SphericCoordinate(6.0, 7.0, 8.0);
        assertTrue(spheric6 != null);
        assertEquals(spheric6.getPhi(), 6.0, 0.0);
        assertEquals(spheric6.getTheta(), 7.0, 0.0);
        assertEquals(spheric6.getRadius(), 8.0, 0.0);
    }
    
    @Test
    public void equalsReturnsTrueIfIdenticalCoordinatesAreCompared() {
        assertTrue(spheric1.equals(spheric1)); // same instance
        assertTrue(spheric1.equals(spheric5)); // different instances, but same coordinates
    }

    @Test 
    public void isEqualReturnsTrueIfIdenticalCoordinatesAreCompared() {
        assertTrue(spheric1.isEqual(spheric1)); // same instance
        assertTrue(spheric1.isEqual(spheric5)); // different instances, but same coordinates
    }

    @Test
    public void equalsReturnsFalseIfObjectIsNotACoordinate() {
        assertFalse(spheric1.equals(location1));
    }

    @Test
    public void asCartesianCoordinateReturnsCorrectCoordinate() {
        assertTrue(sphericCoordinate1.asCartesianCoordinate().equals(cartesianCoordinate1));
    }

    @Test
    public void getCentralAngleReturnsCorrectValueForSphericCoordinates() {
        //angle should be 0.0 as identical coordinates are compared
        assertEquals(sphericCoordinate1.getCentralAngle(sphericCoordinate1), 0.0, 0.0); 

        //angle should be 90 degrees due to given coordinates
        SphericCoordinate sphere1 = new SphericCoordinate(0, 0, 4); //coordinate on z-axis, cartesian = (0,0,4)
        SphericCoordinate sphere2 = new SphericCoordinate(0, 1.5707963267948966, 5); //coordinate on x-axis, cartesian = (5,0,0)
        double centralAngle1 = sphere1.getCentralAngle(sphere2);
        assertEquals(centralAngle1, 90, 0.0001);
    }

    @Test
    public void getCentralAngleReturnsCorrectValueWhenComparingCartesianToSphericCoordinates() {
        //angle should be 0.0 as identical coordinates are compared
        assertEquals(cartesianCoordinate1.getCentralAngle(cartesianCoordinate1), 0.0, 0.0); 

        //angle should be 0 degrees since both coordinate lie on the z-axis
        CartesianCoordinate car1 = new CartesianCoordinate(0.0, 0.0, 4.0); //coordinate on z-axis
        SphericCoordinate sphere1 = new SphericCoordinate(0, 0, 5); //a different coordinate on z-axis
        double centralAngle1 = car1.getCentralAngle(sphere1);
        assertEquals(centralAngle1, 0, 0.0);
    }

    @Test
    public void getCartesianDistanceReturnsCorrectValueWhenComparingSphericCoordinats() {
        assertEquals(sphericCoordinate1.getCartesianDistance(sphericCoordinate1), 0.0, 0.0); 

        //distance should be 1 due to given coordinates
        SphericCoordinate sphere1 = new SphericCoordinate(0, 0, 4); //coordinate on z-axis, cartesian = (0,0,4)
        SphericCoordinate sphere2 = new SphericCoordinate(0, 0, 5); //a different coordinate on z-axis, cartesian = (0,0,5)
        double cartesianDistance = sphere1.getCartesianDistance(sphere2);
        assertEquals(cartesianDistance, 1, 0.0);
    }

    @Test
    public void correctHashCodeIsGenerated() {
        assertEquals(spheric1.hashCode(), spheric5.hashCode(), 0.0); 
        assertFalse(spheric1.hashCode() == spheric2.hashCode()); 
    }
    
    @Test
    public void testIfCorrectExceptionIsThrownIfParameterCoordinateIsNull() {
        try
        {
            spheric0.getCartesianDistance(nullSphere);
        }
        catch(Exception ex)
        {
            Exception expectedException = new NullPointerException("Object may not be null");
            assertTrue(ex.getClass().equals(expectedException.getClass()));
            assertTrue(ex.getMessage().equals(expectedException.getMessage()));
        }
    }

    @Test
    public void shouldThrowNullPointerException() {        
        try
        {
            nullSphere.getCartesianDistance(spheric0);
        }
        catch(Exception ex)
        {
            Exception expectedException = new NullPointerException();
            assertTrue(ex.getClass().equals(expectedException.getClass()));
        }
    }

    @Test
    public void testAssertClassInvariantMethod() {        
        try
        {
            spheric0.assertClassInvariant();
        }
        catch(Exception ex)
        {
            Exception expectedException = new IllegalArgumentException("spherical coordinate has invalid properties");
            assertTrue(ex.getClass().equals(expectedException.getClass()));
            assertTrue(ex.getMessage().equals(expectedException.getMessage()));
        }
    }
}
