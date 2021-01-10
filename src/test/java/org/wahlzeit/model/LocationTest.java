package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test cases for the Location class.
 */
public class LocationTest {

    /**
	 *
	 */
    @Test
	public void locationisInstantiatedCorrectlyWithCartesianCoordinate() {
        // mocked version
        CartesianCoordinate mockedCoordinate = mock(CartesianCoordinate.class);
        when(mockedCoordinate.getX()).thenReturn(0.0);
        when(mockedCoordinate.getY()).thenReturn(2.0);
        when(mockedCoordinate.getZ()).thenReturn(0.0);
        Location location1 = new Location(CoordinateType.CARTESIAN, mockedCoordinate);
        assertEquals(location1.coordinate, mockedCoordinate);
        
        // version without mock 
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.doGetOrCreateCoordinate(0.0, 2.0, 0.0);
        Location location2 = new Location(CoordinateType.CARTESIAN, cartesianCoordinate);
        assertTrue(location2 != null);
        assertEquals(location2.coordinate, cartesianCoordinate);
    }


    @Test
    public void locationisInstantiatedCorrectlyWithSphericCoordinate() {
        // mocked version
        SphericCoordinate mockedCoordinate = mock(SphericCoordinate.class);
        when(mockedCoordinate.getPhi()).thenReturn(0.0);
        when(mockedCoordinate.getTheta()).thenReturn(2.0);
        when(mockedCoordinate.getRadius()).thenReturn(0.0);
        Location location1 = new Location(CoordinateType.SPHERIC, mockedCoordinate);
        assertEquals(location1.coordinate, mockedCoordinate);

        // version without mock 
        SphericCoordinate sphericCoordinate = SphericCoordinate.doGetOrCreateCoordinate(20.0, 50.0, 3.0);
        Location location2 = new Location(CoordinateType.SPHERIC, sphericCoordinate);
        assertTrue(location2 != null);
        assertEquals(location2.coordinate, sphericCoordinate);
    }
}
