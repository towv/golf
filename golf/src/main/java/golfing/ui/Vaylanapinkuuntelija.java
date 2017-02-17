package golfing.ui;

import golfing.peli.Kiekkopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Vayla -nappia kuunteleva luokka. Antaa Kiekkopelille käskyn vaihtaa väylää. 
 */
public class Vaylanapinkuuntelija implements ActionListener {

    private Kiekkopeli kike;

    /**
     * Vaylanapinkuuntelija. Konstruktori.
     * @param kike Peli jota pelataan.
     */
    public Vaylanapinkuuntelija(Kiekkopeli kike) {
        this.kike = kike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kike.vaihdaVaylaa();
    }

}
