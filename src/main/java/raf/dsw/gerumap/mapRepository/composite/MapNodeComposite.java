package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public abstract class MapNodeComposite extends MapNode {
    private List<MapNode> children;
    
    public MapNodeComposite(String name, MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    public void addChild(MapNode node) {
        if (node != null)
            this.children.add(node);
    }


    public void deleteChild(MapNode child) {
        if(child == null || this.children == null || this.children.isEmpty() || !this.children.contains(child))
            return;
        child.setParent(null);
        this.children.remove(child);
    }

    public  int getLastIndex(List<MapNode> children){
        return children.size()+1;
    }
}


