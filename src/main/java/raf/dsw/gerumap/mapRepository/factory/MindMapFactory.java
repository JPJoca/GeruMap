package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class MindMapFactory extends NodeFactory{
    @Override
    public MapNode createFactory(MapNode node) {
        return new MindMap("MindMap " + ((MapNodeComposite)node).getLastIndex(((MapNodeComposite) node).getChildren()),node,false);
    }
}
