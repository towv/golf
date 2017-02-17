package golfing.kiekko;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        kiekko.liiku(Suunta.NORTH);
        assertEquals(kiekko.getSijainti().toString(), "00");
    }
    
    @Test
    public void liikuVasenTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        assertEquals(kiekko.getSijainti().toString(), "22");
        kiekko.liiku(Suunta.WEST);
        assertEquals(kiekko.getSijainti().toString(), "12");
    }
    
    @Test
    public void liikuOikeaanTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        assertEquals(kiekko.getSijainti().toString(), "22");
        kiekko.liiku(Suunta.EAST);
        assertEquals(kiekko.getSijainti().toString(), "32");
    }
    
    @Test
    public void liikuSouthTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        kiekko.liiku(Suunta.SOUTH);
        assertEquals(kiekko.getSijainti().toString(), "23");
    }
    
    @Test
    public void liikuNorthEastTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        kiekko.liiku(Suunta.NORTHEAST);
        assertEquals(kiekko.getSijainti().toString(), "31");
    }
    
    @Test
    public void liikuNorthWestTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        kiekko.liiku(Suunta.NORTHWEST);
        assertEquals(kiekko.getSijainti().toString(), "11");
    }
    
    @Test
    public void liikuSouthEastTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        kiekko.liiku(Suunta.SOUTHEAST);
        assertEquals(kiekko.getSijainti().toString(), "33");
    }
    
    @Test
    public void liikuSouthWestTesti() {
        Kiekko kiekko = new Kiekko("nimi", 2, 2);
        kiekko.liiku(Suunta.SOUTHWEST);
        assertEquals(kiekko.getSijainti().toString(), "13");
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
    public void nopeusNolla() {
        Kiekko kiekko = new Kiekko("Ville");
        kiekko.setNopeus(0);
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
    
    @Test
    public void variTesti() {
        Kiekko keikko = new Kiekko("Liila");
        assertEquals(keikko.getVari(), Vari.LIILA);
    }
    
    @Test
    public void asetaSijainti() {
        Kiekko keikko = new Kiekko("Liila");
        keikko.setSijainti(new Sijainti(10, 10));
        assertEquals(keikko.getSijainti().toString(), "1010");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    }
}
