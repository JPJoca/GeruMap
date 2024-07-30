package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

public abstract class NodeFactory {
     public MapNode getNode(MapNode node){
        MapNode newNode = createFactory(node);
        return newNode;
     }
    abstract MapNode createFactory(MapNode node);
}
