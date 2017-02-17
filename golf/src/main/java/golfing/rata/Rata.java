
package golfing.rata;

import golfing.rata.Vayla;
import java.util.ArrayList;
import java.util.List;

/**
 * Yksittäinen rata. Päästään käsiksi Radat kautta. TODO: Harkitse nimeämistä.
 * Radalla on nimi ja väyliä. Väylä tietää korinsa sijainnin.
 *
 */

public class Rata {
    private String nimi;
    private List<Vayla> vaylat;

    /**
     * Radan konstruktori.
     * @param nimi Radan nimi.
     */
    public Rata(String nimi) {
        this.nimi = nimi;
        this.vaylat = new ArrayList<>();
    }
    
    /**
     * Väylän lisäys.
     * @param vayla Rataan lisätään tämä väylä.
     */
    public void lisaaVayla(Vayla vayla) {
        vaylat.add(vayla);
    }

    /**
     * Radan nimi. 
     * @return radan nimi.
     */
    public String getNimi() {
        return nimi;
    }

    /**
     * Lista väylistä. 
     * @return lista.
     */
    public List<Vayla> getVaylat() {
        return vaylat;
    }
    
    /**
     * Tietyn väylän haku.
     * @param vaylanNumero Haetaan tämä väylä.
     * @return palautetaan haun mukainen väylä.
     */
    public Vayla getVayla(Integer vaylanNumero) {
        return this.vaylat.get(vaylanNumero);
    }
}
