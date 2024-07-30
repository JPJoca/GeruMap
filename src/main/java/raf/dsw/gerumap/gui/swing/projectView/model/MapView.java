package raf.dsw.gerumap.gui.swing.projectView.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controleler.KeyboardController;
import raf.dsw.gerumap.gui.swing.controleler.MouseController;
import raf.dsw.gerumap.gui.swing.controleler.MouseMotion;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.commadns.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.gui.swing.view.painter.view.RectanglePainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.TopicPainter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapView extends JPanel implements ISubscriber {
    private MindMap map;
    private List<Painter> painters;
    private MapSelectionModel mapSelectionModel;
    private int width, height;
    private AffineTransform t = new AffineTransform();


    double ScalingFactor = 1, prevScalingFactor = 1, xPom = 0, yPom = 0;


    public MapView(MindMap map){
        this.map = map;
        this.width = 2000;
        this.height = 2000;
        this.painters = new ArrayList<>();
        this.mapSelectionModel = new MapSelectionModel();
        if(map != null) {
            this.map.addSubscriber(this);
        }

        this.mapSelectionModel.addSubscriber(this);
        this.addMouseListener(new MouseController(this));
        this.addMouseMotionListener(new MouseMotion(this));
        this.addKeyListener(new KeyboardController(this));

    }


    public void setScaleForZoom(double ScalingFactor){
        t = new AffineTransform();


        this.ScalingFactor = ScalingFactor;

        double Pom = ScalingFactor / this.prevScalingFactor;

        double height = getHeight();
        double width = getWidth();
        
        this.setPreferredSize(new Dimension((int) (width * ScalingFactor), (int) (height * ScalingFactor)));
        this.xPom = Pom * xPom + (1 - Pom);
        this.yPom = Pom * yPom + (1 - Pom);

        t.translate(xPom, yPom);
        t.scale(ScalingFactor, ScalingFactor);
        this.prevScalingFactor = ScalingFactor;

        repaint();
    }


    public void removePainters(){
        int index = this.painters.size() - 1;
        painters.remove(index);
        repaint();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
            if(t != null)
            g2.transform(t);

        for(Painter p : painters){
            if(p instanceof LinkPainter || p instanceof RectanglePainter){
                p.draw(g2);
            }
        }

        for(Painter p : painters){
            if(p instanceof TopicPainter) {
                if (getMapSelectionModel().getSelectedElements().contains(p)) {
                    p.draw(g2);
                } else {
                    p.draw(g2);
                }
            }
        }
    }
    @Override
    public void update(Object notification, Object typeOfUpdate) {
        if(typeOfUpdate == null){
            repaint();
            this.setPreferredSize(getSize());
        }else if (typeOfUpdate.equals("add")){
            if(notification instanceof Topic){
                Painter painter = new TopicPainter((Topic)notification);
                this.getPainters().add(painter);
            }else if(notification instanceof Link){
                Painter painter = new LinkPainter((Link)notification);
                this.getPainters().add(painter);
            }
        }else if(typeOfUpdate.equals("delete")){
            if(notification instanceof Topic){
                for(Painter painter : painters){
                    if(painter instanceof TopicPainter && ((Topic)painter.getElement()).compare((Topic) notification)){
                        this.getPainters().remove(painter);
                        break;
                    }
                }
            }else if(notification instanceof Link) {
                for (Painter painter : painters) {
                    if (painter instanceof LinkPainter && ((Link) painter.getElement()).compare((Link) notification)) {
                        this.getPainters().remove(painter);
                        break;
                    }
                }
            }

        }
        repaint();
        this.setPreferredSize(getSize());
    }

    public void addPainter(Painter painter){
        this.painters.add(painter);
        repaint();
    }

    public void fillPainter(){


        for(MapNode element : map.getChildren()){

            if(element instanceof Topic){
                ((Topic)element).addSubscriber(this);
                Painter painter = new TopicPainter(((Topic)element));
                this.addPainter(painter);
            }else if(element instanceof Link){
                ((Link)element).addSubscriber(this);
                Painter painter = new LinkPainter(((Link)element));
                this.addPainter(painter);
            }
        }
    }



}