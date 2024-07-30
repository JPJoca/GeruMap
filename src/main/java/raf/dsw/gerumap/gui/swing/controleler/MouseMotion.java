package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseMotion extends MouseMotionAdapter {
    private MapView mapView;

    public MouseMotion(MapView mapView){
        this.mapView = mapView;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        MainFrame.getInstance().getProjectViewView().misPovucen(mapView, (int) (e.getX() / mapView.getScalingFactor()), (int) (e.getY() / mapView.getScalingFactor()));
    }
}
