package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteProjectAction extends AbstractGerumapAction {

    public DeleteProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadicon("/img/remove.png"));
        putValue(NAME,"Delete Project");
        putValue(SHORT_DESCRIPTION,"Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null) {
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT);
            return;
        }
        if(selected.getMapNode() instanceof ProjectExplorer){
            AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_DELETE_PROJECTEXPOLORER);
        }
        MainFrame.getInstance().getMapTree().removeNode(selected);
    }
}
