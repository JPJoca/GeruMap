package raf.dsw.gerumap.gui.swing.controleler.popup;

import lombok.Getter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class RenameBox extends JDialog  implements ActionListener {

    private JTextField textF;
    private JButton b;
    private JPanel p;

    public RenameBox() {
        init();
        pokazi();

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
        this.setTitle("Rename");
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
        MapTreeItem node = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(this.toString().isEmpty()){
            AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_EMPTY_STRING);
            this.dispose();
            return;
        }
        node.setName(this.toString());
        this.dispose();
    }
}
