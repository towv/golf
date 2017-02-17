package golfing.kiekko;

import java.util.HashMap;

/**
 * Pelaaja luokka kuvastaa käyttäjää. Käyttäjällä on nimi, bägillinen kiekkoja, 
 * heitto ja sijainti kartalla. Pelaaja luokka pitää myös kirjaa käyttäjän 
 * suorittamien heittojen määrästä. Pelaajalla voi olla useita kiekkoja joten se pitää 
 * tietoa käytössä olevan kiekon väristä muistissa.
 *
 */

public class Pelaaja {

    private String nimi;
    private HashMap<String, Kiekko> kiekot;
    private Sijainti sijainti;
    private int heitot;
    private Heitto heitto;
    private Vari kaytossaOlevanKiekonVari;

    public Pelaaja(String nimi, int leveys, int korkeus) {
        this.nimi = nimi;
        this.kiekot = new HashMap<>();
        this.sijainti = new Sijainti(leveys / 2, korkeus - 3);
        this.heitot = 0;
        this.heitto = new Heitto(0);
    }

    public void lisaaKiekko() {
        kiekot.put("draiveri", new Kiekko("draiveri", sijainti.getX(), sijainti.getY()));
    }

    public Kiekko getKiekko(String nimi) {
        return kiekot.get(nimi);
    }

    public void lisaaHeitto() {
        heitot++;
    }

    public int montakoHeittoa() {
        return heitot;
    }
    
    public void nollaaHeitot() {
        heitot = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Heitto getHeitto() {
        return heitto;
    }

    public void setHeitto(Heitto heitto) {
        this.heitto = heitto;
    }

    public Vari getKaytossaOlevanKiekonVari() {
        kaytossaOlevanKiekonVari = getKiekko("draiveri").getVari();
        return kaytossaOlevanKiekonVari;
    }

    public Sijainti getSijainti() {
        return sijainti;
    }
}
