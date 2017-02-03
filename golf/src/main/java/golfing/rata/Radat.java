
package golfing.rata;

import golfing.kiekko.Kori;
import java.util.HashMap;

public class Radat {
    private HashMap<String, Rata> radat;

    public Radat() {
        this.radat = new HashMap<>();
        Rata kumpula = radat.get("Kumpula");
        kumpula.lisaaVayla(new Vayla(new Kori(10, 1)));
        kumpula.lisaaVayla(new Vayla(new Kori(6, 2)));
        radat.put("Kumpula", kumpula);
    }
}
