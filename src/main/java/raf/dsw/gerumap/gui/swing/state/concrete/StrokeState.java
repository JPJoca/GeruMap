package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.controleler.popup.StrokeBox;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class StrokeState implements State {
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        if(map.getMapSelectionModel().getSelectedElements().isEmpty()){
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT_BEFORE_STROKE);
            return;
        }
        for(Painter p : map.getPainters())
            if(p.elementAt(x,y)){
                new StrokeBox(map,p);
            }
    }

    @Override
    public void misPovucen(MapView map, int x, int y) {

    }

    @Override
    public void misPusten(MapView map, int x, int y) {

    }

    @Override
    public void dugmeKliknuto(MapView view, KeyEvent e) {

    }
}
