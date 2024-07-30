package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class SelectState implements State {
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        if(map.getMapSelectionModel().getSelectedElements().isEmpty()) {
            selectTest(map, x, y);
        }else{
            for(Painter p : map.getPainters()){
                if(map.getMapSelectionModel().getSelectedElements().contains(p) && p.elementAt(x, y)){
                    map.getMapSelectionModel().removeSelectedElement(p);
                    return;
                }
            }
            map.getMapSelectionModel().removeAllElemets();
            selectTest(map,x,y);
        }
    }

    private void selectTest(MapView map, int x, int y){
        for (Painter painter : map.getPainters()) {
            if (painter.elementAt(x, y) && !map.getMapSelectionModel().getSelectedElements().contains(painter)) {
                map.getMapSelectionModel().addSelectedElement(painter);
            } else if (painter.elementAt(x, y) && map.getMapSelectionModel().getSelectedElements().contains(painter)) {
                map.getMapSelectionModel().removeSelectedElement(painter);
            }
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
