package golfing.gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * Kuuntelija luokka korttipaneelia varten. Jokaisella välilehti napilla on 
 * napinkuuntelija. Hoitaa siirtymät välilehdeltä toiselle.
 * 
 */
public class Napinkuuntelija implements ActionListener {

    private CardLayout layout;
    private JPanel kortit;

    /**
     * Konstruktori.
     * @param layout Kortti layout
     * @param kortit Kortti paneeli
     */
    public Napinkuuntelija(CardLayout layout, JPanel kortit) {
        this.layout = layout;
        this.kortit = kortit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String komento = e.getActionCommand();

        if ("Menu".equals(komento)) {
            layout.show(kortit, "menu");
        } else if ("Peli".equals(komento)) {
            layout.show(kortit, "pelinakyma");
        } else if ("Aloitusnäyttö".equals(komento)) {
            layout.show(kortit, "alkuvalikko");           
        } else if ("Tuloskortti".equals(komento)) {
            layout.show(kortit, "tuloskortti");
        }
    }
}
