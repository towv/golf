package golfing.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Tuloskortinkuuntelija. Kuuntelee tuloskortti välilehteä, ja painettaessa
 * lähettää päivityskäskyn piirtäjälle.
 */
public class TuloskortinKuuntelija implements ActionListener {

    private TuloskortinPiirtaja piirtaja;

    /**
     * Tuloskortinkuuntelijan konstruktori.
     * @param piirtaja Paneeli joka huolehtii tuloskortin ulkoasusta.
     */
    public TuloskortinKuuntelija(TuloskortinPiirtaja piirtaja) {
        this.piirtaja = piirtaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        piirtaja.paivita();
    }

}
