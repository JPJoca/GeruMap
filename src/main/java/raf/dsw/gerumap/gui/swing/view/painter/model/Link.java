package raf.dsw.gerumap.gui.swing.view.painter.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;

@Getter
@Setter
public class Link extends Element {

    private Topic fromTopic;
    private Topic toTopic;
    int startX, startY;
    int endX, endY;


    public Link(String name, MapNode parent, Topic fromTopic, Topic toTopic) {
        super(name, parent);
        this.fromTopic = fromTopic;
        this.toTopic = toTopic;
        makeXY();
    }

    private void makeXY() {
        if(fromTopic != null) {
            this.startX = fromTopic.getX();
            this.startY = fromTopic.getY();
        }else if(toTopic != null){
            this.startX = toTopic.getX();
            this.startY = toTopic.getY();
        }else{
            this.startX = 0;
            this.startY = 0;
        }

        if(toTopic != null){
            this.endX = toTopic.getX();
            this.endY = toTopic.getY();
        }else if(fromTopic != null){
            this.endX = fromTopic.getX();
            this.endY = fromTopic.getY();
        }else{
            this.endX = 0;
            this.endY = 0;
        }
    }

    public void setStartX(int startX) {
        this.startX = startX;
        this.notifySubscriber(startX, "Link");
    }

    public void setStartY(int startY) {
        this.startY = startY;
        this.notifySubscriber(startY, "Link");
    }

    public void setEndX(int endX) {
        this.endX = endX;
        this.notifySubscriber(endX, "Link");
    }

    public void setEndY(int endY) {
        this.endY = endY;
        this.notifySubscriber(endY, "Link");
    }

    public boolean compare(Link link){
        if(this.startX == link.startX && this.startY == link.startY && this.endX == link.endX && this.endY == link.endY){
            return true;
        }
        return false;
    }
}
