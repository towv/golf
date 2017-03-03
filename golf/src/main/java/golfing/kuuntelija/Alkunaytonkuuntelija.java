package golfing.kuuntelija;

import golfing.peli.Kiekkopeli;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Alkunäytönkuuntelija. Kuuntelee alkunäyttöä. Käyttäjän nimi ja radannimi
 * käyttäjän syötteen mukaan.
 */
public class Alkunaytonkuuntelija implements ActionListener {

    private JTextField kayttajanNimi;
    private JComboBox radanNimi;
    private Kiekkopeli kiekkopeli;
    private CardLayout layout;
    private JPanel kortit;

    /**
     * Konstruktori.
     *
     * @param kayttajanNimi Tekstialue käyttäjän nimen syöttämistä varten.
     * @param radanNimi Tekstialue radan nimen syöttämistä varten.
     * @param kiekkopeli Pelattava peli
     * @param layout Kortti layout.
     * @param kortit Korttien piirto.
     */
    public Alkunaytonkuuntelija(JTextField kayttajanNimi, JComboBox radanNimi, Kiekkopeli kiekkopeli, CardLayout layout, JPanel kortit) {
        this.kayttajanNimi = kayttajanNimi;
        this.radanNimi = radanNimi;
        this.kiekkopeli = kiekkopeli;
        this.layout = layout;
        this.kortit = kortit;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Käyttäjän nimi
        boolean kayttajanNimiSyotetty = false;

        if (kayttajanNimi.getText().isEmpty()) {
            kayttajanNimi.setText("Nimeä ei voi jättää tyhjäksi!");
        } else if (kayttajanNimi.getText().equals("Nimeä ei voi jättää tyhjäksi!")
                || kayttajanNimi.getText().equals("Syötä tähän nimesi")
                || kayttajanNimi.getText().equals("Anna nimesi")
                || kayttajanNimi.getText().equals("Liian pitkä nimi, max 15 merkkiä")) {
            kayttajanNimi.setText("Anna nimesi");
        } else if (kayttajanNimi.getText().length() > 15) {
            kayttajanNimi.setText("Liian pitkä nimi, max 15 merkkiä");
        } else {
            kiekkopeli.getPelaaja().setNimi(kayttajanNimi.getText());
            kayttajanNimiSyotetty = true;
        }
        // Rata
        String rata = (String) radanNimi.getSelectedItem();

        boolean valittuOnRata = false;
        for (String s : kiekkopeli.getRadat().getRadat().keySet()) {
            if (rata.equals(s)) {
                valittuOnRata = true;
            }
        }
        if (valittuOnRata) {
            kiekkopeli.setRata(rata);
        }

        // Oikea syöte, pelinäkymään
        if (kayttajanNimiSyotetty && valittuOnRata) {
            layout.show(kortit, "pelinakyma");
            
        }
    }

}
