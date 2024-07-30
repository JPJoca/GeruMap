package raf.dsw.gerumap.mapRepository.commadns.implementation;

import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import java.awt.*;
import java.util.List;

public class MoveElementCommand extends AbstractCommand {
    private List<Point> originalPoints, finalPoints;
    private List<Element> selectedElements;
    private MindMap mindMap;
    private int numOfSeleceted;

    public MoveElementCommand(Point finalPoint, MindMap mindMap, List<Point> originalPoints, List<Point> finalPoints, int numOfSeleceted, List<Element> selectedElements) {
        this.mindMap = mindMap;
        this.selectedElements = selectedElements;
        this.originalPoints = originalPoints;
        this.finalPoints = finalPoints;
        this.finalPoints.add(finalPoint);
        this.numOfSeleceted = numOfSeleceted;
    }

    @Override
    public void doCommand() {
        int cnt = numOfSeleceted;
        for(Element element : selectedElements){
            int x = (int) (finalPoints.get(finalPoints.size() - 1 - cnt)).getX();
            int y =  (int) (finalPoints.get(finalPoints.size() - 1 - cnt--)).getY();
            if(element instanceof Topic){
                Topic topic = (Topic) element;
                topic.setX(x);
                topic.setY(y);

                for(MapNode mapNode : mindMap.getChildren()){
                    if(mapNode instanceof Link) {
                        Link link = (Link) mapNode;
                        if ((((Link) mapNode).getFromTopic().compare(topic))) {
                            link.setStartX(x);
                            link.setStartY(y);
                        }else if ((((Link) mapNode).getToTopic().compare(topic))) {
                            link.setEndX(x);
                            link.setEndY(y);
                        }
                    }
                }
            }
        }

    }

    @Override
    public void undoCommand() {
        int cnt = 0;
        for(Element element : selectedElements){
            if(element instanceof Topic){
                Topic topic = (Topic) element;
                topic.setX((int) originalPoints.get(cnt).getX());
                topic.setY((int) originalPoints.get(cnt++).getY());

                for(MapNode mapNode : mindMap.getChildren()){
                    if(mapNode instanceof Link) {
                        Link link = (Link) mapNode;
                        int xx = topic.getX();
                        int yy = topic.getY();
                        if (link.getFromTopic().compare(topic)){
                            link.setStartX(xx);
                            link.setStartY(yy);
                        }
                        if (link.getToTopic().compare(topic)) {
                            link.setEndX(xx);
                            link.setEndY(yy);
                        }
                    }
                }
            }
        }

    }
}
