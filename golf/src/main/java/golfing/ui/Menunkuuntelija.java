package golfing.ui;

import golfing.peli.Kiekkopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * Tapahtumankuuntelija. Kuuntelee menu nappia, vaihtaa väylänapin kuvaa.
 */
public class Menunkuuntelija implements ActionListener {

    private Kiekkopeli kike;
    private JButton vaylanVaihtoNappi;
    private HashMap<String, ImageIcon> vaylakartat;

    /**
     * Menunkuuntelija. Konstruktori.
     *
     * @param kike Peli jota pelataan.
     * @param vaylanVaihtoNappi Nappi jonka icon päivitetään.
     * @param vaylakartat Vaylakartat imageiconeina arvoina hashmapissa. Avain rata String.
     */
    public Menunkuuntelija(Kiekkopeli kike, JButton vaylanVaihtoNappi, HashMap<String, ImageIcon> vaylakartat) {
        this.kike = kike;
        this.vaylanVaihtoNappi = vaylanVaihtoNappi;
        this.vaylakartat = vaylakartat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (kike.getRata().equals("Kumpulan frisbeegolfrata")) {
            vaylanVaihtoNappi.setIcon(vaylakartat.get("kumpula"));
        } else {
            vaylanVaihtoNappi.setText("Vaihda väylää");
        }
    }

}
