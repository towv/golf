package golfing.listeners;

import golfing.kiekko.Pelaaja;
import golfing.peli.Kiekkopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Tapahtumankuuntelija. Kuuntelee kirkonvaihtonappia.
 */
public class Kiekonvaihtonapinkuuntelija implements ActionListener {

    private Kiekkopeli kike;
    private JButton kiekonVaihtoNappi;

    /**
     * Kiekonvaihtokuuntelijan konstruktori. Parametrina kiekkopeli, jonka
     * kiekko vaihdetaan pelaajan nyt käytössä olevaan kiekkoon, sekä
     * kiekonvaihtonappi, jotta sen teksti voidaan päivittää vastaamaan kiekkoa.
     *
     * @param kike Kiekkopeli.
     * @param kiekonVaihtoNappi Nappi menussa.
     */
    public Kiekonvaihtonapinkuuntelija(Kiekkopeli kike, JButton kiekonVaihtoNappi) {
        this.kike = kike;
        this.kiekonVaihtoNappi = kiekonVaihtoNappi;
    }

    /**
     * Hoitaa kiekonvaihdon nappia painettaessa. Kiekonvaihto pitää sisällään
     * pelaajan kiekonvaihdon ja uuden kiekon kertomisen kiekkopelille. Myös
     * napin teksti päivitetään.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja = kike.getPelaaja();
        pelaaja.vaihdaKiekkoa();
        kike.setKiekko(pelaaja.getKaytossaOlevaKiekko());
        kiekonVaihtoNappi.setText("Vaihda kiekkoa, käytössä nyt: "
                + pelaaja.getKaytossaOlevaKiekko().getNimi() + " ("
                + pelaaja.getKaytossaOlevaKiekko().getNopeus() + ","
                + pelaaja.getKaytossaOlevaKiekko().getLiito() + ","
                + pelaaja.getKaytossaOlevaKiekko().getVakaus() + ","
                + pelaaja.getKaytossaOlevaKiekko().getLoppufeidi() + ")");
    }

}
