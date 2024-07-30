package raf.dsw.gerumap.gui.swing.controleler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public abstract class AbstractGerumapAction extends AbstractAction {
    public Icon loadicon(String fileName){
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if(imageURL != null){
            icon = new ImageIcon(imageURL);
        } else {
            System.err.println("Resource not found: " + fileName);
        }

        return icon;
    }

    public Icon block(Color boja){
        Icon icon = new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(boja);
                g.fillRect(x,y,getIconWidth(),getIconHeight());
                g.drawRect(x, y, getIconWidth(), getIconHeight());

            }

            @Override
            public int getIconWidth() {
                return 50;
            }

            @Override
            public int getIconHeight() {
                return 50;
            }
        };
        return icon;
    }
}
