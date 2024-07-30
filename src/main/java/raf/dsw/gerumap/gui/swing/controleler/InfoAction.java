package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.gui.swing.controleler.popup.DialogBox;
import raf.dsw.gerumap.gui.swing.stablo.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractGerumapAction {

    public InfoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON,loadicon("/img/info.png"));
        putValue(NAME,"Info");
        putValue(SHORT_DESCRIPTION,"Informacije o autoru");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new DialogBox().pokazi();
    }
}
