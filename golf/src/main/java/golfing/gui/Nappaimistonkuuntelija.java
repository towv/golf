package golfing.gui;

import golfing.kiekko.Heitto;
import golfing.kiekko.Pelaaja;
import golfing.kiekko.Suunta;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Kiekkopelisovelluksen näppäimistönkuuntelija.
 *
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Pelaaja pelaaja;
    private Heitto heitto;

    /**
     * Näppäimistönkuuntelin konstruktori.
     * @param pelaaja Pelaaja, joka pelaa Kiekkopeliä.
     */
    public Nappaimistonkuuntelija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.heitto = this.pelaaja.getHeitto();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.heitto = this.pelaaja.getHeitto();
        if (heitto == null) {
            this.pelaaja.setHeitto(new Heitto(1));
            this.heitto = this.pelaaja.getHeitto();
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            heitto.kasvataVoimaa();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            heitto.syotaSuunta(Suunta.WEST);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            heitto.syotaSuunta(Suunta.EAST);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            heitto.syotaSuunta(Suunta.NORTH);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            heitto.syotaSuunta(Suunta.SOUTH);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {           
            heitto.vahvistaHeitto();
            pelaaja.lisaaHeitto();
            heitto.setTiiaus(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
