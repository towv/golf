/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfing.rata;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author twviiala
 */
public class RadatTest {
    
    public RadatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void radatTesti() {
        Radat radat = new Radat(20, 20);
        assertEquals(radat.getRadat().size(), 1);
    }
    
    @Test
    public void radoistaLoytyyRataJonkaNimiOnKumpula() {
        Radat radat = new Radat(20, 20);
        assertEquals(radat.getRadat().get("Kumpula").getNimi(), "Kumpulan frisbeegolfrata");
    }
}
