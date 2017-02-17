/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfing.rata;

import golfing.kiekko.Kori;
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
public class RataTest {
    
    public RataTest() {
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
    public void rataTesti() {
        Rata rata = new Rata("rata");
        assertEquals(rata.getNimi(), "rata");
        assertEquals(rata.getVaylat().size(), 0);
        rata.lisaaVayla(new Vayla(new Kori(0, 0), 3));
        assertEquals(rata.getVaylat().size(), 1);
        
    }
}
