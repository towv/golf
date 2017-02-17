package golfing.kiekko;

/**
 * Kiekko -luokka kuvastaa heitettävää kiekkoa. Kiekolla on erinäisiä
 * ominaisuuksia, tällä hetkellä tärkeimpänä sillä on Sijainti. Sillä on myös
 * Väri.
 *
 */
public class Kiekko {

    private String nimi;
    private int liito;
    private int nopeus;
    private int loppufeidi;
    private Vari vari;
    private Sijainti sijainti;

    /**
     * Kiekon konstruktori. Ei sijaintia.
     *
     * @param nimi Kiekon nimi. Kiekon identifioimista varten.
     */
    public Kiekko(String nimi) {
        this.nimi = nimi;
        this.liito = 5;
        this.nopeus = 5;
        this.loppufeidi = 0;
        this.vari = Vari.LIILA;
        this.sijainti = new Sijainti(10, 10);
    }

    /**
     * Kiekon konstruktori, sijainti parametreilla.
     *
     * @param nimi Kiekon nimi. Kiekon identifioimista varten.
     * @param xalussa Kiekolle alussa asetettava x koordinaatti.
     * @param yalussa Kiekolle alussa asetettava y koordinaatti.
     */
    public Kiekko(String nimi, int xalussa, int yalussa) {
        this.nimi = nimi;
        this.liito = 5;
        this.nopeus = 5;
        this.loppufeidi = 0;
        this.vari = Vari.LIILA;
        this.sijainti = new Sijainti(xalussa, yalussa);
    }

    /**
     * Sijainnin asetus.
     *
     * @param sijainti Asettaa kiekon parametrin mukaiseen sijaintiin.
     */
    public void setSijainti(Sijainti sijainti) {
        this.sijainti = sijainti;
    }

    /**
     * Sijainnin palautus.
     *
     * @return Palauttaa kiekon sijainnin.
     */
    public Sijainti getSijainti() {
        return sijainti;
    }

    /**
     * Nopeuden palautus.
     *
     * @return Nopeus.
     */
    public int getNopeus() {
        return nopeus;
    }

    /**
     * Nopeuden asetus.
     *
     * @param nopeus Nopeus joka asetetaan.
     */
    public void setNopeus(int nopeus) {
        if (nopeus <= 0) {
            return;
        }
        this.nopeus = nopeus;
    }

    /**
     * Loppufeidin haku.
     *
     * @return loppufeidi Kiekon loppufeidi.
     */
    public int getLoppufeidi() {
        return loppufeidi;
    }

    /**
     * Loppufeidin asetus.
     *
     * @param loppufeidi Asetettava feidi.
     */
    public void setLoppufeidi(int loppufeidi) {
        this.loppufeidi = loppufeidi;
    }

    /**
     * Nimen haku.
     *
     * @return nimi Kiekon nimi.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Liidon haku.
     *
     * @return liito Kiekon liito.
     */
    public int getLiito() {
        return liito;
    }

    /**
     * Nimen asetus.
     *
     * @param nimi Kiekolle asetettava nimi.
     */
    public void setNimi(String nimi) {
        if (nimi.isEmpty()) {
            return;
        }
        this.nimi = nimi;
    }

    /**
     * Värin haku.
     *
     * @return vari Kiekon väri.
     */
    public Vari getVari() {
        return vari;
    }

    /**
     * Hoitaa kiekon liikkeen. Suunnan mukaisesti.
     *
     * @param suunta Suunta johon liikutetaan.
     */
    public void liiku(Suunta suunta) {
        if (suunta == Suunta.NORTH) {
            this.sijainti.setY(this.sijainti.getY() - 1);
        } else if (suunta == Suunta.EAST) {
            this.sijainti.setX(this.sijainti.getX() + 1);
        } else if (suunta == Suunta.WEST) {
            this.sijainti.setX(this.sijainti.getX() - 1);
        } else if (suunta == Suunta.SOUTH) {
            this.sijainti.setY(this.sijainti.getY() + 1);
        } else if (suunta == Suunta.NORTHEAST) {
            this.sijainti.setY(this.sijainti.getY() - 1);
            this.sijainti.setX(this.sijainti.getX() + 1);
        } else if (suunta == Suunta.NORTHWEST) {
            this.sijainti.setY(this.sijainti.getY() - 1);
            this.sijainti.setX(this.sijainti.getX() - 1);
        } else if (suunta == Suunta.SOUTHEAST) {
            this.sijainti.setY(this.sijainti.getY() + 1);
            this.sijainti.setX(this.sijainti.getX() + 1);
        } else if (suunta == Suunta.SOUTHWEST) {
            this.sijainti.setY(this.sijainti.getY() + 1);
            this.sijainti.setX(this.sijainti.getX() - 1);
        }

    }

}
