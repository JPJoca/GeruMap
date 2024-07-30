package raf.dsw.gerumap.gui.swing.controleler;



import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

public class NewProjectAction extends AbstractGerumapAction{
    public NewProjectAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadicon("/img/new.png"));
        putValue(NAME,"New Project");
        putValue(SHORT_DESCRIPTION,"New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            MapTreeItem selected =  MainFrame.getInstance().getMapTree().getSelectedNode();
            if(selected.getMapNode() instanceof Element){
                AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_ADD_CHILD);
                return;
            }
            MainFrame.getInstance().getMapTree().addChild(selected);
        }
        catch (NullPointerException exeption){
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT);
        }
    }
}
