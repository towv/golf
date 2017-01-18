
package golfing.kiekko;

public class Kiekko {
    private String nimi;
    private int liito;

    public Kiekko(String nimi) {
        this.nimi = nimi;
        this.liito = 5;
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
    
}
