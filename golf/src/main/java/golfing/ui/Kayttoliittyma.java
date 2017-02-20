package golfing.ui;

import golfing.peli.Kiekkopeli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Kiekkopelisovelluksen graafinen käyttöliittymä.
 *
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kiekkopeli kike;
    private int pituus;
    private Piirtoalusta piirtoalusta;

    /**
     * Käyttöliittymä.
     *
     * @param kike Kiekkopeli-olio
     * @param pituus pituus
     */
    public Kayttoliittyma(Kiekkopeli kike, int pituus) {
        this.kike = kike;
        this.pituus = pituus;

    }

    @Override
    public void run() {
        frame = new JFrame("Frisbeegolf .. MANIA!!");
        int leveys = (kike.getLeveys() + 1) * pituus + 10;
        int korkeus = (kike.getKorkeus() + 1) * pituus + 10;

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {

        CardLayout layout = new CardLayout();
        JPanel kortit = new JPanel(layout);

        JButton alku = new JButton("Aloitusnäyttö");
        JButton menu = new JButton("Menu");
        JButton peli = new JButton("Peli");
        JButton tuloskortti = new JButton("Tuloskortti");

        JPanel nappiPaneeli = new JPanel();

        lisaaNapitPaneeliin(nappiPaneeli, alku, menu, peli, tuloskortti);

        lisaaKuuntelijatValilehtiNapeille(alku, layout, kortit, menu, peli, tuloskortti);

        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(kike.getPelaaja());
        peli.addKeyListener(kuuntelija);

        BorderLayout alkulayout = new BorderLayout();
        JTextField pelaajanNimi = new JTextField("Syötä tähän nimesi");
        JTextField radanNimi = new JTextField("Syötä tähän valitsemasi rata, vaihtoehdot tänään: "
                + kike.getRadat().getRadat().keySet());
        JButton vahvistusNappi = new JButton("Vahvista tästä, ja siirry peli-ikkunaan hiirellä");

//        JButton ohje = new JButton("Ohjeet");
//        JButton kiekonValinta = new JButton("Valitse kiekot");
        vahvistusNappi.addActionListener(new Alkunaytonkuuntelija(pelaajanNimi, radanNimi, kike, layout, kortit));

        JPanel alkupaneeli = new JPanel(alkulayout);
        alkupaneeli.add(pelaajanNimi, BorderLayout.NORTH);
        alkupaneeli.add(radanNimi, BorderLayout.SOUTH);
        alkupaneeli.add(vahvistusNappi, BorderLayout.CENTER);
//        alkupaneeli.add(ohje, BorderLayout.WEST);
//        alkupaneeli.add(kiekonValinta, BorderLayout.EAST);
        kortit.add(alkupaneeli, "alkuvalikko");

        piirtoalusta = new Piirtoalusta(kike, pituus);
        kortit.add(piirtoalusta, "pelinakyma");

        ImageIcon kumpulakartta = new ImageIcon("/home/twviiala/golf/golf/golf/src/main/resources/kumpulakartta.jpeg");
        JButton vaylanVaihtoNappi = new JButton("Vaihda väylää", kumpulakartta);
        vaylanVaihtoNappi.setIconTextGap(20);
        vahvistusNappi.setName("Vaihda väylää");
        vahvistusNappi.setOpaque(true);
        vaylanVaihtoNappi.addActionListener(new Vaylanapinkuuntelija(kike));
        kortit.add(vaylanVaihtoNappi, "menu");

        Tuloskortinpiirtaja tuloskortinpiirtaja = new Tuloskortinpiirtaja(kike);
        kortit.add(tuloskortinpiirtaja, "tuloskortti");
        tuloskortti.addActionListener(new Tuloskortinkuuntelija(tuloskortinpiirtaja));

        kike.setPaivitettava(piirtoalusta);

        frame.add(kortit);

        frame.add(nappiPaneeli, BorderLayout.SOUTH);

//        container.add(piirtoalusta);
//        frame.addKeyListener(kuuntelija);
    }

    private void lisaaNapitPaneeliin(JPanel nappiPaneeli, JButton alku, JButton menu, JButton peli, JButton tuloskortti) {
        nappiPaneeli.add(alku);
        nappiPaneeli.add(menu);
        nappiPaneeli.add(peli);
        nappiPaneeli.add(tuloskortti);
    }

    private void lisaaKuuntelijatValilehtiNapeille(JButton alku, CardLayout layout, JPanel kortit, JButton menu, JButton peli, JButton tuloskortti) {
        alku.addActionListener(new Napinkuuntelija(layout, kortit));
        menu.addActionListener(new Napinkuuntelija(layout, kortit));
        peli.addActionListener(new Napinkuuntelija(layout, kortit));
        tuloskortti.addActionListener(new Napinkuuntelija(layout, kortit));
    }

    /**
     *
     * @return palauttaa piirtoalustan
     */
    public Paivitettava getPaivitettava() {
        return piirtoalusta;
    }

    /**
     *
     * @return framen
     */
    public JFrame getFrame() {
        return frame;
    }

    class PanelOne extends JPanel {

        public PanelOne() {
            setBackground(Color.GREEN);
            add(new JLabel("Panel one"));
        }
    }
}
