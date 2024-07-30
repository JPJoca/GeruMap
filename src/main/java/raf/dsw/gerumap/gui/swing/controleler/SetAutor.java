package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.controleler.popup.AutorText;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class SetAutor extends AbstractGerumapAction{

    public SetAutor() {
        putValue(SMALL_ICON, loadicon("/img/author (1).png"));
        putValue(NAME,"Set/Rename Author");
        putValue(SHORT_DESCRIPTION,"RENAME AUTHOR");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            MapNode node = MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
            if(node instanceof Project) {
                new AutorText();
            } else
            {
                AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_RENAME_AUTHOR);

            }
        }catch (NullPointerException exception){
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT);
        }



    }
}
