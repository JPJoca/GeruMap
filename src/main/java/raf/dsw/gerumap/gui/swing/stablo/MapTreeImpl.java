package raf.dsw.gerumap.gui.swing.stablo;

import lombok.Getter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.stablo.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.factory.NodeFactory;
import raf.dsw.gerumap.mapRepository.factory.SimpleFactoryUtil;

import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.Random;

import static raf.dsw.gerumap.mapRepository.factory.SimpleFactoryUtil.getFactory;

@Getter
public class MapTreeImpl implements MapTree1 {

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;
    private MapTreeItem root;
//    private NodeFactory node;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {

        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        update();
    }
    //Ovde brisem Cvorove
    @Override
    public void removeNode(MapTreeItem node) {
        if(!(node.getMapNode() instanceof MapNode))
            return;
        if(node.getParent() != null) {
            treeModel.removeNodeFromParent(node);
            ((MapNodeComposite)node.getMapNode().getParent()).deleteChild(node.getMapNode());
        }
        update();
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void update() {
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    /*Ovde se dodaju elementi na JTree proverava se sta je sta pa se dodaje*/
    private MapNode createChild(MapNode parent) {
        NodeFactory nf = getFactory(parent);
        return   nf.getNode(parent);
    }
    public void loadProject(Project node) {
        MapTreeItem loadedProject = new MapTreeItem(node);
        this.getRoot().add(loadedProject);

        MapNodeComposite mapNode = (MapNodeComposite) this.getRoot().getMapNode();
        mapNode.addChild(node);

        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }
}
