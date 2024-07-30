package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class TemplateListener extends MouseAdapter {
    private String name;
    private JDialog pane;

    public TemplateListener(String name, JDialog pane) {
        this.name = name;
        this.pane = pane;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.name.equals("1")){
            Project p = AppCore.getInstance().getSerializer().loadProject(new File("src/main/resources/json/1.json"));
            MainFrame.getInstance().getMapTree().loadProject(p);
            pane.dispose();
        }else if(this.name.equals("2")){
            Project p = AppCore.getInstance().getSerializer().loadProject(new File("src/main/resources/json/2.json"));
            MainFrame.getInstance().getMapTree().loadProject(p);
            pane.dispose();
        }else if(this.name.equals("3")){
            Project p = AppCore.getInstance().getSerializer().loadProject(new File("src/main/resources/json/3.json"));
            MainFrame.getInstance().getMapTree().loadProject(p);
            pane.dispose();
        }else if(this.name.equals("4")){
            Project p = AppCore.getInstance().getSerializer().loadProject(new File("src/main/resources/json/4.json"));
            MainFrame.getInstance().getMapTree().loadProject(p);
            pane.dispose();
        }
    }
}
