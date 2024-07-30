package raf.dsw.gerumap.gui.swing.controleler.stateActions;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FillAction extends AbstractGerumapAction {

   public  FillAction(){
       putValue(SMALL_ICON, block(Color.cyan));
       putValue(NAME, "Fill element");
       putValue(SHORT_DESCRIPTION, "Fill element");
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectViewView().startFillState();
        Color c =MainFrame.getInstance().settColor();
        putValue(SMALL_ICON, block(c));
    }
}
