package golfing.ui;

import golfing.kuuntelija.*;
import golfing.peli.Kiekkopeli;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

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

        CardLayout korttilayout = new CardLayout();
        JPanel kortit = new JPanel(korttilayout);
        
        // Välilehti napit
        JButton alku = new JButton("Aloitusnäyttö");
        JButton menu = new JButton("Menu");
        JButton peli = new JButton("Peli");
        JButton tuloskortti = new JButton("Tuloskortti");

        JPanel nappiPaneeli = new JPanel();

        lisaaNapitPaneeliin(nappiPaneeli, alku, menu, peli, tuloskortti);

        lisaaKuuntelijatValilehtiNapeille(alku, korttilayout, kortit, menu, peli, tuloskortti);
        
        // Pelaamisen kuuntelija
        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(kike.getPelaaja());
        peli.addKeyListener(kuuntelija);

        JButton vahvistusNappi = alkuIkkunanLuonti(korttilayout, kortit);
        
        // Peli-ikkuna
        piirtoalusta = new Piirtoalusta(kike, pituus);
        kortit.add(piirtoalusta, "pelinakyma");
        
        menuIkkunanLuonti(vahvistusNappi, menu, kortit);
        
        tuloskorttiIkkunanLuonti(kortit, tuloskortti);

        kike.setPaivitettava(piirtoalusta);

        frame.add(kortit);

        frame.add(nappiPaneeli, BorderLayout.SOUTH);
    }

    private void tuloskorttiIkkunanLuonti(JPanel kortit, JButton tuloskortti) {
        // Tuloskortti -välilehti
        Tuloskortinpiirtaja tuloskortinpiirtaja = new Tuloskortinpiirtaja(kike);
        kortit.add(tuloskortinpiirtaja, "tuloskortti");
        tuloskortti.addActionListener(new Tuloskortinkuuntelija(tuloskortinpiirtaja));
    }

    private void menuIkkunanLuonti(JButton vahvistusNappi, JButton menu, JPanel kortit) {
        // Menu -ikkuna
        BorderLayout menuLayout = new BorderLayout();
        JPanel menuPaneeli = new JPanel(menuLayout);

        InputStream is = getClass().getClassLoader().getResourceAsStream("kumpulakartta.jpeg");
        InputStream ps = getClass().getClassLoader().getResourceAsStream("pasilakartta.jpeg");
        InputStream as = getClass().getClassLoader().getResourceAsStream("aloituskuva.jpeg");

        BufferedImage bf = null;
        BufferedImage af = null;
        BufferedImage pf = null;
        try {
            bf = ImageIO.read(is);
            af = ImageIO.read(as);
            pf = ImageIO.read(ps);
        } catch (Exception b) {
        }
        ImageIcon kumpulakartta = new ImageIcon(bf.getScaledInstance(400, 400, 400));
        ImageIcon pasilakartta = new ImageIcon(pf.getScaledInstance(400, 400, 400));
        // Aloituskuva, liittyy aloitusvälilehteen, mutta muiden kuvien kanssa samassa kohdassa
        ImageIcon aloituskuva = new ImageIcon(af.getScaledInstance(420, 550, 500));
        vahvistusNappi.setIcon(aloituskuva);

        if (af == null) {
            vahvistusNappi.setText("Vahvista tästä, ja siirry peli-ikkunaan hiirellä");
        }

        HashMap<String, ImageIcon> vaylakartat = new HashMap<>();
        vaylakartat.put("kumpula", kumpulakartta);
        vaylakartat.put("pasila", pasilakartta);

        JButton vaylanVaihtoNappi = new JButton();
        vaylanVaihtoNappi.addActionListener(new Vaylanapinkuuntelija(kike));
        menu.addActionListener(new Menunkuuntelija(kike, vaylanVaihtoNappi, vaylakartat));

        JButton kiekonVaihtoNappi = new JButton("Vaihda kiekkoa");
        kiekonVaihtoNappi.addActionListener(new Kiekonvaihtonapinkuuntelija(kike, kiekonVaihtoNappi));

        menuPaneeli.add(vaylanVaihtoNappi, BorderLayout.CENTER);
        menuPaneeli.add(kiekonVaihtoNappi, BorderLayout.NORTH);

        kortit.add(menuPaneeli, "menu");
    }

    private JButton alkuIkkunanLuonti(CardLayout layout, JPanel kortit) {
        // Alku-ikkuna
        BorderLayout alkulayout = new BorderLayout();
        JTextField pelaajanNimi = new JTextField("Syötä tähän nimesi");
        String[] ratavaihtoehdot = {"Ratavaihtoehdot tänään: " + kike.getRadat().getRadat().keySet(), "Pasila", "Kumpula"};
        JComboBox radanNimi = new JComboBox(ratavaihtoehdot);
        radanNimi.setSelectedIndex(0);
        JButton vahvistusNappi = new JButton();
        vahvistusNappi.addActionListener(new Alkunaytonkuuntelija(pelaajanNimi, radanNimi, kike, layout, kortit));
        JPanel alkupaneeli = new JPanel(alkulayout);
        alkupaneeli.add(pelaajanNimi, BorderLayout.NORTH);
        alkupaneeli.add(radanNimi, BorderLayout.SOUTH);
        alkupaneeli.add(vahvistusNappi, BorderLayout.CENTER);
        // Laajennukseen eri olosuhteet eri päivinä ja kustomoidut kiekot
//        alkupaneeli.add(viikonPaiva, BorderLayout.WEST);
//        alkupaneeli.add(kiekonValinta, BorderLayout.EAST);
        kortit.add(alkupaneeli, "alkuvalikko");
        return vahvistusNappi;
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
}
