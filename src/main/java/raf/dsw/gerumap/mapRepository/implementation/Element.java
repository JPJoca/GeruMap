

package raf.dsw.gerumap.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeLeaf;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Element extends MapNodeLeaf implements IPublisher{
    private transient Color color;
    private int stroke;
    private transient List<ISubscriber> subscribers;
    private int colorSeter;

    public Element(String name,MapNode parent) {
        super(name,parent);
        this.subscribers = new ArrayList<>();
        setColor();
        this.stroke = 2;


    }
    public Element(String name,MapNode parent, int stroke, int colorSeter) {
        super(name,parent);
        this.subscribers = new ArrayList<>();
        this.color = new Color(colorSeter,true);
        System.out.println(colorSeter);
        this.stroke = stroke;
    }

    private void setColor() {
        color = new Color(25,189,255);
        colorSeter = color.getRGB();
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
    public void setStroke(int stroke){
        this.stroke = stroke;
        this.notifySubscriber(stroke,null);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.notifySubscriber(name,null);
    }
}