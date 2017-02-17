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

    /**
     * Pelaajan konstruktori.
     * @param nimi Käyttäjän nimimerkki.
     * @param leveys Kiekkopelin leveys pelaajan kartalle asetusta varten.
     * @param korkeus Kiekkopelin korkeus pelaajan kartalle asetusta varten.
     */
    public Pelaaja(String nimi, int leveys, int korkeus) {
        this.nimi = nimi;
        this.kiekot = new HashMap<>();
        this.sijainti = new Sijainti(leveys / 2, korkeus - 3);
        this.heitot = 0;
        this.heitto = new Heitto(0);
    }

    /**
     * Lisää kiekon pelaajan bägiin.
     */
    public void lisaaKiekko() {
        kiekot.put("draiveri", new Kiekko("draiveri", sijainti.getX(), sijainti.getY()));
    }

    /**
     * Kiekon haku.
     * @param nimi Haetaan bägistä tämän nimistä kiekkoa
     * @return palauttaa kyseisen kiekon.
     */
    public Kiekko getKiekko(String nimi) {
        return kiekot.get(nimi);
    }

    /**
     * Kasvattaa käytettyjä heittoja yhdellä.
     */
    public void lisaaHeitto() {
        heitot++;
    }

    /**
     * Heittojen määrän haku.
     * @return palauttaa montako heittoa pelaaja on heittänyt.
     */
    public int montakoHeittoa() {
        return heitot;
    }
    
    /**
     * Nollaa heitot. Käytetään uuden väylän alkaessa.
     */
    public void nollaaHeitot() {
        heitot = 0;
    }

    /**
     * Pelaajan nimen haku.
     * @return Pelaajan nimi.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Nimen asetus pelaajalle.
     * @param nimi Asettaa nimen pelaajalle.
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * Heiton haku.
     * @return Palauttaa pelaajan Heitto-olion.
     */
    public Heitto getHeitto() {
        return heitto;
    }

    /**
     * Heiton asetus.
     * @param heitto Asettaa pelaajan heitto-olioksi parametrin mukaisen
     * heitto olion.
     */
    public void setHeitto(Heitto heitto) {
        this.heitto = heitto;
    }

    /**
     * Käytettävän kiekon väri.
     * @return palauttaa käytössä olevan kiekon värin.
     */
    public Vari getKaytossaOlevanKiekonVari() {
        kaytossaOlevanKiekonVari = getKiekko("draiveri").getVari();
        return kaytossaOlevanKiekonVari;
    }

    /**
     * Pelaajan sijainti.
     * @return palauttaa pelaajan sijainnin kartalla.
     */
    public Sijainti getSijainti() {
        return sijainti;
    }
}
