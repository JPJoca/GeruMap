package raf.dsw.gerumap.gui.swing.stablo.controler;

import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MapTreeSelectionListener extends MouseAdapter implements TreeSelectionListener{
    private TreePath path;
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        path = e.getPath();
        MapTreeItem mapTreeItemSeleced = (MapTreeItem) path.getLastPathComponent();
//        System.out.println("Cvor je : " + mapTreeItemSeleced.getMapNode().getName());
//        System.out.println("Putanja je : " + e.getPath());
//        if (mapTreeItemSeleced.getMapNode() instanceof Project) {
//            for(MapNode node : ((Project) mapTreeItemSeleced.getMapNode()).getChildren()){
////                System.out.println(((MindMap)node).getName());
//            }
//        }
    }
}
