package raf.dsw.gerumap.gui.swing.controleler.popup;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.NameCommadn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Getter
@Setter
public class NameBox extends JDialog implements ActionListener {

    private JTextField textF;
    private JButton b;
    private JPanel p;

    private Topic topic;
    private MapView mapView;

    public NameBox(Topic topic , MapView mapView) {
        init();
        pokazi();
        this.topic = topic;
        this.mapView = mapView;

    }

    private void init() {
        textF = new JTextField(9);
        p = new JPanel();
        b = new JButton("Ok");
        b.addActionListener(this);
        add(p);
        p.add(textF);
        p.add(b);
    }

    public void pokazi(){
        this.setTitle("Set name: ");
        this.setSize(150,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        AbstractCommand command = new NameCommadn(topic,textF.getText(),topic.getName());
        AppCore.getInstance().getGui().getCommandManager().addCommand(command);

        topic.setName(textF.getText());

        this.dispose();
    }

}
