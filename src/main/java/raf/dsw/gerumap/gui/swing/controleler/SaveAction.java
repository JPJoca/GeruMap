package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.messageGenerator.EventType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class SaveAction extends AbstractGerumapAction{
    public SaveAction(){
        putValue(SMALL_ICON, loadicon("/img/saveIcon.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        try{
            MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        }catch (NullPointerException d) {
            AppCore.getInstance().getMessageGenerator().generate(EventType.SAVE_PROJECT);
            return;
        }
        if (!(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) {
            AppCore.getInstance().getMessageGenerator().generate(EventType.SAVE_PROJECT);
            return;
        }

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }

        if (project.getPath() == null || project.getPath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setPath(projectFile.getPath());
            } else {
                return;
            }

        }

        AppCore.getInstance().getSerializer().saveProject(project);


        project.setChanged(false);
    }
}
