package org.wahlzeit.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class RodentTest {

    Rodent capybara1 = null;
    Rodent capybara2 = null;
    Rodent guineaPig1 = null;
    Rodent guineaPig2 = null;

//    @Before
//	public void setUp() {
//        capybara1 = new Rodent("Hydrochoerus hydrochaeris", "Caviidae", 50);
//        capybara2 = new Rodent("Capybara", "Meerschweinchen", 50);
//
//        guineaPig1 = new Rodent("Tschudi-Meerschweinchen", "Meerschweinchen", 1); // identical information to test hashCode()
//        guineaPig2 = new Rodent("Tschudi-Meerschweinchen", "Meerschweinchen", 1);
//    }
//
//    @Test
//	public void RodentIsInstantiatedCorrectly() {
//        Rodent guineaPig = new Rodent("Hausmeerschweinchen", "Meerschweinchen", 1);
//        assertTrue(guineaPig != null);
//        assertEquals(guineaPig.getRodentType(), "Hausmeerschweinchen");
//        assertEquals(guineaPig.getFamily(), "Meerschweinchen");
//        assertEquals(guineaPig.getAverageWeight(), 1);
//    }
//
//    @Test
//    public void equalsReturnsTrueIfIdenticalRodentsAreCompared() {
//        assertTrue(guineaPig1.equals(guineaPig1)); // same instance
//        assertTrue(guineaPig1.equals(guineaPig2)); // different instances, but same property information
//    }
//
//    @Test
//    public void equalsReturnsFalseIfObjectsDoNotEqual() {
//        assertFalse(capybara1.equals(guineaPig1));
//    }
//
//    @Test
//    public void hashReturnsSameValueForIdenticalRodentInformation() {
//        assertEquals(guineaPig1.hashCode(), (guineaPig2).hashCode());
//    }
}
