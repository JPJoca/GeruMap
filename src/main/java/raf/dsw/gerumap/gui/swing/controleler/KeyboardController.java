package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {
    private MapView mapView;

    public KeyboardController(MapView mapView){
        this.mapView = mapView;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        MainFrame.getInstance().getProjectViewView().dugmeKliknuto(mapView, e);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
