package golfing.gui;

import golfing.kiekko.Vari;
import golfing.peli.Kiekkopeli;
import golfing.peli.Tuloskortti;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Kiekkopelisovelluksen piirtäjä. Toteuttaa paivitettava rajapinnan.
 *
 */

public class Piirtoalusta extends JPanel implements Paivitettava {

    private Kiekkopeli kiekkopeli;
    private int kiekonLeveys;
    private Vari kiekonVari;

    /**
     * Piirtoalustan konstruktori.
     * @param kiekkopeli - olio
     * @param kiekonLeveys - kiekonkoko
     */
    public Piirtoalusta(Kiekkopeli kiekkopeli, int kiekonLeveys) {
        super.setBackground(Color.CYAN);
        this.kiekkopeli = kiekkopeli;
        this.kiekonLeveys = kiekonLeveys;
        this.kiekonVari = kiekkopeli.getPelaaja().getKaytossaOlevanKiekonVari();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        g.drawString("" + kiekkopeli.getTilanne(), 0, 20);
        
        String viesti = kiekkopeli.getViesti();
        String[] rivit = viesti.split("\n");
        String rivi1 = rivit[0];
        String rivi2 = rivit[1];
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        g.drawString(rivi1, 0, 350);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        g.drawString(rivi2, 0, 380);

        g.setColor(Color.ORANGE);
        g.fillRect(130, 210, 15, 100);

        g.setColor(Color.GREEN);
        g.fillOval(100, 200, 80, 40);

        g.setColor(Color.BLACK);
        g.fillOval(kiekkopeli.getKori().getX() * kiekonLeveys, kiekkopeli.getKori().getY() * kiekonLeveys, kiekonLeveys * 2, kiekonLeveys * 2);
        
        if (kiekonVari == Vari.LIILA) {
            g.setColor(Color.MAGENTA);
        } else if (kiekonVari == Vari.HARMAA) {
            g.setColor(Color.GRAY);
        } else if (kiekonVari == Vari.SININEN) {
            g.setColor(Color.BLUE);
        }
        
        g.fillOval(kiekkopeli.getKiekko().getSijainti().getX() * kiekonLeveys, kiekkopeli.getKiekko().getSijainti().getY() * kiekonLeveys, kiekonLeveys, kiekonLeveys);
    }

    /**
     * Toteutus Paivitettava rajapinnan metodille paivita().
     */
    @Override
    public void paivita() {
        repaint();
    }

}
