package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomOutAction extends AbstractGerumapAction {
    public ZoomOutAction(){
        putValue(SMALL_ICON, loadicon("/img/zoomOut.png"));
        putValue(NAME, "ZoomOut");
        putValue(SHORT_DESCRIPTION, "ZoomOut");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startZoomOutState();
    }
}
