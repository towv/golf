package golfing;

import golfing.gui.Kayttoliittyma;
import golfing.kiekko.Pelaaja;
import golfing.peli.Kiekkopeli;
import golfing.rata.Radat;
import java.util.Scanner;
import javax.swing.SwingUtilities;

/**
 * Main-luokka. Luo Radat-olion, Pelaaja-olion ja Kiekkopeli-olion ja käynnistää graafisen
 * käyttöliittymän.
 * 
 */

public class Main {

    public static void main(String[] args) {
        int leveys = 20;
        int korkeus = 30;

        Scanner lukija = new Scanner(System.in);
        String nimi = "Super-Pelaaja";
        String rata = "Kumpula";

        Radat radat = new Radat(leveys, korkeus);
        
// TODO: Seuraava pätkä liittyy suunniteltuun valikkoon, ei ehdi tälle viikolle
//
//        while (true) {
//            System.out.print("Anna nimesi: ");
//            nimi = lukija.nextLine();
//            System.out.println();
//
//            if (nimi.isEmpty()) {
//                System.out.println("Nimeä ei voi jättää tyhjäksi!");
//                continue;
//            } else {
//                break;
//            }
//        }
//        while (true) {
//            System.out.println("Ratavaihtoehdot tänään " + radat.getRadat().keySet());
//            System.out.print("Valitse rata: ");
//            rata = lukija.nextLine();
//            System.out.println();
//
//            boolean valittuOnRata = false;
//            for (String s : radat.getRadat().keySet()) {
//                if (rata.equals(s)) {
//                    valittuOnRata = true;
//                    break;
//                }
//            }
//            if (valittuOnRata) {
//                break;
//            } else {
//                System.out.println("Valitsemasi nimistä rataa ei ole tänään tarjolla!");
//            }
//        }

        Pelaaja pelaaja = new Pelaaja(nimi, leveys, korkeus);

        pelaaja.lisaaKiekko();

        Kiekkopeli kike = new Kiekkopeli(leveys, korkeus, pelaaja, rata, radat);

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
