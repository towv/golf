package golfing.gui;

import golfing.kiekko.Vari;
import golfing.peli.Kiekkopeli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kiekkopeli kike;
    private int pituus;
    private Piirtoalusta piirtoalusta;

    public Kayttoliittyma(Kiekkopeli kike, int pituus) {
        this.kike = kike;
        this.pituus = pituus;

    }

    @Override
    public void run() {
        frame = new JFrame("Kumpulan frisbeegolfrata");
        int leveys = (kike.getLeveys() + 1) * pituus + 10;
        int korkeus = (kike.getKorkeus() + 1) * pituus + 10;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {
        
//        BorderLayout layout = new BorderLayout(2, 2);
//        
//        container.setLayout(layout);
        
        piirtoalusta = new Piirtoalusta(kike, pituus);
        container.add(piirtoalusta);
        kike.setPaivitettava(piirtoalusta);
        
//        JLabel tekstikentta = new JLabel("Moi " + kike.getPelaaja().getNimi());
//        container.add(tekstikentta, BorderLayout.SOUTH);

        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(kike.getPelaaja());
        frame.addKeyListener(kuuntelija);
    }

    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }

    public JFrame getFrame() {
        return frame;
    }

}
