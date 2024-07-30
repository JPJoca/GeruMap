package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectAction extends AbstractGerumapAction {
    public SelectAction(){
        putValue(SMALL_ICON, loadicon("/img/selectIcon.png"));
        putValue(NAME, "Select Icon");
        putValue(SHORT_DESCRIPTION, "Selecet Icon");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startSelectState();
    }
}
