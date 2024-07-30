package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.view.painter.view.TopicPainter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.AddLinkCommad;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;

public class AddLinkState implements State {
    private Link link;
    private boolean bool = false;
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        map.getMapSelectionModel().removeAllElemets();
        for(Painter painter : map.getPainters()){
            if(painter.elementAt(x, y) && painter instanceof TopicPainter) {
                bool = true;
                Topic topic = (Topic) painter.getElement();
                link = new Link("", map.getMap(), topic, null);

                Painter painter1 = new LinkPainter(link);
                map.addPainter(painter1);
                map.getMap().addChild(link);
                break;
            }
        }
        if(bool == false)
            AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_ADD_LINK);
    }
    @Override
    public void misPovucen(MapView map, int x, int y) {
        if(bool) {
            map.removePainters();
            link.setEndX(x);
            link.setEndY(y);
            Painter painter = new LinkPainter(link);
            map.addPainter(painter);
        }
    }
    @Override
    public void misPusten(MapView map, int x, int y) {
        for(Painter painter1 : map.getPainters()){
            if(painter1.elementAt(x, y) && painter1 instanceof TopicPainter && bool) {
                Topic topic = (Topic) painter1.getElement();
                map.removePainters();
                link.setEndX(topic.getX());
                link.setEndY(topic.getY());
                link.setToTopic(topic);
                AbstractCommand command = new AddLinkCommad(map.getMap(), link);
                AppCore.getInstance().getGui().getCommandManager().addCommand(command);
                link.addSubscriber(map);
                bool = false;
                return;
            }
        }
        if(link.getToTopic() == null) {
            map.getMap().deleteChild(link);
            map.removePainters();
            AppCore.getInstance().getMessageGenerator().generate(EventType.CANT_ADD_LINK);
            bool = false;
            link = null;
        }
    }

    @Override
    public void dugmeKliknuto(MapView view, KeyEvent e) {

    }
}
