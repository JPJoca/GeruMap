package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class StrokeAction extends AbstractGerumapAction {
    public StrokeAction() {
        putValue(SMALL_ICON, loadicon("/img/stroke.png"));
        putValue(NAME, "SetStroke");
        putValue(SHORT_DESCRIPTION, "Stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startStrokeState();
    }
}
