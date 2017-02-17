package golfing.gui;

import golfing.kiekko.Pelaaja;
import golfing.peli.Kiekkopeli;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Alkunäytönkuuntelija. Kuuntelee alkunäyttöä. 
 * Käyttäjän nimi ja radannimi käyttäjän syötteen mukaan.
 */
public class AlkunaytonKuuntelija implements ActionListener {

    private JTextField kayttajanNimi;
    private JTextField radanNimi;
    private Kiekkopeli kiekkopeli;
    private CardLayout layout;
    private JPanel kortit;

    /**
     * Konstruktori. 
     * @param kayttajanNimi Tekstialue käyttäjän nimen syöttämistä varten.
     * @param radanNimi Tekstialue radan nimen syöttämistä varten.
     * @param kiekkopeli Pelattava peli
     * @param layout Kortti layout.
     * @param kortit Korttien piirto.
     */
    public AlkunaytonKuuntelija(JTextField kayttajanNimi, JTextField radanNimi, Kiekkopeli kiekkopeli, CardLayout layout, JPanel kortit) {
        this.kayttajanNimi = kayttajanNimi;
        this.radanNimi = radanNimi;
        this.kiekkopeli = kiekkopeli;
        this.layout = layout;
        this.kortit = kortit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean kayttajanNimiSyotetty = false;

        if (kayttajanNimi.getText().isEmpty()) {
            kayttajanNimi.setText("Nimeä ei voi jättää tyhjäksi!");
        } else if (kayttajanNimi.getText().equals("Nimeä ei voi jättää tyhjäksi!") || kayttajanNimi.getText().equals("Syötä tähän nimesi")) {
            kayttajanNimi.setText("Anna nimesi");
        } else {
            kiekkopeli.getPelaaja().setNimi(kayttajanNimi.getText());
            kayttajanNimiSyotetty = true;
        }

        String rata = radanNimi.getText();
        boolean valittuOnRata = false;
        for (String s : kiekkopeli.getRadat().getRadat().keySet()) {
            if (rata.equals(s)) {
                valittuOnRata = true;
            }
        }
        if (valittuOnRata) {
            kiekkopeli.setRata(rata);
        } else if (rata.equals("Valitsemasi nimistä rataa ei ole tänään tarjolla!")) {
            radanNimi.setText("Ratavaihtoehdot tänään " + kiekkopeli.getRadat().getRadat().keySet());
        } else {
            radanNimi.setText("Valitsemasi nimistä rataa ei ole tänään tarjolla!");
        }

        if (kayttajanNimiSyotetty && valittuOnRata) {
            layout.show(kortit, "pelinakyma");
        }

    }

}
