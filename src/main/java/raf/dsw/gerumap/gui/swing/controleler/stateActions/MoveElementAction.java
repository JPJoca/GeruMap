package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveElementAction extends AbstractGerumapAction {
    public MoveElementAction(){
        putValue(SMALL_ICON, loadicon("/img/moveIcon.png"));
        putValue(NAME, "Move Element");
        putValue(SHORT_DESCRIPTION, "Move Element");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startMoveElementState();
    }
}
