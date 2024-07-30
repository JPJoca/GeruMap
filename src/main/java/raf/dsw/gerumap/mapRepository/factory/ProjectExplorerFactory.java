package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class ProjectExplorerFactory extends NodeFactory{
    @Override
    public MapNode createFactory(MapNode node) {
        return new ProjectExplorer("Project Explorer");
    }
}
