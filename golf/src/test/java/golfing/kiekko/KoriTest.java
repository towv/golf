
package golfing.kiekko;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KoriTest {
    
    public KoriTest() {
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
    public void koriTest() {
        Kori kori = new Kori(0, 0);
        assertTrue(kori.osuu(kori));
        assertFalse(kori.osuu(new Sijainti(2, 0)));
        kori.setX(5);
        assertEquals(kori.getX(), 5);
        assertEquals(kori.getY(), 0);
    }
}
