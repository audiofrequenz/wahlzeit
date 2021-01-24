package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class RodentTest {

    Rodent capybara1 = null;
    Rodent capybara2 = null;
    Rodent guineaPig1 = null;
    Rodent guineaPig2 = null;
    RodentType nagertype1 = null;
    RodentType nagertype2 = null;

    @Before
	public void setUp() {
        nagertype1 = new RodentType("Meerschwein", 6);
        nagertype2 = new RodentType("Hase", 7);
        capybara1 = new Rodent(nagertype2, "Caviidae");
        capybara2 = new Rodent(nagertype1,"Capybara");

        guineaPig1 = new Rodent(nagertype1, "Tschudi-Meerschweinchen"); // identical information to test hashCode()
        guineaPig2 = new Rodent(nagertype1, "Tschudi-Meerschweinchen");
    }

    @Test
	public void RodentIsInstantiatedCorrectly() {
        RodentType meerschwein = new RodentType("Meerschwein", 1);
        Rodent guineaPig = new Rodent(meerschwein, "Hausmeerschweinchen");
        assertNotNull(guineaPig);
        assertEquals(guineaPig.name, "Hausmeerschweinchen");
        assertEquals(guineaPig.rodentType.averageWeight, 1);
        assertEquals(guineaPig.rodentType.rodentSpecies, "Meerschwein");
    }

    @Test
    public void equalsReturnsTrueIfIdenticalRodentsAreCompared() {
        assertEquals(guineaPig1, guineaPig1); // same instance
        assertEquals(guineaPig1, guineaPig2); // different instances, but same property information
    }

    @Test
    public void equalsReturnsFalseIfObjectsDoNotEqual() {
        assertFalse(capybara1.equals(guineaPig1));
    }

    @Test
    public void hashReturnsSameValueForIdenticalRodentInformation() {
        assertEquals(guineaPig1.hashCode(), (guineaPig2).hashCode());
    }
}
