package golfing.kiekko;

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
        this.vari = vari.LIILA;
        this.sijainti = new Sijainti(10, 10);
    }
    
    public Kiekko(String nimi, int xalussa, int yalussa) {
        this.nimi = nimi;
        this.liito = 5;
        this.nopeus = 5;
        this.loppufeidi = 0;
        this.vari = vari.LIILA;
        this.sijainti = new Sijainti(xalussa, yalussa);
    }
    
    public Sijainti getSijainti() {
        return sijainti;
    }
    
    public int getNopeus() {
        return nopeus;
    }
    
    public void setNopeus(int nopeus) {
        if (nopeus < 0) {
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
    
    public void liiku(Suunta suunta) {
        if (suunta == suunta.YLOS) {
            this.sijainti.setY(this.sijainti.getY() - 1);
        } else if (suunta == suunta.VASEN) {
            this.sijainti.setX(this.sijainti.getX() - 1);
        } else if (suunta == suunta.OIKEA) {
            this.sijainti.setX(this.sijainti.getX() + 1);
        }
        
    }
    
}
