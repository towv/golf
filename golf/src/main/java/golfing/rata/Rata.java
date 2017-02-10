
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

    public Rata(String nimi) {
        this.nimi = nimi;
        this.vaylat = new ArrayList<>();
    }
    
    public void lisaaVayla(Vayla vayla) {
        vaylat.add(vayla);
    }

    public String getNimi() {
        return nimi;
    }

    public List<Vayla> getVaylat() {
        return vaylat;
    }
}
