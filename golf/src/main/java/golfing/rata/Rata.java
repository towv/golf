
package golfing.rata;

import golfing.rata.Vayla;
import java.util.ArrayList;
import java.util.List;

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
}
