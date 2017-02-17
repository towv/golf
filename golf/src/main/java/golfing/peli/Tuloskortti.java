package golfing.peli;

import golfing.kiekko.Pelaaja;
import golfing.rata.Rata;
import golfing.rata.Vayla;
import java.util.HashMap;

/**
 *
 * Tuloskortti. Pitää kirjaa pelaajan tuloksesta.
 */
public class Tuloskortti {

    private Kiekkopeli kiekkopeli;
    private Rata rata;
    private HashMap<Integer, String> tuloksetString;
    private HashMap<Integer, Integer> tulokset;

    /**
     * Tuloskortin konstruktori.
     * @param kiekkopeli jota pelataan
     * @param rata jolla pelataan
     */
    public Tuloskortti(Kiekkopeli kiekkopeli, Rata rata) {
        this.kiekkopeli = kiekkopeli;
        this.rata = rata;
        this.tuloksetString = new HashMap<>();
        this.tulokset = new HashMap<>();
    }

    /**
     * Väylälle tuloksen lisääminen.
     * @param vayla Vaylan numero
     * @param par Vaylan par eli ihannetulos
     * @param pelaaja Pelaaja, joka pelaa kiekkopeliä
     */
    public void lisaaTulosVaylalle(Integer vayla, Integer par, Pelaaja pelaaja) {
        tuloksetString.put(vayla + 1, vayla + 1 + ". " + "Par(" + par + ") -- "
                + pelaaja.getNimi() + "n tulos: " + pelaaja.montakoHeittoa());
        tulokset.put(vayla, pelaaja.montakoHeittoa());
    }

    /**
     * Tulokset String muodossa väylä kohtaisesti.
     * @return HashMap, jossa avaimena väylät, ja arvona String joka pitää
     * sisällään väylän tiedot ja pelaajan tuloksen väylällä
     */
    public HashMap<Integer, String> getTuloksetString() {
        return tuloksetString;
    }

    /**
     * Tulokset mappina.
     * @return Tulokset, avain = väylän numero, arvo = pelaajan tulos
     */
    public HashMap<Integer, Integer> getTulokset() {
        return tulokset;
    }

    /**
     * Pelattavan radan nimi.
     * @return radan nimi jota pelataan.
     */
    public String getTulosRata() {
        return kiekkopeli.getRata();
    }
    
    /**
     * Pelaajan heitot.
     * @return Pelaajan heittämät heitot yhteensä.
     */
    public Integer yhteisTulos() {
        int summa = 0;
        for (Integer i : tulokset.values()) {
            summa += i;
        }
        return summa;
    }
    
    /**
     * Väylän parit pelatuilla väylillä yhteensä.
     * @return Väylien, jotka on pelattu, par eli ihannetulokset yhteensä.
     */
    public Integer ihanneTulos() {
        int summa = 0;
        
        for (int i = 0; i < tulokset.size(); i++) {
            Vayla vayla = this.rata.getVayla(i);
            summa += vayla.getPar();
        }
        
        return summa;
    }
    
    /**
     * Radalla väyliä.
     * @return Radan väylien määrä.
     */
    public Integer radanPituus() {
        return rata.getVaylat().size();
    }

}
