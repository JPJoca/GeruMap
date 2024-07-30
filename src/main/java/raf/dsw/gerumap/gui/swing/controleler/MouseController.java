package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {
    private MapView mapView;


    public MouseController(MapView mapView){
        this.mapView = mapView;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MainFrame.getInstance().getProjectViewView().misKliknut(mapView, (int) (e.getX() / mapView.getScalingFactor()), (int) (e.getY() / mapView.getScalingFactor()), e.getClickCount());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MainFrame.getInstance().getProjectViewView().misPusten(mapView, (int) (e.getX() / mapView.getScalingFactor()), (int) (e.getY() / mapView.getScalingFactor()));
    }
}
