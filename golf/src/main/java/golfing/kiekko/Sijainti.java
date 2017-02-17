package golfing.kiekko;

/**
 * Sijainti luokka on apuluokka. Pelaajalla, Korilla ja Kiekolla on kaikilla 
 * sijainnit. Kori tosin perii sijainnin, muilla on sijainti olio. Harkitsen perintää.
 * 
 * Sijainti on tärkeä, jotta kiekko voidaan löytää kartalta ja kaikki elementit 
 * piirtää oikeisiin paikkoihin.
 *
 */

public class Sijainti {

    private int x;
    private int y;

    /**
     * Sijanti-olion konstruktori.
     * @param x koordinaatti
     * @param y koordinaatti
     */
    public Sijainti(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * X koordinaatin haku. 
     * @return x koordinaatti
     */
    public int getX() {
        return x;
    }

    /**
     * Y koordinaatin haku.
     * @return y koordinaatti
     */
    public int getY() {
        return y;
    }

    /**
     * X koordinaatin asetus.
     * @param x asettaa x koordinaatin
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Y koordinaatin asetus.
     * @param y asettaa y koordinaatin
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Osuminen sijaintiin.
     * @param sijainti Sijainti johon osuminen tarkistetaan
     * @return true jos sijainti on sama kuin parametri, muuten false.
     */
    public boolean osuu(Sijainti sijainti) {
        return sijainti.getX() == getX() && sijainti.getY() == getY();
    }

    @Override
    public String toString() {
        return "" + this.x + this.y;
    }

}
