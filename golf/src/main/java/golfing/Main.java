package golfing;

import golfing.gui.Kayttoliittyma;
import golfing.peli.Kiekkopeli;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        Kiekkopeli kike = new Kiekkopeli(20, 20);

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
