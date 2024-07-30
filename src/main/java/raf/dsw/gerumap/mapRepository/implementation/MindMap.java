package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.mapRepository.commadns.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MindMap extends MapNodeComposite implements IPublisher {
    private boolean isPattern;
    private boolean hasCentralTopic;
    private transient List<ISubscriber> subscribers;

    public MindMap(String name, MapNode parent, boolean isPattern) {
        super(name + " ", parent);
        this.isPattern = isPattern;
//        new ProjectViewView((Project) parent, AppCore.getInstance().getMap().getProjectExplorer(), this);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.notifySubscriber(this, name);
    }

    @Override
    public int getLastIndex(List<MapNode> children) {
        return super.getLastIndex(children);
    }

    @Override
    public void deleteChild(MapNode child) {
        if(!(child instanceof Element))
            return;
        super.deleteChild(child);
        this.notifySubscriber(child, "delete");
    }

    @Override
    public void addChild(MapNode node) {
        if(node instanceof Element && node != null){
            Element e = (Element) node;
            if(!this.getChildren().contains(e)){
                this.getChildren().add(e);
                this.notifySubscriber(node, "add");
            }
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

    public void setHasCentralTopic(boolean hasCentralTopic) {
        this.hasCentralTopic = hasCentralTopic;
    }
}
