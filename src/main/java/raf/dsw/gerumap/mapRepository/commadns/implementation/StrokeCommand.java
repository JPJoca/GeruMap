package raf.dsw.gerumap.mapRepository.commadns.implementation;

import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class StrokeCommand extends AbstractCommand {

    private MindMap map;
    private Topic topic;
    private int currStroke;
    private int prevStroke;

    public StrokeCommand(MindMap map, Topic topic, int currStroke, int prevStroke) {
        this.map = map;
        this.topic = topic;
        this.currStroke = currStroke;
        this.prevStroke = prevStroke;
    }

    @Override
    public void doCommand() {
        for(MapNode element : map.getChildren()){
            if(topic.equals(element))
                topic.setStroke(currStroke);
        }
    }

    @Override
    public void undoCommand() {
        for (MapNode element : map.getChildren()){
            if(topic.equals(element))
                topic.setStroke(prevStroke);
        }

    }
}
