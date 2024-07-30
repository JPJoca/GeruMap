package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Element;

public class ElementFactory extends NodeFactory{
    @Override
    MapNode createFactory(MapNode node) {
        return new Element("Element " + ((MapNodeComposite)node).getLastIndex(((MapNodeComposite) node).getChildren()), node);
    }
}
