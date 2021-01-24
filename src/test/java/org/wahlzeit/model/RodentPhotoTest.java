package org.wahlzeit.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Photo class.
 */
public class RodentPhotoTest {
    ResultSet mockedResultSet = null;

    @Before
    public void setUp() throws SQLException{
        this.mockedResultSet = mock(ResultSet.class);
        when(mockedResultSet.getInt("id")).thenReturn(256);
        when(mockedResultSet.getString("owner_name")).thenReturn("Capy Bara");
        when(mockedResultSet.getBoolean("owner_notify_about_praise")).thenReturn(true);
        when(mockedResultSet.getString("owner_email_address")).thenReturn("capy@bara.de");
        when(mockedResultSet.getInt("owner_language")).thenReturn(0);
        when(mockedResultSet.getString("owner_home_page")).thenReturn("http://wahlzeit.org/filter?userName=test");
        when(mockedResultSet.getInt("width")).thenReturn(256);
        when(mockedResultSet.getInt("height")).thenReturn(256);
        when(mockedResultSet.getString("tags")).thenReturn("rodent, South America, carpincho");
        when(mockedResultSet.getInt("status")).thenReturn(0);
        when(mockedResultSet.getInt("praise_sum")).thenReturn(10);
        when(mockedResultSet.getInt("no_votes")).thenReturn(1);
        when(mockedResultSet.getLong("creation_time")).thenReturn((long)1605969534);
        when(mockedResultSet.getDouble("cartesian_x")).thenReturn(7.714098632473078);
        when(mockedResultSet.getDouble("cartesian_x")).thenReturn(5.979821442798164);
        when(mockedResultSet.getDouble("cartesian_x")).thenReturn(8.746107596310631);
        when(mockedResultSet.getInt("coordinate_type")).thenReturn(1);
        when(mockedResultSet.getString("rodentname")).thenReturn("Capybara");
        when(mockedResultSet.getString("rodentspecies")).thenReturn("Meerschwein");
        when(mockedResultSet.getInt("averageweight")).thenReturn(57);
        when(mockedResultSet.next()).thenReturn(true).thenReturn(false);
    }

    @Test
    public void rodentPhotoByDefaultConstructorIsInstantiatedCorrectly() {
        RodentPhoto testPhoto = new RodentPhoto();
        assertNotNull(testPhoto);
    }

    @Test
    public void rodentPhotoByResultSetConstructorIsInstantiatedCorrectly() throws SQLException{
        RodentPhoto testPhoto = new RodentPhoto(this.mockedResultSet);
        Rodent rodent = testPhoto.getRodent();
        assertNotNull(rodent);
        assertEquals("Capybara", rodent.name);
        assertEquals(57, rodent.getRodentType().getAverageWeight());
        assertEquals("Meerschwein", rodent.rodentType.rodentSpecies);
    }

    @Test
    public void rodentPhotoByIdIsInstantiatedCorrectly(){
        PhotoId mockedPhotoId = mock(PhotoId.class);
        RodentPhoto testPhoto = new RodentPhoto(mockedPhotoId);
        assertNotNull(testPhoto.location);
        assertNotNull(testPhoto.location.coordinate);
    }
}
