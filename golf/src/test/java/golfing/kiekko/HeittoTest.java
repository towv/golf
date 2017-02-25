package golfing.kiekko;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeittoTest {

    public HeittoTest() {
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
    public void uusiHeittoVoimaOikein() {
        Heitto heitto = new Heitto(0);
        assertEquals(heitto.getVoima(), 0);

    }

    @Test
    public void uusiHeittoSuuntaOikein() {
        Heitto heitto = new Heitto(0);
        assertEquals(heitto.getSuunta(), null);

    }

    @Test
    public void uusiHeittoTiiausAlussaFalse() {
        Heitto heitto = new Heitto(0);
        assertFalse(heitto.getTiiaus());

    }

    @Test
    public void setTiiausTrue() {
        Heitto heitto = new Heitto(0);
        heitto.setTiiaus(true);
        assertTrue(heitto.getTiiaus());
    }

    @Test
    public void setTiiausFalse() {
        Heitto heitto = new Heitto(0);
        assertFalse(heitto.getTiiaus());
        heitto.setTiiaus(true);
        assertTrue(heitto.getTiiaus());
        heitto.setTiiaus(false);
        assertFalse(heitto.getTiiaus());
    }

    @Test
    public void kasvataVoimaaToimii() {
        Heitto heitto = new Heitto(0);
        heitto.kasvataVoimaa();
        heitto.kasvataVoimaa();
        assertEquals(heitto.getVoima(), 2);
    }

    @Test
    public void asetaSuuntaToimiiTupla() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
    }

    @Test
    public void asetaSuuntaToimiiYksiHeitonVoimaPuolittuu() {
        Heitto heitto = new Heitto(10);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.EAST);
        assertEquals(heitto.getVoima(), 5);
    }

    @Test
    public void asetaKolmeSuuntaaLiikkuuKahdenMukaan() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
    }

    @Test
    public void vahennaVoimaaToimii() {
        Heitto heitto = new Heitto(0);
        heitto.kasvataVoimaa();
        heitto.kasvataVoimaa();
        assertEquals(heitto.getVoima(), 2);
        heitto.vahennaVoimaa();
        assertEquals(heitto.getVoima(), 1);
        heitto.vahennaVoimaa();
        assertEquals(heitto.getVoima(), 0);
    }

    @Test
    public void voimaEiMeneNegatiiviseksi() {
        Heitto heitto = new Heitto(0);
        heitto.vahennaVoimaa();
        heitto.vahennaVoimaa();
        assertEquals(heitto.getVoima(), 0);
    }

    @Test
    public void asetaVoimaTesti() {
        Heitto heitto = new Heitto(0);
        heitto.setVoima(10);
        assertEquals(heitto.getVoima(), 10);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatSouthEast() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTHEAST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatSouthEast2() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTHEAST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatSouthWest() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.WEST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTHWEST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatSouthWest2() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.WEST);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTHWEST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatNorthEast() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.NORTH);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.NORTHEAST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatNorthEast2() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.syotaSuunta(Suunta.NORTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.NORTHEAST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatNorthWEST() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.NORTH);
        heitto.syotaSuunta(Suunta.WEST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.NORTHWEST);
    }

    @Test
    public void suunnanAsetusTestiEriSuunnatNorthWEST2() {
        Heitto heitto = new Heitto(0);
        heitto.syotaSuunta(Suunta.WEST);
        heitto.syotaSuunta(Suunta.NORTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.NORTHWEST);
    }

    @Test
    public void suunnanAsetusTestiVastakkaiset() {
        Heitto heitto = new Heitto(4);
        heitto.syotaSuunta(Suunta.EAST);
        heitto.syotaSuunta(Suunta.WEST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.EAST);
        assertEquals(heitto.getVoima(), 2);
    }

    @Test
    public void suunnanAsetusTestiVastakkaiset2() {
        Heitto heitto = new Heitto(4);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.NORTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
        assertEquals(heitto.getVoima(), 2);
    }

    @Test
    public void puolitaHeitonVoimaTesti() {
        Heitto heitto = new Heitto(20);
        heitto.puolitaHeitonVoima();
        assertEquals(heitto.getVoima(), 10);
    }

    @Test
    public void puolitaHeitonVoimaTestiArvoSuunta() {
        Heitto heitto = new Heitto(20);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getVoima(), 10);
    }

    @Test
    public void vahvistaHeittoPuolitusOikeinSuurempiKuinKuusi() {
        Heitto heitto = new Heitto(20);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getPuolivali(), 5);
    }

    @Test
    public void vahvistaHeittoPuolitusOikeinKuusi() {
        Heitto heitto = new Heitto(12);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getPuolivali(), -1);
    }

    @Test
    public void sMutkaTestit() {
        Heitto heitto = new Heitto(10);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.vahvistaHeitto();
        heitto.sMutka(-1);
        assertEquals(heitto.getSuunta(), Suunta.SOUTHWEST);
        heitto.palautaAlkuperainenSuunta();
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
        heitto.sMutka(1);
        assertEquals(heitto.getSuunta(), Suunta.SOUTHEAST);
        heitto.sMutka(0);
        assertEquals(heitto.getSuunta(), Suunta.SOUTHEAST);
    }

    @Test
    public void setFeidaa() {
        Heitto heitto = new Heitto(10);
        heitto.vahvistaHeitto();
        assertEquals(heitto.isFeidaa(), false);
        heitto.setFeidaa(true);
        assertEquals(heitto.isFeidaa(), true);
    }

    @Test
    public void uusiHeittoTestit() {
        Heitto heitto = new Heitto(10);
        heitto.vahvistaHeitto();
        assertTrue(heitto.isUusiHeitto());
        heitto.setUusiHeitto(false);
        assertFalse(heitto.isUusiHeitto());
    }

    @Test
    public void feidausToimiiTesti() {
        Heitto heitto = new Heitto(10);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.syotaSuunta(Suunta.SOUTH);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
        heitto.feidaa(0, 0);
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
        heitto.feidaa(-1, 10);
        assertEquals(heitto.getSuunta(), Suunta.SOUTHEAST);
        assertEquals(heitto.getVoima(), 10);
        heitto.feidaa(1, 5);
        assertEquals(heitto.getSuunta(), Suunta.SOUTH);
    }
    
    @Test
    public void heittoFeidaa() {
        Heitto heitto = new Heitto(0);
        heitto.feidaa(1, 8);
        assertEquals(heitto.getVoima(), 8);
        heitto.syotaSuunta(Suunta.NORTHWEST);
        heitto.syotaSuunta(Suunta.NORTHWEST);
        heitto.vahvistaHeitto();
        assertEquals(heitto.getSuunta(), Suunta.NORTHWEST);
        heitto.feidaa(-1, 3);
        assertEquals(heitto.getSuunta(), Suunta.WEST);
        heitto.feidaa(1, 3);
        assertEquals(heitto.getSuunta(), Suunta.NORTHWEST);
        assertEquals(heitto.getVoima(), 3);
    }
}
