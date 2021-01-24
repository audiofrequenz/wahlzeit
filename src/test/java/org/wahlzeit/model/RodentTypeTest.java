package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class RodentTypeTest {

    RodentType nagertype1 = null;
    RodentType nagertype2 = null;
    RodentType nagertype1b = null;
    RodentType nagertype2b = null;
    Rodent capybara1 = null;
    Rodent capybara2 = null;

    @Before
    public void setUp() {
        nagertype1 = new RodentType("Meerschwein", 6);
        nagertype2 = new RodentType("Hase", 7);
        nagertype1b = new RodentType("Meerschwein", 6);
        nagertype2b = new RodentType("Hase", 7);
        capybara1 = new Rodent(nagertype2, "Caviidae");
        capybara2 = new Rodent(nagertype1,"Capybara");
    }

    @Test
    public void RodentTypeIsInstantiatedCorrectly() {
        RodentType meerschwein = new RodentType("Meerschwein", 1);
        assertNotNull(meerschwein);
        assertEquals(meerschwein.averageWeight, 1);
        assertEquals(meerschwein.rodentSpecies, "Meerschwein");
    }

    @Test
    public void equalsReturnsTrueIfIdenticalRodentTypesAreCompared() {
        assertTrue(nagertype1.equals(nagertype1)); // same instance
        assertTrue(nagertype1.equals(nagertype1b)); // different instances, but same property information
    }

    @Test
    public void equalsReturnsFalseIfObjectsDoNotEqual() {
        assertFalse(nagertype1.equals(nagertype2));
    }

    @Test
    public void hashReturnsSameValueForIdenticalRodentInformation() {
        assertEquals(nagertype1.hashCode(), (nagertype1b).hashCode());
    }


    @Test
    public void hasInstanceReturnsTrueWhenObjectHasInstance() {
        nagertype1.addSubType(nagertype2);
        Rodent test = new Rodent(nagertype2);
        assertTrue(nagertype1.hasInstance(test));
    }

    @Test
    public void hasSubTypeReturnsTrueIfObjectIsSubtype() {
        nagertype1.addSubType(nagertype2);
        Rodent test = new Rodent(nagertype2);;

        assertTrue(nagertype2.isSubtype(nagertype1));
    }

    @Test
    public void hasSubTypeReturnsFalseIfObjectIsSubtype() {
        nagertype1.addSubType(nagertype2);
        Rodent test = new Rodent(nagertype2);;

        assertFalse(nagertype1.isSubtype(nagertype2));
    }

}

