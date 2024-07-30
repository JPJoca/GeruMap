package raf.dsw.gerumap.mapRepository.factory;

import raf.dsw.gerumap.gui.swing.controleler.popup.AutorText;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{
    @Override
    public MapNode createFactory(MapNode node) {
        Project newProject = new Project("Project " + ((MapNodeComposite)node).getLastIndex(((MapNodeComposite) node).getChildren()), node, "Unnamed author", null);
        new AutorText(newProject);

        return newProject;
    }
}
