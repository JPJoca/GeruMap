package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class LoadAction extends AbstractGerumapAction{
    public LoadAction(){
        putValue(SMALL_ICON, loadicon("/img/loadIcon.png"));
        putValue(NAME, "Load Project");
        putValue(SHORT_DESCRIPTION, "Load project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            ProjectExplorer p = (ProjectExplorer) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        }catch (Exception d){
            AppCore.getInstance().getMessageGenerator().generate(EventType.LOAD);
            return;
        }
        JFileChooser jfc = new JFileChooser();

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                Project p = AppCore.getInstance().getSerializer().loadProject(file);
                MainFrame.getInstance().getMapTree().loadProject(p);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
}
