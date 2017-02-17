
package golfing.rata;

import golfing.kiekko.Kori;

/**
 * Väylä on luokka jolla on Kori olio.
 *
 */

public class Vayla {
    private Kori kori;
    private int par;

    public Vayla(Kori kori, Integer par) {
        this.kori = kori;
        this.par = par;
    }

    public Kori getKori() {
        return kori;
    }

    public int getPar() {
        return par;
    }
}
