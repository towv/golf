package golfing.peli;

import golfing.gui.Paivitettava;
import golfing.kiekko.Heitto;
import golfing.kiekko.Kiekko;
import golfing.kiekko.Kori;
import golfing.kiekko.Pelaaja;
import golfing.kiekko.Suunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Kiekkopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;
    private Pelaaja pelaaja;
    private Kiekko kiekko;
    private Kori kori;
    private Heitto heitto;
    private boolean apukyrpa;

    public Kiekkopeli(int leveys, int korkeus, Pelaaja pelaaja) {
        super(1000, null);

        this.pelaaja = pelaaja;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.kiekko = this.pelaaja.getKiekko("draiveri");
        this.kori = new Kori(leveys / 2, 0);
        this.heitto = new Heitto(0, 0);

        addActionListener(this);
        setInitialDelay(1000);

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

    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!jatkuu) {
            return;
        }

        if (heitto.getVoima() == 1) {
            if (heitto.getVoima() == 0) {
                pelaaja.lisaaHeitto();
                System.out.println("Olet nyt heittänyt " + pelaaja.montakoHeittoa() + " kertaa.");
            }
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

            if (kiekko.getSijainti().osuu(kori)) {
                if (heitto.getVoima() > 3) {
                    System.out.println("Kiekko tippui korista");
                    System.out.println("Joudutaan heittämään vielä kerran..");
                    System.out.println();
                    pelaaja.lisaaHeitto();

                }
                System.out.println("KORISSA");
                System.out.println("Selvitit väylän " + pelaaja.montakoHeittoa() + " heitolla.");
                jatkuu = false;
            }
        }

        if (heitto.getVoima() == 0) {
            heitto.setKerroin(0);
            heitto.setTiiaus(false);
        }

        paivitettava.paivita();
        setDelay(500);

    }

}
