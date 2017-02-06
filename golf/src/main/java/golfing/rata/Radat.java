
package golfing.rata;

import golfing.kiekko.Kori;
import java.util.HashMap;

public class Radat {
    private HashMap<String, Rata> radat;
    private int leveys;
    private int korkeus;

    public Radat(int leveys, int korkeus) {
        this.radat = new HashMap<>();
        
        Rata kumpula = new Rata("Kumpulan frisbeegolfrata");
        kumpula.lisaaVayla(new Vayla(new Kori(leveys/2, 0)));
        kumpula.lisaaVayla(new Vayla(new Kori(leveys/2, korkeus/leveys)));
        kumpula.lisaaVayla(new Vayla(new Kori(leveys/3, 1)));
        kumpula.lisaaVayla(new Vayla(new Kori((leveys/4) * 3, 2)));
        kumpula.lisaaVayla(new Vayla(new Kori((leveys/8) * 1, 2)));
        kumpula.lisaaVayla(new Vayla(new Kori((leveys/4) * 3, korkeus/2)));
        radat.put("Kumpula", kumpula);
    }

    public HashMap<String, Rata> getRadat() {
        return radat;
    }
}
