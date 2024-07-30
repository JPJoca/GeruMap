package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class ZoomOutState implements State {
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        if(map.getScalingFactor() / 1.2 > 0.35)
            map.setScaleForZoom(map.getScalingFactor() / 1.2);
        else
            AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_ZOOM_MORE);
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
