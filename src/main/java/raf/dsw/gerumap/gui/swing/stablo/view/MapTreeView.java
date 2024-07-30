package raf.dsw.gerumap.gui.swing.stablo.view;

import raf.dsw.gerumap.gui.swing.stablo.controler.MapTreeCellEditor;
import raf.dsw.gerumap.gui.swing.stablo.controler.MapTreeSelectionListener;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {

    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        MapTreeCellRenderer rutTreeCellRenderer = new MapTreeCellRenderer();
        addTreeSelectionListener(new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, rutTreeCellRenderer));
        setCellRenderer(rutTreeCellRenderer);
        setEditable(true);
    }
}
