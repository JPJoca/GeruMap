package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.controleler.popup.NameBox;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.view.painter.view.TopicPainter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.AddTopicComand;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class AddTopicState implements State {

    public void misKliknut(MapView mapView, int x, int y, int clickCount){
        mapView.getMapSelectionModel().removeAllElemets();
        for(Painter painter: mapView.getPainters()){
            if(painter.elementAt(x,y)) {
                AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_ADD_TOPIC);
                return;
            }
        }
        Topic topic = new Topic("Topic",
                MainFrame.getInstance().getProjectViewView().getMindMap(), x, y, 100, 60);
        topic.addSubscriber(mapView);
        new NameBox(topic,mapView);
        for(Painter painter1 : mapView.getPainters()){
            if(painter1.elementAt(x, y) && painter1.getShape().contains(x, y))
                return;
        }

        AbstractCommand command = new AddTopicComand(mapView.getMap(), topic);
        AppCore.getInstance().getGui().getCommandManager().addCommand(command);
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
