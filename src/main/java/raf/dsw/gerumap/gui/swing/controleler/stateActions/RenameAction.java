package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class RenameAction extends AbstractGerumapAction {
    public RenameAction() {
        putValue(SMALL_ICON, loadicon("/img/raction.png"));
        putValue(NAME,"Rename Painter");
        putValue(SHORT_DESCRIPTION,"Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startRenameState();
    }
}
