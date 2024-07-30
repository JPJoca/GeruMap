package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){

        JMenu fileMenu = new JMenu("File:");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        //ovo je za dodavanje akcine new projecr
        fileMenu.add(MainFrame.getInstance().getActionMenager().getNewProjectAction());
        // ovo je za dodavanje akcije rename
        fileMenu.add(MainFrame.getInstance().getActionMenager().getRename());
        // delete akcija
        fileMenu.add(MainFrame.getInstance().getActionMenager().getDelete());
        fileMenu.addSeparator();
        fileMenu.add(MainFrame.getInstance().getActionMenager().getSetAutor());
        fileMenu.addSeparator();
        // exite action
        fileMenu.add(MainFrame.getInstance().getActionMenager().getExitAction());

        this.add(fileMenu);

        JMenu helpMenu = new JMenu("Help:");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        // info action
        helpMenu.add(MainFrame.getInstance().getActionMenager().getNewInfoAction());
        this.add(helpMenu);
    }

}
