package raf.dsw.gerumap.mapRepository.commadns.implementation;

import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import java.util.List;

public class DeleteElementCommand extends AbstractCommand {
    private MindMap map;
    private List<MapNode> deletePaiters;

    public DeleteElementCommand(MindMap mindMap, List<MapNode> deletePaiters) {
        this.map = mindMap;
        this.deletePaiters = deletePaiters;
    }

    @Override
    public void doCommand() {
        if (map == null) return;
        for(MapNode mapNode : deletePaiters){
            map.deleteChild(mapNode);
        }
    }

    @Override
    public void undoCommand() {
        if (map == null) return;
        for(MapNode mapNode : deletePaiters){
            map.addChild(mapNode);
        }
    }
}
