package raf.dsw.gerumap.gui.swing.state.concrete;


import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.view.painter.view.TopicPainter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.MoveElementCommand;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MoveElementState implements State {
    private List<Point> points = new ArrayList<>();
    private List<Point> originalPoints = new ArrayList<>();
    private List<Point> finalPoints = new ArrayList<>();
    private List<Element> selectedElements = new ArrayList<>();
    private boolean bool = false;
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        finalPoints.removeAll(finalPoints);
        originalPoints.removeAll(originalPoints);
        selectedElements.removeAll(selectedElements);
        if(map.getMapSelectionModel().getSelectedElements().isEmpty())
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT_BEFORE_MOVE);
        for(Painter p : map.getPainters()){
            if(p.elementAt(x, y)){
                bool = true;
                break;
            }
        }

        if(!bool) return;
        points.add(new Point(x , y));
        for(Painter painter : map.getMapSelectionModel().getSelectedElements()){
            if(painter instanceof TopicPainter)
                originalPoints.add(new Point(((Topic)painter.getElement()).getX(), ((Topic)painter.getElement()).getY()));
            selectedElements.add(painter.getElement());
        }
        bool = false;
    }

    @Override
    public void misPovucen(MapView map, int x, int y) {
        Point point = new Point(x ,y);
        points.add(point);
        if(points.size() < 3) return;

        for(Painter painter : map.getMapSelectionModel().getSelectedElements()){
            if(painter instanceof TopicPainter){
                Topic topic = (Topic) painter.getElement();
                Topic provera = (Topic) painter.getElement();
                topic.setX(topic.getX() - (int)((points.get(points.size() - 2).getX()) -
                        (points.get(points.size() - 1).getX())));
                topic.setY(topic.getY() - (int)((points.get(points.size() - 2).getY()) -
                        (points.get(points.size() - 1).getY())));
                finalPoints.add(new Point(topic.getX() - (int)((points.get(points.size() - 2).getX()) -
                        (points.get(points.size() - 1).getX())), topic.getY() - (int)((points.get(points.size() - 2).getY()) -
                        (points.get(points.size() - 1).getY()))));
                System.out.println(topic);
                for(Painter p : map.getPainters()){
                    if(p.getElement() instanceof Link) {

                        Link link = (Link) p.getElement();
                        int xx = topic.getX() - (int) ((points.get(points.size() - 2).getX()) -
                                (points.get(points.size() - 1).getX()));
                        int yy = topic.getY() - (int) ((points.get(points.size() - 2).getY()) -
                                (points.get(points.size() - 1).getY()));

                        System.out.println(((Link) p.getElement()).getFromTopic());
                        //(((Link) p.getElement()).getFromTopic().compare(topic))
                        if (p instanceof LinkPainter && (((Link) p.getElement()).getFromTopic().compare((Topic) painter.getElement()))) {
                            link.setStartX(xx);
                            link.setStartY(yy);
                            System.out.println("PRVI IF");
                        }
                        if (p instanceof LinkPainter && (((Link) p.getElement()).getToTopic().compare((Topic) painter.getElement()))) {
                            link.setEndX(xx);
                            link.setEndY(yy);
                            System.out.println("DRUGI IF");

                        }
                    }
                }
            }
        }
        bool = false;
    }

    @Override
   public void misPusten(MapView map, int x, int y) {
        AbstractCommand command = new MoveElementCommand(new Point(x, y), map.getMap(), originalPoints, finalPoints,
                map.getMapSelectionModel().getSelectedElements().size(), selectedElements);
        AppCore.getInstance().getGui().getCommandManager().addCommand(command);
        bool = false;
    }

    @Override
    public void dugmeKliknuto(MapView view, KeyEvent e) {

    }
}
