package raf.dsw.gerumap.gui.swing.controleler.popup;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutorText extends JDialog implements ActionListener {
    private JTextField textF;
    private JButton b;
    private JPanel p;

    private Project project;
    public AutorText() {
        init();
        pokazi();
    }

    public AutorText( Project project) {
        init();
        pokazi();
        this.project = project;

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
        this.setTitle("Ime Autora");
        this.setSize(150,150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public String toString() {
        return this.textF.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.toString();
        if(name.isEmpty()){
            AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_EMPTY_STRING);
            return;
        }
        if(project == null) {
            MapNode node = MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
            if(!(node instanceof Project)){
                AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_RENAME_AUTHOR);
                return;
            }
            ((Project) node).renameAuthor(name);
        } else{
            project.renameAuthor(name);
        }
        this.dispose();
    }
}

