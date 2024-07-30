package raf.dsw.gerumap.gui.swing.view.painter.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;

import java.awt.*;
import java.awt.geom.Line2D;
@Getter
@Setter
public class LinkPainter extends Painter{
    private Link newLink;
    public LinkPainter(Link link) {
        this.element = link;
        this.newLink = link;
        this.setShape(new Line2D.Double(link.getStartX(), link.getStartY(), link.getEndX(), link.getEndY()));
    }

    @Override
    public void draw(Graphics2D g) {
        updateShape();
        super.draw(g);
    }

    private void updateShape() {
        this.setShape(new Line2D.Double(newLink.getStartX(), newLink.getStartY(), newLink.getEndX(), newLink.getEndY()));
    }
}
