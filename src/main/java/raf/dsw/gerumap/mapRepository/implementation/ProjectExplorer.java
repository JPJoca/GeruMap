package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class ProjectExplorer extends MapNodeComposite implements IPublisher {

    private transient List<ISubscriber> subscribers;

    public ProjectExplorer(String name) {
        super(name,null);
        super.getChildren();
    }

    @Override
    public void addChild(MapNode node) {
        if(node instanceof Project && node != null){
            Project project = (Project) node;
                if(!this.getChildren().contains(project)){
                    this.getChildren().add(project);
                    this.setParent(this);
                }
        }
    }

    @Override
    public int getLastIndex(List<MapNode> children) {
        return super.getLastIndex(children);
    }

    @Override
    public void deleteChild(MapNode child) {
        if(!(child instanceof Project))
            return;
        super.deleteChild(child);
        this.notifySubscriber(this, child);
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
