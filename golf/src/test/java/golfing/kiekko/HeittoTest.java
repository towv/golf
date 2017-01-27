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
        Heitto heitto = new Heitto(0, 0);
        assertEquals(heitto.getVoima(), 0);

    }

    @Test
    public void uusiHeittoSuuntaOikein() {
        Heitto heitto = new Heitto(0, 0);
        assertEquals(heitto.getSuunta(), 0);

    }

    @Test
    public void uusiHeittoTiiausAlussaFalse() {
        Heitto heitto = new Heitto(0, 0);
        assertFalse(heitto.getTiiaus());

    }

    @Test
    public void setTiiausTrue() {
        Heitto heitto = new Heitto(0, 0);
        heitto.setTiiaus(true);
        assertTrue(heitto.getTiiaus());
    }

    @Test
    public void setTiiausFalse() {
        Heitto heitto = new Heitto(0, 0);
        assertFalse(heitto.getTiiaus());
        heitto.setTiiaus(true);
        assertTrue(heitto.getTiiaus());
        heitto.setTiiaus(false);
        assertFalse(heitto.getTiiaus());
    }

    @Test
    public void kasvataVoimaaToimii() {
        Heitto heitto = new Heitto(0, 0);
        heitto.kasvataVoimaa();
        heitto.kasvataVoimaa();
        assertEquals(heitto.getVoima(), 2);
    }

    @Test
    public void kasvataSuuntaaToimii() {
        Heitto heitto = new Heitto(0, 0);
        heitto.kasvataSuuntaa();
        heitto.kasvataSuuntaa();
        heitto.kasvataSuuntaa();
        assertEquals(heitto.getSuunta(), 3);
    }

    @Test
    public void vahennaVoimaaToimii() {
        Heitto heitto = new Heitto(0, 0);
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
        Heitto heitto = new Heitto(0, 0);
        heitto.vahennaVoimaa();
        heitto.vahennaVoimaa();
        assertEquals(heitto.getVoima(), 0);
    }
}
