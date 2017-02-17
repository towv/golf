package golfing.kiekko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Tämä luokka pitää kirjaa heitosta, sen voimakkuudesta ja siitä milloin
 * heitetään.
 *
 */
public class Heitto {

    private int voima;
    private Suunta suunta;
    private List<Suunta> syotetytSuunnat;
    private boolean tiiaus;

    public Heitto(int voima) {
        this.voima = voima;
        this.suunta = null;
        this.syotetytSuunnat = new ArrayList();
        this.tiiaus = false;
    }

    public void syotaSuunta(Suunta suunta) {
        if (syotetytSuunnat.size() < 2) {
            syotetytSuunnat.add(suunta);
        }
    }

    public void vahvistaHeitto() {
        if (syotetytSuunnat.size() == 0) {
            arvoHeitonSuunta();
            
        } else if (syotetytSuunnat.size() == 1) {
            // Syötetty vain yksi suunta
            // Pelaaja epävarma, heiton voima puolittuu
            this.suunta = syotetytSuunnat.get(0);
            puolitaHeitonVoima();
        } else {
            // Syötetty vähintään kaksi suuntaa
            // Vain kaksi ensimmäistä huomioidaan
            Suunta first = syotetytSuunnat.get(0);
            Suunta second = syotetytSuunnat.get(1);
            
            kelpoSyoteAsetetaValittuSuunta(first, second);

            if (this.suunta == null) {
                // Suunta siis WEST ja EAST tai NORTH ja SOUTH
                // Pelaaja epävarma, heiton voima puolittuu
                this.suunta = first;
                puolitaHeitonVoima();
            }
        }
    }

    private void kelpoSyoteAsetetaValittuSuunta(Suunta first, Suunta second) {
        if (first == second) {
            this.suunta = first;
        } else {
            if ((first == Suunta.NORTH && second == Suunta.EAST)
                    || first == Suunta.EAST && second == Suunta.NORTH) {
                this.suunta = Suunta.NORTHEAST;
            } else if ((first == Suunta.NORTH && second == Suunta.WEST)
                    || (first == Suunta.WEST && second == Suunta.NORTH)) {
                this.suunta = Suunta.NORTHWEST;
            } else if ((first == Suunta.SOUTH && second == Suunta.EAST)
                    || first == Suunta.EAST && second == Suunta.SOUTH) {
                this.suunta = Suunta.SOUTHEAST;
            } else if ((first == Suunta.SOUTH && second == Suunta.WEST)
                    || (first == Suunta.WEST && second == Suunta.SOUTH)) {
                this.suunta = Suunta.SOUTHWEST;
            }
        }
    }

    private void arvoHeitonSuunta() {
        // Pelaaja ei osannut päättää mihin suuntaan heittää!
        // Valitaan suunta sattumanvaraisesti ja puolitetaan voima
        Random arpoja = new Random();
        ArrayList<Suunta> vaihtoehdot = new ArrayList<>();
        lisaaKaikkiSuunnatListalle(vaihtoehdot);
        this.suunta = vaihtoehdot.get(arpoja.nextInt(8));
        puolitaHeitonVoima();
    }

    private void lisaaKaikkiSuunnatListalle(ArrayList<Suunta> vaihtoehdot) {
        vaihtoehdot.add(Suunta.EAST);
        vaihtoehdot.add(Suunta.NORTH);
        vaihtoehdot.add(Suunta.NORTHEAST);
        vaihtoehdot.add(Suunta.NORTHWEST);
        vaihtoehdot.add(Suunta.SOUTH);
        vaihtoehdot.add(Suunta.SOUTHEAST);
        vaihtoehdot.add(Suunta.SOUTHWEST);
        vaihtoehdot.add(Suunta.WEST);
    }

    public void puolitaHeitonVoima() {
        this.voima = this.voima / 2;
    }

    public void setVoima(int voima) {
        this.voima = voima;
    }

    public int getVoima() {
        return voima;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void kasvataVoimaa() {
        voima++;
    }

    public void vahennaVoimaa() {
        if (voima > 0) {
            voima--;
        }
    }

    public void setTiiaus(boolean b) {
        tiiaus = b;
    }

    public boolean getTiiaus() {
        return tiiaus;
    }

    @Override
    public String toString() {
        return "" + voima + suunta + tiiaus;
    }

}
