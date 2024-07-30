package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.state.State;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.*;

public class SetCentralTopicState implements State {
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        if(map.getMap().isHasCentralTopic()) {
            return;
        }

        if(map.getMapSelectionModel().getSelectedElements().size() != 1){
            return;
            // MESAGEGENERATOR
        }

        Painter CentralTopic = map.getMapSelectionModel().getSelectedElements().get(0);
        CentralTopic.getElement().setStroke(5);
        ((Topic)CentralTopic.getElement()).setCenter(true);
        CentralTopic.getElement().setColor(new Color(255, 0, 255));
        map.getMap().setHasCentralTopic(true);
        bfs((Topic) CentralTopic.getElement(),map);


    }
    public static int brojac = 0;
    public void bfs(Topic topic, MapView map){

        for(Painter lp : map.getPainters()){
            if(lp instanceof LinkPainter && (((LinkPainter) lp).getNewLink().getFromTopic().equals(topic))){
                ((LinkPainter) lp).getNewLink().setName("" + brojac);
                    bfs(((LinkPainter) lp).getNewLink().getToTopic(),map);

            }
        }
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
        if(e.getKeyCode() == KEY_TYPED && view.getMapSelectionModel().getSelectedElements().size() != 1){
            JOptionPane.showMessageDialog(MainFrame.getInstance(),"radi");
        }
    }
}
