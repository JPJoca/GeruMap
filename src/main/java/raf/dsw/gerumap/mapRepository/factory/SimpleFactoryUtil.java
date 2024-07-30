package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class SimpleFactoryUtil {

    public static ProjectFactory pf = new ProjectFactory();
    public static MindMapFactory mmf = new MindMapFactory();
    public static ElementFactory ef = new ElementFactory();

    public static NodeFactory getFactory(MapNode parent){
        if(parent instanceof ProjectExplorer)
            return pf;
        if(parent instanceof Project)
            return mmf;
        if(parent instanceof MindMap)
            return ef;
        return null;
    }
}
