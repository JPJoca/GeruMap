package raf.dsw.gerumap.mapRepository.commadns.implementation;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class AddTopicComand extends AbstractCommand {
    private MindMap mindMap;
    private MapNode node;

    public AddTopicComand(MindMap mindMap, MapNode node) {
        this.mindMap = mindMap;
        this.node = node;
    }

    @Override
    public void doCommand() {
        if(mindMap == null) return;
        mindMap.addChild(node);
    }

    @Override
    public void undoCommand() {
        if (mindMap == null) return;
        mindMap.deleteChild(node);
    }
}
