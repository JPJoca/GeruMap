package raf.dsw.gerumap.gui.swing.projectView.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.view.painter.view.TopicPainter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class MapSelectionModel implements IPublisher {
    private List<Painter> selectedElements;
    private List<ISubscriber> subscribers;

    public MapSelectionModel() {
        this.selectedElements = new ArrayList<>();
    }

    public void addSelectedElement(Painter painter){
        this.selectedElements.add(painter);
        ((Topic) painter.getElement()).setSelected(true);
        this.notifySubscriber(this, null);
    }

    public void removeAllElemets(){
        for(Painter p : selectedElements){
            if(p instanceof TopicPainter){
                ((Topic)p.getElement()).setSelected(false);
            }
        }
        this.selectedElements.removeAll(this.selectedElements);
        this.notifySubscriber(null, null);
    }

    public void removeSelectedElement(Painter painter){
        this.selectedElements.remove(painter);
        if(painter instanceof TopicPainter)
            ((Topic) painter.getElement()).setSelected(false);

        notifySubscriber(this, null);
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

