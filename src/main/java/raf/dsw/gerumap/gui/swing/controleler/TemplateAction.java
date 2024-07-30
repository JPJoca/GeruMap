package raf.dsw.gerumap.gui.swing.controleler;

import raf.dsw.gerumap.gui.swing.controleler.AbstractGerumapAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TemplateAction extends AbstractGerumapAction {


    private JDialog panel = new JDialog();
    public TemplateAction(){
        putValue(SMALL_ICON, loadicon("/img/templateIcon.png"));
        putValue(NAME, "Template");
        putValue(SHORT_DESCRIPTION, "Template");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel upPanel = new JPanel(new GridLayout(2, 2));
        JPanel downPanel = new JPanel();
        Button close = new Button("Close");
        close.addActionListener(ee -> {
            panel.dispose();
        });
        downPanel.add(close);
        panel.setTitle("Shabloni");
        panel.setSize(650,650);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setLayout(new BorderLayout());

        Icon img1 = new ImageIcon(getClass().getResource("/img/img1.png"));

        Icon img2 = new ImageIcon(getClass().getResource("/img/img2.png"));
        Icon img3 = new ImageIcon(getClass().getResource("/img/img3.png"));
        Icon img4 = new ImageIcon(getClass().getResource("/img/img4.png"));


        JLabel firstTemplate = new JLabel(img1);
        firstTemplate.setPreferredSize(new Dimension(300,300));
        JLabel secondTemplate = new JLabel(img2);
        secondTemplate.setPreferredSize(new Dimension(300,300));
        JLabel thirdTemplate = new JLabel(img3);
        thirdTemplate.setPreferredSize(new Dimension(300,300));
        JLabel fourthTemplate = new JLabel(img4);
        firstTemplate.setPreferredSize(new Dimension(300,300));

        firstTemplate.addMouseListener(new TemplateListener("1", panel));
        secondTemplate.addMouseListener(new TemplateListener("2", panel));
        thirdTemplate.addMouseListener(new TemplateListener("3", panel));
        fourthTemplate.addMouseListener(new TemplateListener("4", panel));

        upPanel.add(firstTemplate);
        upPanel.add(secondTemplate);
        upPanel.add(thirdTemplate);
        upPanel.add(fourthTemplate);

        panel.add(upPanel, BorderLayout.CENTER);
        panel.add(downPanel, BorderLayout.SOUTH);
    }
}
