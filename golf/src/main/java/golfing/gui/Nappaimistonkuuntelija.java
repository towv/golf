package golfing.gui;

import golfing.kiekko.Heitto;
import golfing.kiekko.Pelaaja;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

public class Nappaimistonkuuntelija implements KeyListener {
    
    private Pelaaja pelaaja;
    private Heitto heitto;
    
    public Nappaimistonkuuntelija(Pelaaja pelaaja) {
        this.pelaaja = pelaaja;
        this.heitto = this.pelaaja.getHeitto();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (heitto.getVoima() == 0) {
            heitto.kasvataVoimaa();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            heitto.vahennaSuuntaa();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            heitto.kasvataSuuntaa();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            heitto.kasvataVoimaa();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                heitto.setKerroin(heitto.getVoima() / heitto.getSuunta());
            } catch (Exception nollajako) {
                heitto.setKerroin(1);
            }
            if (heitto.getKerroin() == 0) {
                heitto.setKerroin(1);
            }
            pelaaja.lisaaHeitto();
            heitto.setTiiaus(true);
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
