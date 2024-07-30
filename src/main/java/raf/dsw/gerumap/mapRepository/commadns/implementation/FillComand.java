package raf.dsw.gerumap.mapRepository.commadns.implementation;

import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import java.awt.*;

public class FillComand extends AbstractCommand {

    private MindMap map;
    private Topic topic;
    private Color prevColor;
    private Color currColor;

    public FillComand(MindMap map, Topic topic, Color prevColor, Color currColor) {
        this.map = map;
        this.topic = topic;
        this.prevColor = prevColor;
        this.currColor = currColor;
    }

    @Override
    public void doCommand() {
        for(MapNode element : map.getChildren()){
            if(topic.equals(element))
                topic.setColor(currColor);
        }
    }

    @Override
    public void undoCommand() {
        for(MapNode element : map.getChildren()){
            if(topic.equals(element))
                topic.setColor(prevColor);
        }
    }
}
