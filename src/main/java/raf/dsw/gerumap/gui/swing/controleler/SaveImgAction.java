package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveImgAction extends AbstractGerumapAction{

    public SaveImgAction() {
        putValue(SMALL_ICON, loadicon("/img/imgIcon.png"));
        putValue(NAME, "Save as img");
        putValue(SHORT_DESCRIPTION, "Save as img");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapView mapView = null;
        MindMap mindMap;

        try{
             mindMap = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        }catch (Exception d) {
            AppCore.getInstance().getMessageGenerator().generate(EventType.SAVE_SELECT);
            return;
        }
        for (MapView view : MainFrame.getInstance().getProjectViewView().getMapViewList()) {

            if(view.getMap().equals(mindMap))
                mapView = view;
        }

        if(mindMap.equals(null))
            AppCore.getInstance().getMessageGenerator().generate(EventType.SAVE_SELECT);

        JFileChooser jFileChooser = new JFileChooser();
        File file = null;
        BufferedImage image = new BufferedImage(mapView.getWidth(), mapView.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        mapView.fillPainter();
        mapView.printAll(g2);
        try{
            if(jFileChooser.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION){
                file = jFileChooser.getSelectedFile();
                ImageIO.write(image, "PNG", file);
            }
        } catch (IOException ee) {
            ee.printStackTrace();
        }
    }
}
