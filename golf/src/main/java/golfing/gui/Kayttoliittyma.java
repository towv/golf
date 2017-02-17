package golfing.gui;

import golfing.peli.Kiekkopeli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

        nappiPaneeli.add(alku);
        nappiPaneeli.add(menu);
        nappiPaneeli.add(peli);
        nappiPaneeli.add(tuloskortti);

        alku.addActionListener(new Napinkuuntelija(layout, kortit));
        menu.addActionListener(new Napinkuuntelija(layout, kortit));
        peli.addActionListener(new Napinkuuntelija(layout, kortit));
        tuloskortti.addActionListener(new Napinkuuntelija(layout, kortit));

        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(kike.getPelaaja());
        peli.addKeyListener(kuuntelija);
        
        BorderLayout alkulayout = new BorderLayout();
        JTextField pelaajanNimi = new JTextField("Syötä tähän nimesi");
        JTextField radanNimi = new JTextField("Syötä tähän valitsemasi rata, vaihtoehdot tänään: " + 
                kike.getRadat().getRadat().keySet());
        JButton vahvistusNappi = new JButton("Vahvista tästä, ja siirry peli-ikkunaan hiirellä");
        vahvistusNappi.addActionListener(new AlkunaytonKuuntelija(pelaajanNimi, radanNimi, kike, layout, kortit));
        
        JPanel alkupaneeli = new JPanel(alkulayout);
        alkupaneeli.add(pelaajanNimi, BorderLayout.NORTH);
        alkupaneeli.add(radanNimi, BorderLayout.SOUTH);
        alkupaneeli.add(vahvistusNappi, BorderLayout.CENTER);
        kortit.add(alkupaneeli, "alkuvalikko");
        
        piirtoalusta = new Piirtoalusta(kike, pituus);
        kortit.add(piirtoalusta, "pelinakyma");

        JButton vaylanVaihtoNappi = new JButton("Vaihda väylää");
        vaylanVaihtoNappi.addActionListener(new VaylaNapinKuuntelija(kike));
        kortit.add(vaylanVaihtoNappi, "menu");

        TuloskortinPiirtaja tuloskortinpiirtaja = new TuloskortinPiirtaja(kike);
        kortit.add(tuloskortinpiirtaja, "tuloskortti");
        tuloskortti.addActionListener(new TuloskortinKuuntelija(tuloskortinpiirtaja));

        kike.setPaivitettava(piirtoalusta);

        frame.add(kortit);

        frame.add(nappiPaneeli, BorderLayout.SOUTH);

//        container.add(piirtoalusta);
//        frame.addKeyListener(kuuntelija);
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
