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
    
    @Test
    public void liikuMetodinTestaus() {
        Kiekko kiekko = new Kiekko("nimi", 0, 1);
        assertEquals(kiekko.getSijainti().toString(), "01");
        kiekko.liiku(Suunta.YLOS);
        assertEquals(kiekko.getSijainti().toString(), "00");
    }
    
    @Test
    public void liitoTesti() {
        Kiekko kiekko = new Kiekko("nimi", 0, 0);
        assertEquals(kiekko.getLiito(), 5);
    }
    
    @Test
    public void nopeusTesti() {
        Kiekko kiekko = new Kiekko("Kalle");
        assertEquals(kiekko.getNopeus(), 5);
        
    }
    
    @Test
    public void asetaNopeusTesti() {
        Kiekko kiekko = new Kiekko("Kalle");
        kiekko.setNopeus(10);
        assertEquals(kiekko.getNopeus(), 10);
    }
    
    @Test
    public void asetaNegatiivinenNopeusTesti() {
        Kiekko kiekko = new Kiekko("Kalle");
        kiekko.setNopeus(-10);
        assertEquals(kiekko.getNopeus(), 5);
    }
    
    @Test
    public void loppufeidiTesti() {
        Kiekko kiekko = new Kiekko("Fede");
        assertEquals(kiekko.getLoppufeidi(), 0);
        kiekko.setLoppufeidi(4);
        assertEquals(kiekko.getLoppufeidi(), 4);
    }
    
    @Test
    public void kiekonNopeusTesti() {
        Kiekko kiekko = new Kiekko("Nopsa");
        assertEquals(kiekko.getNopeus(), 5);
        kiekko.setNopeus(13);
        assertEquals(kiekko.getNopeus(), 13);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    }
}
