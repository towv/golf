
package golfing.rata;

import golfing.kiekko.Kori;

/**
 * Väylä on luokka jolla on Kori olio.
 *
 */

public class Vayla {
    private Kori kori;
    private int par;

    /**
     * Vaylan konstruktori.
     * @param kori Väylän kori.
     * @param par Väylän ihannetulos. 
     * (heittojen määrä, joilla pitäisi saada kiekko koriin).
     */
    public Vayla(Kori kori, Integer par) {
        this.kori = kori;
        this.par = par;
    }

    /**
     * Vaylan kori.
     * @return Palauttaa väylän korin.
     */
    public Kori getKori() {
        return kori;
    }

    /**
     * Vaylan par.
     * @return Palauttaa ihannetuloksen.
     */
    public int getPar() {
        return par;
    }
}
