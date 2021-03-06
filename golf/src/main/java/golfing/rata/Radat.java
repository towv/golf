package golfing.rata;

import golfing.kiekko.Kori;
import java.util.HashMap;

/**
 * Kiekkopelisovelluksen ratavalikoima. Tämä luokka on vastuussa eri ratojen
 * säilytyksestä. Radat on kovakoodattu luokkaan.
 *
 */
public class Radat {

    private HashMap<String, Rata> radat;
    private int leveys;
    private int korkeus;

    /**
     * Radat valikoiman konstruktori.
     *
     * @param leveys Kiekkopelin leveys
     * @param korkeus Kiekkopelin korkeus Tässä luodaan yksittäisiä ratoja,
     * jotka sitten kuuluvat ratavalikoimaan. Luotuna 6 väyläinen Kumpula.
     */
    public Radat(int leveys, int korkeus) {
        if (leveys <= 0 || korkeus <= 0) {
            throw new IllegalArgumentException("Sekä leveyden, että korkeuden on oltava suurempi kuin nolla!");
        }
        this.radat = new HashMap<>();

        Rata kumpula = new Rata("Kumpulan frisbeegolfrata");
        kumpula.lisaaVayla(new Vayla(new Kori(leveys / 2, 4), 2));
        kumpula.lisaaVayla(new Vayla(new Kori(leveys / 2, korkeus / 2), 1));
        kumpula.lisaaVayla(new Vayla(new Kori(leveys / 3, 1), 3));
        kumpula.lisaaVayla(new Vayla(new Kori((leveys / 4) * 3, 2), 3));
        kumpula.lisaaVayla(new Vayla(new Kori(leveys / 8, 2), 3));
        kumpula.lisaaVayla(new Vayla(new Kori((leveys / 4) * 3, korkeus / 2), 2));
        radat.put("Kumpula", kumpula);

        Rata pasila = new Rata("Pasilan frisbeegolfrata");
        pasila.lisaaVayla(new Vayla(new Kori(leveys / 20, korkeus * 5 / 6), 1));
        pasila.lisaaVayla(new Vayla(new Kori(leveys / 13, korkeus * 11 / 20), 2));
        pasila.lisaaVayla(new Vayla(new Kori(9 * leveys / 10, korkeus / 4), 2));
        radat.put("Pasila", pasila);
    }

    /**
     * Ratavalikoima.
     *
     * @return Palauttaa ratavalikoiman.
     */
    public HashMap<String, Rata> getRadat() {
        return radat;
    }
}
