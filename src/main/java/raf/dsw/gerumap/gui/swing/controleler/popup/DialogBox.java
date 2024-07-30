package raf.dsw.gerumap.gui.swing.controleler.popup;

import javax.swing.*;
import java.awt.*;

public class DialogBox extends JDialog {

    private JLabel  ime1;
    private JLabel ime2;

    private Icon slika1;
    private Icon slika2;

    private JButton b;

    public DialogBox(){
        initialise();
    }

    private void initialise() {
        ime1 = new JLabel("Jovan Pavlovic 65/21RN");
        ime2 = new JLabel("Jovan Simonovic 70/21RN");

        b = new JButton("Ok");
        b.addActionListener(e -> {
            this.dispose();
        });

        slika1 = new ImageIcon(getClass().getResource("/img/Jp.jpg"));
        JLabel s1 = new JLabel(slika1);
        slika2 = new ImageIcon(getClass().getResource("/img/Js.jpg"));
        JLabel s2 = new JLabel(slika2);

        JPanel p = new JPanel();
        this.add(p);
        p.add(ime1, JPanel.RIGHT_ALIGNMENT);
        p.add(s1);
        p.add(ime2, JPanel.RIGHT_ALIGNMENT);
        p.add(s2);
        p.add(b);
    }

    public void pokazi(){
        this.setTitle("Informacije");
        this.setSize(300,650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
