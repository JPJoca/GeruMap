package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddTopicAction extends AbstractGerumapAction {
    public AddTopicAction(){
        putValue(SMALL_ICON, loadicon("/img/addTopicIcon.png"));
        putValue(NAME, "New Topic");
        putValue(SHORT_DESCRIPTION, "New Topic");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startAddTopicState();
    }
}
