package golfing.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TuloskortinKuuntelija implements ActionListener {

    private TuloskortinPiirtaja piirtaja;

    public TuloskortinKuuntelija(TuloskortinPiirtaja piirtaja) {
        this.piirtaja = piirtaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        piirtaja.paivita();
    }

}
