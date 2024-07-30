package raf.dsw.gerumap.gui.swing.state.concrete;


import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.controleler.popup.NameBox;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class RenameState implements State {
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        System.out.println("VElicina selektovanoh je : " + map.getMapSelectionModel().getSelectedElements().size());

        if(map.getMapSelectionModel().getSelectedElements().isEmpty()) {
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT_BEFORE_RENAME);
            return;
        }
        if(map.getMapSelectionModel().getSelectedElements().size() > 1){
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT_ONLY_ONE);
            return;
        }
        Topic t = ((Topic)map.getMapSelectionModel().getSelectedElements().get(0).getElement());
        new NameBox(t,map);
    }

    @Override
    public void misPovucen(MapView map, int x, int y) {

    }

    @Override
    public void misPusten(MapView map, int x, int y) {
        map.getMapSelectionModel().removeAllElemets();
    }

    @Override
    public void dugmeKliknuto(MapView view, KeyEvent e) {

    }
}
