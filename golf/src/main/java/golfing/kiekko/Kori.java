package golfing.kiekko;

/**
 * Kori luokka perii Sijainnin. 
 * Siihen osuminen on ylikirjoitettu laajemmaksi alueeksi.
 *
 */

public class Kori extends Sijainti {

    /**
     * Korin konstruktori.
     * @param x koordinaatti
     * @param y koordinaatti
     */
    public Kori(int x, int y) {
        super(x, y);
    }
    
    /**
     * Palauttaa true jos kiekko menee koriin.
     * @param sijainti johon verrataan korin sijaintia.
     * @return boolean
     */

    @Override
    public boolean osuu(Sijainti sijainti) {
        if (sijainti.getX() == getX() && sijainti.getY() == getY()) {
            return true;
        }
        if (sijainti.getX() == getX() + 1 && sijainti.getY() == getY()) {
            return true;
        }
        if (sijainti.getX() == getX() && sijainti.getY() == getY() + 1) {
            return true;
        }
        if (sijainti.getX() == getX() + 1 && sijainti.getY() == getY() + 1) {
            return true;
        }
        return false;
    }

}
