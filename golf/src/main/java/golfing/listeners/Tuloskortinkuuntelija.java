package golfing.listeners;

import golfing.ui.Tuloskortinpiirtaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Tuloskortinkuuntelija. Kuuntelee tuloskortti välilehteä, ja painettaessa
 * lähettää päivityskäskyn piirtäjälle.
 */
public class Tuloskortinkuuntelija implements ActionListener {

    private Tuloskortinpiirtaja piirtaja;

    /**
     * Tuloskortinkuuntelijan konstruktori.
     * @param piirtaja Paneeli joka huolehtii tuloskortin ulkoasusta.
     */
    public Tuloskortinkuuntelija(Tuloskortinpiirtaja piirtaja) {
        this.piirtaja = piirtaja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        piirtaja.paivita();
    }

}
