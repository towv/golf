package golfing.peli;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import golfing.gui.Paivitettava;
import golfing.kiekko.Heitto;
import golfing.kiekko.Kiekko;
import golfing.kiekko.Kori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Kiekkopeli extends Timer implements ActionListener {

    private int leveys;
    private int korkeus;
    private boolean jatkuu;
    private Paivitettava paivitettava;
    private Kiekko kiekko;
    private Kori kori;
    private Heitto heitto;

    public Kiekkopeli(int leveys, int korkeus) {
        super(1000, null);

        this.leveys = leveys;
        this.korkeus = korkeus;
        this.jatkuu = true;
        this.kiekko = new Kiekko("nimi", leveys / 2, korkeus - 1);
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

        if (heitto.getTiiaus()) {
            kiekko.liiku();
            if (kiekko.getSijainti().osuu(kori)) {
                System.out.println("KORISSA");
                jatkuu = false;
            }
            heitto.vahennaVoimaa();

        }

        if (heitto.getVoima() == 0) {
            heitto.setTiiaus(false);
        }

        paivitettava.paivita();
        setDelay(500);

    }

}
