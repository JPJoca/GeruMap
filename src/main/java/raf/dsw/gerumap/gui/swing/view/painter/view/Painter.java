package raf.dsw.gerumap.gui.swing.view.painter.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Rectangle;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;

import java.awt.*;

@Getter
@Setter
public abstract class Painter {
    protected Element element;
    protected Shape shape;

    public Painter() {

    }

    public void draw(Graphics2D g){
        if(element instanceof Topic) {
            if (((Topic) element).isSelected()) {
                g.setColor(Color.RED);
                g.setStroke(new BasicStroke(element.getStroke() + 3));
                g.draw(shape);
            } else {
                g.setColor(Color.black);
                g.setStroke(new BasicStroke(element.getStroke() ));
                g.draw(shape);
            }
            g.setPaint(element.getColor());
            g.fill(shape);
        }else if(element instanceof Link) {
                g.draw(shape);
        }else if(element instanceof Rectangle){
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1));
            this.shape = ((Rectangle) element).getShape();
            try {
                g.setStroke(new BasicStroke(1));
                g.draw((((Rectangle) element).getShape()));
            } catch (Exception e) {

            }

        }
    }

    public boolean elementAt(int x, int y){
        if(shape != null) return shape.contains(x, y);
            return false;
    }
}
