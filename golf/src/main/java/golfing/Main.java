package golfing;

import golfing.gui.Kayttoliittyma;
import golfing.kiekko.Pelaaja;
import golfing.peli.Kiekkopeli;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        int leveys = 20;
        int korkeus = 20;
        
        Pelaaja pelaaja = new Pelaaja("Super-Pelaaja", leveys, korkeus);
        
        pelaaja.lisaaKiekko();

        Kiekkopeli kike = new Kiekkopeli(leveys, korkeus, pelaaja);

        Kayttoliittyma kali = new Kayttoliittyma(kike, 20);
        SwingUtilities.invokeLater(kali);

        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println("Piirtoalustaa ei ole vielä luotu");
            }
        }

        kike.setPaivitettava(kali.getPaivitettava());
        kike.start();

    }

}
