package raf.dsw.gerumap.gui.swing.stablo.view;

import lombok.NoArgsConstructor;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

@NoArgsConstructor
public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree,value,sel,expanded,leaf,row,hasFocus);
        URL imageURL = null;

        if(((MapTreeItem)value).getMapNode() instanceof ProjectExplorer){
            imageURL = getClass().getResource("/img/pex.png");
        }
        else if(((MapTreeItem)value).getMapNode() instanceof Project){
            imageURL = getClass().getResource("/img/proj.png");
        }
        else if(((MapTreeItem)value).getMapNode() instanceof MindMap){
            imageURL = getClass().getResource("/img/map.png");
        }
        else if(((MapTreeItem)value).getMapNode() instanceof Element){
            imageURL = getClass().getResource("/img/e.png");
        }
        Icon icon = null;
        if(imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);

        return this;
    }
}
