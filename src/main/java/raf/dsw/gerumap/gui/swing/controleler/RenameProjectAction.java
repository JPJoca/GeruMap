package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.controleler.popup.RenameBox;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class RenameProjectAction extends AbstractGerumapAction{

    public RenameProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadicon("/img/edit.png"));
        putValue(NAME,"Rename Project");
        putValue(SHORT_DESCRIPTION,"Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{

            MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();

            new RenameBox();
        }catch (Exception exception){
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT);
        }

    }
}
