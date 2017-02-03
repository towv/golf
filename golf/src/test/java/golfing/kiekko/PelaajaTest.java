
package golfing.kiekko;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {
    
    public PelaajaTest() {
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
    public void pelaajanLuonti() {
        Pelaaja pelaaja = new Pelaaja("nimi", 0, 0);
        assertEquals(pelaaja.getNimi(), "nimi");
        assertEquals(pelaaja.montakoHeittoa(), 0);
    }
    
    @Test
    public void heitonLisays() {
        Pelaaja pelaaja = new Pelaaja("nimi", 0, 0);
        pelaaja.lisaaHeitto();
        assertEquals(pelaaja.montakoHeittoa(), 1);
    }
    
    @Test
    public void pelaajanKiekot() {
        Pelaaja pelaaja = new Pelaaja("nimi", 0, 0);
        pelaaja.lisaaKiekko();
        assertEquals(pelaaja.getKiekko("draiveri").getNimi(), "nimi");
    }
    
    @Test
    public void getKiekkoNull() {
        Pelaaja pelaaja = new Pelaaja("nimi", 0, 0);
        assertEquals(pelaaja.getKiekko("nimi"), null);
    }
}
