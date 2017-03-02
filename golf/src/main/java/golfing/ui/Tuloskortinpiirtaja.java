package golfing.ui;

import golfing.peli.Kiekkopeli;
import golfing.peli.Tuloskortti;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * Tuloskortin piirtoalusta. Piirtää tulokset kiekkopelin mukaan.
 */
public class Tuloskortinpiirtaja extends JPanel implements Paivitettava {

    private Kiekkopeli kike;

    /**
     * Tuloskortin konstruktori.
     *
     * @param kike Kiekkopeli-olio.
     */
    public Tuloskortinpiirtaja(Kiekkopeli kike) {
        super.setBackground(Color.CYAN);
        this.kike = kike;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Tuloskortti tuloskortti = kike.getTuloskortti();

        g.setColor(Color.red);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 26));

        g.drawString("" + tuloskortti.getTulosRata(), 10, 25);

        HashMap<Integer, String> tulokset = pelaajanTulosVaylilta(g, tuloskortti);

        ihanneHeitotJaPelaajanHeitot(g, tuloskortti);

        pelaajanTulos(tuloskortti, g);

        if (tuloskortti.radanPituus() == tulokset.size()) {
            g.setColor(Color.magenta);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
            g.drawString("KIERROS PELATTU", 0, 500);
        }
    }

    private void ihanneHeitotJaPelaajanHeitot(Graphics g, Tuloskortti tuloskortti) {
        g.setColor(Color.blue);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Ihanne heitot: " + tuloskortti.ihanneTulos()
                + "  Pelaajan: " + tuloskortti.yhteisTulos(), 0, 350);
    }

    private void pelaajanTulos(Tuloskortti tuloskortti, Graphics g) {
        int tulos = tuloskortti.yhteisTulos() - tuloskortti.ihanneTulos();
        String plus = "";
        if (tulos > 0) {
            plus = "+";
        }
        g.setColor(Color.blue);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        g.drawString("Pelaajan tulos: " + plus + tulos, 0, 380);
    }

    private HashMap<Integer, String> pelaajanTulosVaylilta(Graphics g, Tuloskortti tuloskortti) {
        g.setColor(Color.yellow);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        HashMap<Integer, String> tulokset = tuloskortti.getTuloksetString();
        int i = 1;
        for (String value : tulokset.values()) {
            i++;
            g.drawString(value, 5, 40 + 20 * i);
        }
        return tulokset;
    }

    /**
     * Paivitettava rajapinnan paivita() metodi ylikirjoitetaan.
     */
    @Override
    public void paivita() {
        repaint();
    }
}
