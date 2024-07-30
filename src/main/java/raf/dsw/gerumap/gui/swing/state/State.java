package raf.dsw.gerumap.gui.swing.state;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;

import java.awt.event.KeyEvent;

public interface State {
    void misKliknut(MapView map, int x, int y, int clickCount);
    void misPovucen(MapView map, int x, int y);
    void misPusten(MapView map, int x, int y);
    void dugmeKliknuto(MapView view, KeyEvent e);
}
