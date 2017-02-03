package golfing.kiekko;

import java.util.HashMap;

public class Pelaaja {

    private String nimi;
    private HashMap<String, Kiekko> kiekot;
    private Sijainti sijainti;
    private int heitot;

    public Pelaaja(String nimi, int leveys, int korkeus) {
        this.nimi = nimi;
        this.kiekot = new HashMap<>();
        this.sijainti = new Sijainti(leveys / 2, korkeus - 1);
        this.heitot = 0;
    }

    public void lisaaKiekko() {
        kiekot.put("draiveri", new Kiekko(nimi, sijainti.getX(), sijainti.getY()));
    }

    public Kiekko getKiekko(String nimi) {
        return kiekot.get(nimi);
    }

    public void lisaaHeitto() {
        heitot++;
    }

    public int montakoHeittoa() {
        return heitot;
    }

    public String getNimi() {
        return nimi;
    }
    
    

}
