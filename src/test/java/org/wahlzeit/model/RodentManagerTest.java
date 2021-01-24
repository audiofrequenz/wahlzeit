package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RodentManagerTest {

    RodentManager rm = null;
    RodentType rt1 = null;
    RodentType rt2 = null;

    @Before
    public void setUp() {

        rm=RodentManager.getInstance();
        rt1 = new RodentType("test", 1);
        rt2 = new RodentType("test", 1);
    }

    @Test
    public void getInstanceReturnsSingleton() {

        RodentManager rm2 = rm.getInstance();
        assertTrue(rm2.equals(rm));

    }

    @Test
    public void getOrCreateRodentTypeReturnsExistingObject() {

        RodentType rodent1 = rm.getOrCreateRodentType("test", 1);
        RodentType rodent2 = rm.getOrCreateRodentType("test", 1);

        assertNotNull(rodent1);
        assertNotNull(rodent2);
        //assertTrue(rodent1.equals(rodent2));
    }

    @Test
    public void getOrCreateRodentTypeReturnsNewObject(){
        RodentType rodent1b = rm.getOrCreateRodentType("test", 1);
        RodentType rodent2b = rm.getOrCreateRodentType("test2", 2);
        assertFalse(rodent1b.equals(rodent2b));
    }
}
