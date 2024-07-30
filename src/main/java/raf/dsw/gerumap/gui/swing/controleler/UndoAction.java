package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractGerumapAction{
    public UndoAction(){
        this.setEnabled(false);
        putValue(SMALL_ICON, loadicon("/img/undoDisableIcon.png"));
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getGui().getCommandManager().undoCommand();
    }
}
