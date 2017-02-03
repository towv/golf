package golfing.kiekko;

public class Heitto {

    private int voima;
    private int suunta;
    private boolean tiiaus;
    private int kerroin;

    public int getKerroin() {
        return kerroin;
    }

    public void setKerroin(int kerroin) {
        this.kerroin = kerroin;
    }

    public Heitto(int voima, int suunta) {
        this.voima = voima;
        this.suunta = suunta;
        this.tiiaus = false;
    }

    public int getVoima() {
        return voima;
    }

    public int getSuunta() {
        return suunta;
    }

    public void kasvataVoimaa() {
        voima++;
    }

    public void kasvataSuuntaa() {
        suunta++;
    }
    
    public void vahennaSuuntaa() {
        suunta--;
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
}
