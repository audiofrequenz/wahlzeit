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
	public void locationisInstantiatedCorrectly() {
        // mocked version, mock is not needed here though, was just figuring out how it works
        CartesianCoordinate mockedCoordinate = mock(CartesianCoordinate.class);
        when(mockedCoordinate.getX()).thenReturn(0.0);
        when(mockedCoordinate.getY()).thenReturn(2.0);
        when(mockedCoordinate.getZ()).thenReturn(0.0);
        Location location1 = new Location(mockedCoordinate);
        assertEquals(location1.cartesianCoordinate, mockedCoordinate);

        
        // version without mock 
        // CartesianCoordinate coordinate1 = new CartesianCoordinate(0.0, 2.0, 0.0);
        // Location location1 = new Location(coordinate1);
        // assertTrue(location1 != null);
        // assertEquals(location1.cartesianCoordinate, coordinate1);
    }
}
