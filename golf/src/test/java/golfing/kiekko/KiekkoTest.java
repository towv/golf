package golfing.kiekko;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import golfing.kiekko.Kiekko;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author twviiala
 */
public class KiekkoTest {
    
    public KiekkoTest() {
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
    public void kiekollaOnNimi() {
        Kiekko kiekko = new Kiekko("Tero");
        String nimi = kiekko.getNimi();
        assertEquals("Tero", nimi);
        
    }
    
    @Test
    public void kiekollaOnLiito() {
        Kiekko kiekko = new Kiekko("Jens");
        assertEquals(5, kiekko.getLiito());
    }
    
    @Test
    public void setNimiTesti() {
        Kiekko kiekko = new Kiekko("Jens");
        kiekko.setNimi("");
        assertEquals("Jens", kiekko.getNimi());
        kiekko.setNimi("Rane");
        assertEquals("Rane", kiekko.getNimi());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}
}
