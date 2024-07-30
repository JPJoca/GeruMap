package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Rectangle;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.view.painter.view.RectanglePainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.TopicPainter;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class LasoSelectionState implements State {
    private Rectangle rectangle;
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        map.getMapSelectionModel().removeAllElemets();
        rectangle = new Rectangle("", map.getMap(), x, y, x, y);
        Painter painter = new RectanglePainter(rectangle);
        map.addPainter(painter);
    }

    @Override
    public void misPovucen(MapView map, int x, int y) {
        map.removePainters();
        rectangle.makeDimensions(x, y);
        Painter painter = new RectanglePainter(rectangle);
        map.getMapSelectionModel().removeAllElemets();
        for(Painter p : map.getPainters()){
            if(p instanceof TopicPainter && painter.elementAt(((Topic)p.getElement()).getX(), ((Topic)p.getElement()).getY())
                    && !map.getMapSelectionModel().getSelectedElements().contains(p)) {
                map.getMapSelectionModel().addSelectedElement(p);
            }
        }
        map.addPainter(painter);
    }

    @Override
    public void misPusten(MapView map, int x, int y) {
        map.removePainters();
    }

    @Override
    public void dugmeKliknuto(MapView view, KeyEvent e) {

    }
}
