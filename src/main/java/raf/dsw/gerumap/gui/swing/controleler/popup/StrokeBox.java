package raf.dsw.gerumap.gui.swing.controleler.popup;

import lombok.Getter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.StrokeCommand;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class StrokeBox extends JDialog  implements ActionListener {

    private JTextField textF;
    private JButton b;
    private JPanel p;
    private MapView map;
    private Painter painter;

    public StrokeBox(MapView map, Painter p) {
        init();
        pokazi();
        this.map = map;
        this.painter = p;

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
        this.setTitle("Set Stroke");
        this.setSize(150,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public String toString() {
        return  this.textF.getText();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        int stroke = painter.getElement().getStroke();
        try {
             stroke = Integer.parseInt(textF.getText());
        }catch (NumberFormatException exception){
            textF.setText(null);
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_INSERT_TEXT);


        }
        if(this.textF.getText() != null) {
            System.out.println("Stroke je " + stroke);
            for (Painter painter : map.getMapSelectionModel().getSelectedElements()) {
                AbstractCommand command = new StrokeCommand(map.getMap(),(Topic)painter.getElement(),stroke,painter.getElement().getStroke());
                AppCore.getInstance().getGui().getCommandManager().addCommand(command);

                painter.getElement().setStroke(stroke);

                System.out.println(painter.getElement().getStroke());
            }
            this.dispose();
        }
    }
}
