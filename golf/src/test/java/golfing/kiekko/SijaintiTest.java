/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfing.kiekko;

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
public class SijaintiTest {

    private Sijainti sijainti;
    
    public SijaintiTest() {
        sijainti = new Sijainti(0, 0);
    }
    
    @Test
    public void sijaintiAlussaOikein() {
        assertEquals(sijainti.getX(), 0);
        assertEquals(sijainti.getY(), 0);
    }
    
    @Test
    public void setXtoimii() {
        sijainti.setX(10);
        assertEquals(sijainti.getX(), 10);        
    }
    
    @Test
    public void setYtoimii() {
        sijainti.setY(10);
        assertEquals(sijainti.getY(), 10);
    }
    
    @Test
    public void osuuKunOsuu() {
        assertTrue(sijainti.osuu(new Sijainti(0, 0)));
    }
    
    @Test
    public void eiOsuKunEiOsu() {
        assertFalse(sijainti.osuu(new Sijainti(0, 1)));
    }
    
    @Test
    public void eiOsuKunEiOsuX() {
        assertFalse(sijainti.osuu(new Sijainti(1, 0)));
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
    
}
