package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class LasoSelectionAction extends AbstractGerumapAction {
    public LasoSelectionAction() {
        putValue(SMALL_ICON, loadicon("/img/laso.png"));
        putValue(NAME, "LasoSelection");
        putValue(SHORT_DESCRIPTION, "Laso");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startLasoSelectState();
    }
}
