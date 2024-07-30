package raf.dsw.gerumap.gui.swing.view.painter.view;

import raf.dsw.gerumap.gui.swing.view.painter.model.Rectangle;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectanglePainter extends Painter{
    private Rectangle newRectangle;
    public RectanglePainter(Rectangle rectangle) {
        element = rectangle;
        this.newRectangle = rectangle;
        this.setShape(rectangle.getShape());
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);

        updateShape();
    }

    private void updateShape() {
        this.setShape(new Rectangle2D.Double(newRectangle.getStartX(), newRectangle.getStartY(), newRectangle.getWidth(),
                newRectangle.getHeight()));
    }
}
