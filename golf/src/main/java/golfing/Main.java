package golfing;

import golfing.gui.Kayttoliittyma;
import golfing.kiekko.Pelaaja;
import golfing.peli.Kiekkopeli;
import golfing.rata.Radat;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * Main-luokka. Luo Radat-olion, Pelaaja-olion ja Kiekkopeli-olion ja käynnistää
 * graafisen käyttöliittymän.
 *
 */
public class Main {

    public static void main(String[] args) {
        int leveys = 20;
        int korkeus = 30;

        Kiekkopeli kike = new Kiekkopeli(leveys, korkeus);

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
