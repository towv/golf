package golfing.peli;

import golfing.gui.Paivitettava;
import golfing.kiekko.Heitto;
import golfing.kiekko.Kiekko;
import golfing.kiekko.Kori;
import golfing.kiekko.Pelaaja;
import golfing.kiekko.Sijainti;
import golfing.kiekko.Suunta;
import golfing.rata.Radat;
import golfing.rata.Rata;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Kiekkopeli on itse peli luokka. Se on yhteydessä käyttäjälle näkyvään
 * ulkoasuun ja näppäimistönkuuntelijaan. Sillä on myös yhteys Ratoihin, jotta
 * se tietää missä kunkin väylän kori sijaitsee. Se tuntee pelaajan ja pelaajan
 * kautta heiton.
 *
 * Luokka on vastuussa kaikesta mitä pelissä tapahtuu ja käyttää muita luokkia
 * apunaan tässä tehtävässä.
 *
 */
public class Kiekkopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private boolean liianlujaa;
    private Paivitettava paivitettava;
    private Rata rata;
    private Pelaaja pelaaja;
    private Kiekko kiekko;
    private Kori kori;
    private Heitto heitto;
    private String tilanne;
    private String viesti;
    private Radat radat;
    private Integer vayla;
    private Tuloskortti tuloskortti;

    public Kiekkopeli(int leveys, int korkeus) {
        super(1000, null);

        this.radat = new Radat(leveys, korkeus);
        this.pelaaja = new Pelaaja("Super-Pelaaja", leveys, korkeus);
        this.pelaaja.lisaaKiekko();
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.liianlujaa = false;
        this.kiekko = this.pelaaja.getKiekko("draiveri");
        this.heitto = pelaaja.getHeitto();
        this.vayla = 0;

        this.rata = radat.getRadat().get("Kumpula");
        this.tuloskortti = new Tuloskortti(this, this.rata);
        this.kori = this.rata.getVaylat().get(0).getKori();

        addActionListener(this);
        setInitialDelay(1000);

    }

    public Tuloskortti getTuloskortti() {
        return tuloskortti;
    }

    /**
     * Palauttaa radan nimen
     *
     * @return Radan nimi
     */
    public String getRata() {
        return this.rata.getNimi();
    }

    public Radat getRadat() {
        return radat;
    }

    /**
     * Palauttaa pelaajan
     *
     * @return Pelaaja-olio
     */
    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
    }

    public void setRata(String rata) {
        this.rata = this.radat.getRadat().get(rata);
        this.kori = this.rata.getVaylat().get(0).getKori();
        this.tuloskortti = new Tuloskortti(this, this.rata);
    }

    public void vaihdaVaylaa() {
        this.vayla++;
        if (this.vayla == this.rata.getVaylat().size()) {
            this.vayla = 0;
        }
        this.kori = this.rata.getVaylat().get(this.vayla).getKori();
        this.jatkuu = true;
        this.kiekko.setSijainti(new Sijainti(leveys / 2, korkeus - 3));
        this.pelaaja.nollaaHeitot();
    }

    /**
     * Palauttaa heiton
     *
     * @return Heitto-olio
     */
    public Heitto getHeitto() {
        return heitto;
    }

    /**
     * Palauttaa kiekon joka on käytössä
     *
     * @return Kiekko -olio
     */
    public Kiekko getKiekko() {
        return kiekko;
    }

    /**
     * Asettaa käytettävän kiekon
     *
     */
    public void setKiekko(Kiekko kiekko) {
        this.kiekko = kiekko;
    }

    /**
     * Palauttaa pelattavan korin
     *
     * @return kori-olio
     */
    public Kori getKori() {
        return kori;
    }

    /**
     * Asettaa korin pelattavaksi
     */
    public void setKori(Kori kori) {
        this.kori = kori;
    }

    /**
     * Kertoo pelin, tilanteen, kun jatkuu = false ei enää heitetä
     *
     * @return boolean jatkuu
     */
    public boolean jatkuu() {
        return jatkuu;
    }

    /**
     * Asettaa boolean jatkuu
     *
     */
    public void setJatkuu(boolean jatkuu) {
        this.jatkuu = jatkuu;
    }

    /**
     * Jos kiekko osuu koriin liian lujaa tulee boolean-liianlujaa arvoksi true
     */
    public void setLiianlujaa(boolean liianlujaa) {
        this.liianlujaa = liianlujaa;
    }

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    /**
     * Palauttaa merkkijonona sen hetkisen käytettyjen heittojen määrän
     *
     * @return String "Heittoja: 'kokonaisluku'"
     */
    public String getTilanne() {
        int vaylanNumero = this.vayla + 1;
        return "Väylä:" + vaylanNumero
                + " | Par: " + this.rata.getVayla(this.vayla).getPar()
                + " | Heittoja: " + pelaaja.montakoHeittoa();
    }

    /**
     * Palauttaa viestin. Alussa viesti on tervehdys pelaajalle. Jos kiekko osuu
     * liian suurella voimalla koriin viestitetään tästä. Lopuksi viestitetään
     * kiekon olevan korissa ja heittojenmäärä joka kului.
     */
    public String getViesti() {
        if (this.pelaaja.montakoHeittoa() == 0) {
            return "Tervehdys " + pelaaja.getNimi() + "! (:\nVaro puuta!";
        } else if (!jatkuu && !liianlujaa) {
            return "KORISSA! \nSelvitit väylän " + pelaaja.montakoHeittoa() + " heitolla.";
        } else if (!jatkuu && liianlujaa) {
            return "Kiekko tippui korista! \nJoudutaan heittämään vielä kerran...";
        } else {
            return " \n ";
        }
    }

    /**
     * Muuttaa pelin tilannetta. Käskee myös paivitettavaa päivittämään tilanne
     * ruudulle. Jos heitto on lähetetty kulkee se niin kauan kuin sillä on
     * voimaa, tai kunnes se osuu korii. Koriin osuessa tarkistetaan jäljellä
     * oleva voima. Kiekon suunta riippuu annetusta suuntavoimasta.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jatkuu && !liianlujaa) {
            this.tuloskortti.lisaaTulosVaylalle(this.vayla, this.rata.getVayla(this.vayla).getPar(), this.pelaaja);
            return;
        }

        if (!jatkuu) {
            try {
                Thread.sleep(2000);
            } catch (Exception b) {
            }

            this.liianlujaa = false;
        }

        if (pelaaja.getHeitto() == null) {
            return;
        } else {
            heitto = pelaaja.getHeitto();
        }

        if (heitto.getTiiaus()) {

            kiekko.liiku(heitto.getSuunta());
            heitto.vahennaVoimaa();

            if (kori.osuu(kiekko.getSijainti())) {

                if (heitto.getVoima() > 3) {
                    pelaaja.lisaaHeitto();
                    heitto.setVoima(1);
                    this.liianlujaa = true;
                }

                jatkuu = false;
            }
        }

        if (heitto.getVoima() == 0) {
            this.pelaaja.setHeitto(null);
            this.heitto = null;
        }

        paivitettava.paivita();
        setDelay(300);

    }

}
