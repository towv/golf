/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golfing.peli;

import golfing.rata.Radat;
import golfing.rata.Rata;
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
public class TuloskorttiTest {
    
//    private Tuloskortti tulos;
//
//    private Kiekkopeli kiekkopeli;
//    private Rata rata;

    public TuloskorttiTest() {
//        this.kiekkopeli = new Kiekkopeli(20, 20);
//        this.rata = kiekkopeli.getRadat().getRadat().get("Kumpula");
    }

    @BeforeClass
    public static void setUpClass() {
        
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        this.tulos = new Tuloskortti(kiekkopeli, rata);
    }

    @After
    public void tearDown() {
    }
        
    @Test
    public void lisaaTulosVaylalle() {
        Radat radat = new Radat(20, 30);
        Rata rata = radat.getRadat().get("Kumpula");
        Kiekkopeli kiekkopeli = new Kiekkopeli(20, 30);
        Tuloskortti tulos = new Tuloskortti(kiekkopeli, rata);
        assertEquals(tulos.yhteisTulos().toString(), "0");
        tulos.lisaaTulosVaylalle(0, rata.getVayla(0).getPar(), kiekkopeli.getPelaaja());
        assertEquals(tulos.getTulokset().size(), 1);
        String tuloksetStringEka = tulos.getTuloksetString().get(1);
        assertEquals(tuloksetStringEka, "1. Par(2) -- Super-Pelaajan tulos: 0");
        assertEquals(tulos.getTulokset().get(0).toString(), "0");
        assertEquals(tulos.getTulosRata(), "Kumpulan frisbeegolfrata");
        assertEquals(tulos.ihanneTulos().toString(), "2");
        assertEquals(tulos.radanPituus().toString(), "6");
        kiekkopeli.getPelaaja().lisaaHeitto();
        tulos.lisaaTulosVaylalle(1, rata.getVayla(1).getPar(), kiekkopeli.getPelaaja());
        assertEquals(tulos.yhteisTulos().toString(), "1");
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
