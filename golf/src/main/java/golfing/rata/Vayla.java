
package golfing.rata;

import golfing.kiekko.Kori;

/**
 * Väylä on luokka jolla on Kori olio.
 *
 */

public class Vayla {
    private Kori kori;

    public Vayla(Kori kori) {
        this.kori = kori;
    }

    public Kori getKori() {
        return kori;
    }    
}
