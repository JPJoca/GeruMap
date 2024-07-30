package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddLinkAction extends AbstractGerumapAction {

    public AddLinkAction(){
        putValue(SMALL_ICON, loadicon("/img/addLinkIcon.png"));
        putValue(NAME, "New Link");
        putValue(SHORT_DESCRIPTION, "New Link");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startAddLinkState();
    }
}
