package raf.dsw.gerumap.gui.swing.view.painter.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class Rectangle extends Element{
    private int width, height;
    private int startX, startY, endX, endY;
    private Shape shape;

    public Rectangle(String name, MapNode parent, int startX, int startY, int endX, int endY) {
        super(name, parent);
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
       // makeDimensions(endX, endY);
    }

    public void makeDimensions(int x, int y) {
        int X = startX, Y = startY;
        if (x > X && y > Y) shape = new Rectangle2D.Double( X,  Y,  x-X,  y-Y);
        else if (x < X && y < Y) shape = new Rectangle2D.Double( x,  y,  X-x,  Y-y);
        else if (x > X && y < Y)  shape = new Rectangle2D.Double( X,  y,  x-X,  Y-y);
        else if (x < X && y > Y)  shape = new Rectangle2D.Double( x,  Y,  X-x,  y-Y);

        this.notifySubscriber(null, null);
    }
}
