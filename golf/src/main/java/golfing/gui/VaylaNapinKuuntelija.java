package golfing.gui;

import golfing.peli.Kiekkopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaylaNapinKuuntelija implements ActionListener {

    private Kiekkopeli kike;

    public VaylaNapinKuuntelija(Kiekkopeli kike) {
        this.kike = kike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kike.vaihdaVaylaa();
    }

}
