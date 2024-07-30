package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionMenager().getRename());
        add(MainFrame.getInstance().getActionMenager().getNewProjectAction());
        add(MainFrame.getInstance().getActionMenager().getDelete());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getSetAutor());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getUndoAction());
        add(MainFrame.getInstance().getActionMenager().getRedoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getLoadAction());
        add(MainFrame.getInstance().getActionMenager().getSaveAction());
        add(MainFrame.getInstance().getActionMenager().getSaveImgAction());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getTemplateAction());
        add(MainFrame.getInstance().getActionMenager().getNewInfoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getExitAction());
    }

}
