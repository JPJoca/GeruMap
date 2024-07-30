package raf.dsw.gerumap.gui.swing.stablo.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.tree.DefaultMutableTreeNode;

@Getter
@Setter

public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem(MapNode  model) {
        this.mapNode = model;
    }

    @Override
    public String toString() {
        return this.mapNode.getName();
    }

    public void setName(String name){
        this.mapNode.setName(name);
    }
//    public void setAuthor(String name){
//        if(this.mapNode instanceof Project){
//            ((Project) this.mapNode).setAuthor(name);
//        }
//    }
}
