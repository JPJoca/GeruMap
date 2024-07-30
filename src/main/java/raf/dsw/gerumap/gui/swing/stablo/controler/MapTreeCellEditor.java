package raf.dsw.gerumap.gui.swing.stablo.controler;

import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.stablo.view.MapTreeCellRenderer;
import raf.dsw.gerumap.gui.swing.stablo.view.MapTreeView;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn = null;
    private JTextField edit = null;
    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0,arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5){
        clickedOn = arg1;
        edit = new JTextField((arg1.toString()));
        edit.addActionListener(this);
        return edit;
    }
    public boolean isCellEditable(EventObject arg1){
        if(arg1 instanceof MouseEvent) {
            if (((MouseEvent) arg1).getClickCount() == 3) {
                System.out.println("");
                return true;
            }
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(clickedOn instanceof MapTreeItem))
            return;
        MapTreeItem clicked = (MapTreeItem) clickedOn;
        if(clicked.getMapNode() instanceof MindMap) clicked.getMapNode().setName(e.getActionCommand());
        clicked.setName(e.getActionCommand());
    }
}
