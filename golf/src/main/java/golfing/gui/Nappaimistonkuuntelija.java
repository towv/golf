package golfing.gui;

import golfing.kiekko.Heitto;
import golfing.kiekko.Kiekko;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Nappaimistonkuuntelija implements KeyListener {

    private Heitto heitto;

    public Nappaimistonkuuntelija(Heitto heitto) {
        this.heitto = heitto;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            heitto.kasvataSuuntaa();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("kasvakasva");
            heitto.kasvataVoimaa();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            heitto.setTiiaus(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
