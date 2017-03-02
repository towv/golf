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
        assertEquals(radat.getRadat().size(), 2);
    }
    
    @Test
    public void radoistaLoytyyRataJonkaNimiOnKumpula() {
        Radat radat = new Radat(20, 20);
        assertEquals(radat.getRadat().get("Kumpula").getNimi(), "Kumpulan frisbeegolfrata");
    }
    
    @Test
    public void radoistaLoytyyRataJonkaNimiOnPasila() {
        Radat radat = new Radat(20, 20);
        assertEquals(radat.getRadat().get("Pasila").getNimi(), "Pasilan frisbeegolfrata");
    }
    
    @Test
    public void ratojenKootOikein() {
        Radat radat = new Radat(20, 20);
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().size(), 6);
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().get(0).getKori().toString(), "104");
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().get(1).getKori().toString(), "1010");
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().get(2).getKori().toString(), "61");
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().get(3).getKori().toString(), "152");
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().get(4).getKori().toString(), "22");
        assertEquals(radat.getRadat().get("Kumpula").getVaylat().get(5).getKori().toString(), "1510");
        assertEquals(radat.getRadat().get("Pasila").getVaylat().size(), 3);
        assertEquals(radat.getRadat().get("Pasila").getVaylat().get(0).getKori().toString(), "116");
        assertEquals(radat.getRadat().get("Pasila").getVaylat().get(1).getKori().toString(), "111");
        assertEquals(radat.getRadat().get("Pasila").getVaylat().get(2).getKori().toString(), "185");
    }
}
