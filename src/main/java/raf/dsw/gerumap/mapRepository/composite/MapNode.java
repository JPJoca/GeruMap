package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MapNode {
    protected transient MapNode parent;
    protected String name;

    public MapNode(String name, MapNode parent) {
       this.parent = parent;
        this.name = name;
    }


    public void setName(String name){
        this.name = name;
    }

}
