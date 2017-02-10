/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfing.peli;

import golfing.gui.Paivitettava;
import golfing.kiekko.Kiekko;
import golfing.kiekko.Kori;
import golfing.kiekko.Pelaaja;
import golfing.rata.Radat;
import java.awt.event.ActionEvent;
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
public class KiekkopeliTest {

    private Kiekkopeli kiekkopeli;

    public KiekkopeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Pelaaja pelaaja = new Pelaaja("Super-Pelaaja", 20, 20);
        pelaaja.lisaaKiekko();
        this.kiekkopeli = new Kiekkopeli(20, 20, pelaaja,
                "Kumpula", new Radat(20, 20));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void radanNimiTesti() {
        assertEquals(kiekkopeli.getRata(), "Kumpulan frisbeegolfrata");
    }

    @Test
    public void pelaajanNimiOikein() {
        assertEquals(kiekkopeli.getPelaaja().getNimi(), "Super-Pelaaja");
    }

    @Test
    public void haeHeittoTesti() {
        assertEquals(kiekkopeli.getHeitto(), kiekkopeli.getPelaaja().getHeitto());
    }

    @Test
    public void haeKiekkoTesti() {
        assertEquals(kiekkopeli.getKiekko().getNimi(), "draiveri");
    }

    @Test
    public void asetaKiekkoTesti() {
        kiekkopeli.setKiekko(new Kiekko("Kiekko", 0, 0));
        assertEquals(kiekkopeli.getKiekko().getNimi(), "Kiekko");
    }

    @Test
    public void haeKoriTesti() {
        kiekkopeli.setKori(new Kori(0, 0));
        assertEquals(kiekkopeli.getKori().toString(), "00");
    }

    @Test
    public void jatkuuTestiAlkuun() {
        assertTrue(kiekkopeli.jatkuu());
    }

    @Test
    public void korkeusTesti() {
        assertEquals(kiekkopeli.getKorkeus(), 20);
    }

    @Test
    public void leveysTesti() {
        assertEquals(kiekkopeli.getLeveys(), 20);
    }

    @Test
    public void tilanneAlussaOikeinTesti() {
        assertEquals(kiekkopeli.getTilanne(), "Heittoja: 0");
    }

    @Test
    public void viestiAlussaOikein() {
        assertEquals(kiekkopeli.getViesti(), "Tervehdys "
                + kiekkopeli.getPelaaja().getNimi() + "! (:\nVaro puuta!");
    }

    @Test
    public void viestiKeskenOikein() {
        kiekkopeli.getPelaaja().lisaaHeitto();
        assertEquals(kiekkopeli.getViesti(), " \n ");
    }

    @Test
    public void viestiOikeinJatkuuFalseLiianlujaaFalseEliKiekkoKorissa() {
        kiekkopeli.setJatkuu(false);
        kiekkopeli.getPelaaja().lisaaHeitto();
        assertEquals(kiekkopeli.getViesti(), "KORISSA! \nSelvitit väylän "
                + kiekkopeli.getPelaaja().montakoHeittoa() + " heitolla.");
    }

    @Test
    public void viestiOikeinKunJatkuuFalseLiianlujaaTrueEliKiekkoOsuuKoriinLiianLujallaJaljellaOlevallaVoimalla() {
        kiekkopeli.setJatkuu(false);
        kiekkopeli.setLiianlujaa(true);
        kiekkopeli.getPelaaja().lisaaHeitto();
        assertEquals(kiekkopeli.getViesti(), "Kiekko tippui korista! "
                + "\nJoudutaan heittämään vielä kerran...");
    }
    
    @Test
    public void asetaPaivitettava() {
        kiekkopeli.setPaivitettava(new Paivitettava() {
            @Override
            public void paivita() {
                kiekkopeli.setJatkuu(false);
            }
        });
        ActionEvent e = new ActionEvent(kiekkopeli, 0, "peli");
        kiekkopeli.actionPerformed(e);
        assertFalse(kiekkopeli.jatkuu());
    }

}