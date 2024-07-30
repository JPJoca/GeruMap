package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;

public class SetCentralTopicAction extends AbstractGerumapAction {

    public SetCentralTopicAction() {
        putValue(SMALL_ICON, block(Color.black));
        putValue(NAME, "SetCentralTopic");
        putValue(SHORT_DESCRIPTION, "SetC Topic");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startCentralTopicAction();
    }
}
