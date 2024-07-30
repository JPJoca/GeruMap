package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class Project extends MapNodeComposite implements IPublisher {
    private String author, path;

    private transient List<ISubscriber> subscribers;

    protected boolean changed = true;

    public Project(String name,MapNode parent, String author, String path) {
        super(name,parent);
        this.author = author;
        this.path = path;
    }

    public void renameAuthor(String author){
        this.author = author;
        changed = true;
        this.notifySubscriber(this, name);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed = true;
        this.notifySubscriber(this, name);
    }

    public String getAuthor() {
        changed = true;
        return author;
    }

    @Override
    public int getLastIndex(List<MapNode> children) {
        return super.getLastIndex(children);
    }

    @Override
    public void deleteChild(MapNode child) {
        if(!(child instanceof MindMap))
            return;
        super.deleteChild(child);
        this.notifySubscriber(this, child);
        changed = true;
    }

    @Override
    public void addChild(MapNode node) {
        if(node instanceof MindMap && node != null){
            MindMap mapa = (MindMap) node;
            if(!this.getChildren().contains(mapa)){
                this.getChildren().add(mapa);
                this.notifySubscriber(this, node);
            }
            changed = true;
        }
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification, Object typeOfUpdate) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber subs : subscribers){
            subs.update(notification, typeOfUpdate);
        }
    }
}
