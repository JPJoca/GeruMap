package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractGerumapAction{
    public RedoAction(){
        this.setEnabled(false);
        putValue(SMALL_ICON, loadicon("/img/redoDisableIcon.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AppCore.getInstance().getGui().getCommandManager().doCommand();
    }
}
