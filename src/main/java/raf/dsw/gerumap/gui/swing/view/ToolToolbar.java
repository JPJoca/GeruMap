package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;

public class ToolToolbar extends JToolBar {
    public ToolToolbar(){
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionMenager().getAddTopicAction());
        add(MainFrame.getInstance().getActionMenager().getAddLinkAction());
        add(MainFrame.getInstance().getActionMenager().getSetCentralTopicAction());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getFillAction());
        add(MainFrame.getInstance().getActionMenager().getDeleteElementAction());
        add(MainFrame.getInstance().getActionMenager().getStrokeAction());
        add(MainFrame.getInstance().getActionMenager().getRenameAction());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getSelectAction());
        add(MainFrame.getInstance().getActionMenager().getLasoSelectionAction());
        add(MainFrame.getInstance().getActionMenager().getMoveElementAction());
        addSeparator();
        add(MainFrame.getInstance().getActionMenager().getZoomAction());
        add(MainFrame.getInstance().getActionMenager().getZoomOutAction());
    }
}
