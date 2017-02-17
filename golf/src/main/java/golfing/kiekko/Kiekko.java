package golfing.kiekko;

/**
 * Kiekko -luokka kuvastaa heitettävää kiekkoa. Kiekolla on erinäisiä ominaisuuksia,
 * tällä hetkellä tärkeimpänä sillä on Sijainti. Sillä on myös Väri.
 *
 */

public class Kiekko {
    
    private String nimi;
    private int liito;
    private int nopeus;
    private int loppufeidi;
    private Vari vari;
    private Sijainti sijainti;
    
    public Kiekko(String nimi) {
        this.nimi = nimi;
        this.liito = 5;
        this.nopeus = 5;
        this.loppufeidi = 0;
        this.vari = Vari.LIILA;
        this.sijainti = new Sijainti(10, 10);
    }
    
    public Kiekko(String nimi, int xalussa, int yalussa) {
        this.nimi = nimi;
        this.liito = 5;
        this.nopeus = 5;
        this.loppufeidi = 0;
        this.vari = Vari.LIILA;
        this.sijainti = new Sijainti(xalussa, yalussa);
    }

    public void setSijainti(Sijainti sijainti) {
        this.sijainti = sijainti;
    }
    
    public Sijainti getSijainti() {
        return sijainti;
    }
    
    public int getNopeus() {
        return nopeus;
    }
    
    public void setNopeus(int nopeus) {
        if (nopeus <= 0) {
            return;
        }
        this.nopeus = nopeus;
    }
    
    public int getLoppufeidi() {
        return loppufeidi;
    }
    
    public void setLoppufeidi(int loppufeidi) {
        this.loppufeidi = loppufeidi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public int getLiito() {
        return liito;
    }
    
    public void setNimi(String nimi) {
        if (nimi.isEmpty()) {
            return;
        }
        this.nimi = nimi;
    }

    public Vari getVari() {
        return vari;
    }
    
    /**
     * Hoitaa kiekon liikkeen.
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
