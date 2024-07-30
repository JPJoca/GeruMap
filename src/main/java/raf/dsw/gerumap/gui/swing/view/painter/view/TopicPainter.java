package raf.dsw.gerumap.gui.swing.view.painter.view;

import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TopicPainter extends Painter{
    private Topic newTopic;
    public TopicPainter(Topic element) {
        this.element = element;
        this.newTopic = element;
        this.setShape(new Ellipse2D.Double(element.getX() - 50, element.getY() - 50, 100,60));
    }

    @Override
    public void draw(Graphics2D g) {
        updateShape();
        super.draw(g);


        int a  = ((Topic) element).getX();
        int b = ((Topic) element).getY();

        String text = element.getName();
        FontMetrics metrics = g.getFontMetrics();

        int x = a - metrics.stringWidth(text)/2;
        int y = b - metrics.getHeight()/2 - metrics.getAscent()/2;
        g.setColor(Color.black);
        g.drawString(text, x, y);

    }

    private void updateShape() {
        this.setShape(new Ellipse2D.Double(newTopic.getX() - 50, newTopic.getY() - 50, 100,60));
    }
}
