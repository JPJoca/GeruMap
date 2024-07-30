package raf.dsw.gerumap.gui.swing.stablo;

import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.stablo.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public interface MapTree1 {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    void removeNode(MapTreeItem node);
    MapTreeItem getSelectedNode();
    void update();

    void loadProject(Project p);
}
