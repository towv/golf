package golfing;

import golfing.gui.Kayttoliittyma;
import golfing.kiekko.Pelaaja;
import golfing.peli.Kiekkopeli;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        int leveys = 20;
        int korkeus = 30;
        
        Scanner lukija = new Scanner(System.in);
        String nimi = "Super-Pelaaja";
        String rata = "Kumpula";
//        while (true) {
//            System.out.print("Anna nimesi: ");
//            nimi = lukija.nextLine();
//            System.out.println();
//            System.out.println("Ratavaihtoehdot tänään (Kumpula)");
//            System.out.print("Valitse rata: ");
//            rata = lukija.nextLine();
//            if (!nimi.isEmpty() && rata.equals("Kumpula")) {
//                break;
//            }
//        }
        
        Pelaaja pelaaja = new Pelaaja(nimi, leveys, korkeus);
        
        pelaaja.lisaaKiekko();

        Kiekkopeli kike = new Kiekkopeli(leveys, korkeus, pelaaja, rata);

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
