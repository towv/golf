package golfing.peli;

import golfing.kiekko.Pelaaja;
import golfing.rata.Rata;
import golfing.rata.Vayla;
import java.util.HashMap;

public class Tuloskortti {

    private Kiekkopeli kiekkopeli;
    private Rata rata;
    private HashMap<Integer, String> tuloksetString;
    private HashMap<Integer, Integer> tulokset;

    public Tuloskortti(Kiekkopeli kiekkopeli, Rata rata) {
        this.kiekkopeli = kiekkopeli;
        this.rata = rata;
        this.tuloksetString = new HashMap<>();
        this.tulokset = new HashMap<>();
    }

    public void lisaaTulosVaylalle(Integer vayla, Integer par, Pelaaja pelaaja) {
        tuloksetString.put(vayla + 1, vayla + 1 + ". " + "Par(" + par + ") -- "
                + pelaaja.getNimi() + "n tulos: " + pelaaja.montakoHeittoa());
        tulokset.put(vayla, pelaaja.montakoHeittoa());
    }

    public HashMap<Integer, String> getTuloksetString() {
        return tuloksetString;
    }

    public HashMap<Integer, Integer> getTulokset() {
        return tulokset;
    }

    public String getTulosRata() {
        return kiekkopeli.getRata();
    }
    
    public Integer yhteisTulos() {
        int summa = 0;
        for (Integer i : tulokset.values()) {
            summa += i;
        }
        return summa;
    }
    
    public Integer ihanneTulos() {
        int summa = 0;
        
        for (int i = 0; i < tulokset.size(); i++) {
            Vayla vayla = this.rata.getVayla(i);
            summa += vayla.getPar();
        }
        
        return summa;
    }
    
    public Integer radanPituus() {
        return rata.getVaylat().size();
    }

}
