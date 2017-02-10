package golfing.peli;

import golfing.gui.Paivitettava;
import golfing.kiekko.Heitto;
import golfing.kiekko.Kiekko;
import golfing.kiekko.Kori;
import golfing.kiekko.Pelaaja;
import golfing.kiekko.Suunta;
import golfing.rata.Radat;
import golfing.rata.Rata;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * Kiekkopeli on itse peli luokka. Se on yhteydessä käyttäjälle näkyvään ulkoasuun 
 * ja näppäimistönkuuntelijaan. Sillä on myös yhteys Ratoihin, jotta se tietää missä
 * kunkin väylän kori sijaitsee. Se tuntee pelaajan ja heiton.
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

    public Kiekkopeli(int leveys, int korkeus, Pelaaja pelaaja, String rata, Radat radat) {
        super(1000, null);

        this.pelaaja = pelaaja;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.liianlujaa = false;
        this.kiekko = this.pelaaja.getKiekko("draiveri");
        this.heitto = pelaaja.getHeitto();

        this.rata = radat.getRadat().get(rata);
        this.kori = this.rata.getVaylat().get(4).getKori();

        addActionListener(this);
        setInitialDelay(1000);

    }

    public String getRata() {
        return this.rata.getNimi();
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public Heitto getHeitto() {
        return heitto;
    }

    public Kiekko getKiekko() {
        return kiekko;
    }

    public void setKiekko(Kiekko kiekko) {
        this.kiekko = kiekko;
    }

    public Kori getKori() {
        return kori;
    }

    public void setKori(Kori kori) {
        this.kori = kori;
    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void setJatkuu(boolean jatkuu) {
        this.jatkuu = jatkuu;
    }

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

    public String getTilanne() {
        return "Heittoja: " + pelaaja.montakoHeittoa();
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!jatkuu && !liianlujaa) {
            return;
        }

        if (!jatkuu) {
            try {
                Thread.sleep(2000);
            } catch (Exception b) {
            }

            this.liianlujaa = false;
        }

        if (heitto.getTiiaus()) {

//            if (heitto.getSuunta() != 0) {
            if (heitto.getVoima() % heitto.getKerroin() == 0) {
                if (heitto.getSuunta() < 0) {
                    kiekko.liiku(Suunta.VASEN);
                    heitto.kasvataSuuntaa();
                } else if (heitto.getSuunta() > 0) {
                    kiekko.liiku(Suunta.OIKEA);
                    heitto.vahennaSuuntaa();
                }
            }
//            }

            kiekko.liiku(Suunta.YLOS);
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
            heitto.setKerroin(0);
            heitto.setTiiaus(false);
        }

        paivitettava.paivita();
        setDelay(300);

    }

}
