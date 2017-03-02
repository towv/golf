package golfing.listeners;

import golfing.peli.Kiekkopeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * Vayla -nappia kuunteleva luokka. Antaa Kiekkopelille käskyn vaihtaa väylää.
 */
public class Vaylanapinkuuntelija implements ActionListener {

    private Kiekkopeli kike;

    /**
     * Vaylanapinkuuntelija. Konstruktori.
     *
     * @param kike Peli jota pelataan.
     */
    public Vaylanapinkuuntelija(Kiekkopeli kike) {
        this.kike = kike;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kike.vaihdaVaylaa();
    }

}
