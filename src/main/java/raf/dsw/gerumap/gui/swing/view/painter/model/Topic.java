package raf.dsw.gerumap.gui.swing.view.painter.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.awt.*;

@Getter
@Setter
public class Topic extends Element {
    private int x, y;
    private int width, height;
    private boolean isSelected;
    private boolean isCenter = false;


    public Topic(String name, MapNode parent,  int x, int y, int width, int height) {
        super(name, parent);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isSelected = false;
    }

    public Topic(String name, MapNode parent, int stroke, int colorSeter, int x, int y, int width, int height) {
        super(name, parent, stroke, colorSeter);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean compare(Topic topic) {
        if(this.x == topic.getX() && this.y == topic.getY())
            return true;
        return false;
    }

    public void setX(int x) {
        this.x = x;
        super.notifySubscriber(x, "Topic");
    }

    public void setY(int y){
        this.y = y;
        super.notifySubscriber(y, "Topic");
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
        super.setColorSeter(color.getRGB());
        this.notifySubscriber(color,null);
    }

    @Override
    public void setStroke(int stroke) {
        super.setStroke(stroke);
        this.notifySubscriber(null,null);
    }

}
