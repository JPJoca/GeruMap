package raf.dsw.gerumap.gui.swing.view;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.view.ProjectViewView;
import raf.dsw.gerumap.gui.swing.stablo.MapTree1;
import raf.dsw.gerumap.gui.swing.stablo.MapTreeImpl;
import raf.dsw.gerumap.gui.swing.controleler.ActionMenager;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainFrame extends JFrame {

    private static MainFrame instance;
    private ActionMenager actionMenager;
    private JToolBar toolBar;
    private JMenuBar menu;
    private JPanel desktop;
    private MapTree1 mapTree;
    private JToolBar toolToolBar;
    private ProjectViewView projectViewView;
    private List<ProjectViewView> projectViewList;
    private Color color;
    private MainFrame(){


    }

    private void initialise(){
        actionMenager = new ActionMenager();
        mapTree = new MapTreeImpl();
        projectViewList = new ArrayList<>();
        initialiseGui();
    }

    private void initialiseGui() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setSize(screenWidth / 2 + 500 , screenHeight/ 2 + 300 );
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar,BorderLayout.NORTH);

        toolToolBar = new ToolToolbar();

        desktop = new JPanel(new BorderLayout());
        JTree projectExplorer = mapTree.generateTree(AppCore.getInstance().getMap().getProjectExplorer());

        projectExplorer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (e.getClickCount() == 2) {
                        if (mapTree.getSelectedNode().getMapNode() instanceof Project) {
                            //System.out.println(projectViewList.size());
                            desktop.removeAll();
                            setView((Project) mapTree.getSelectedNode().getMapNode());
                            desktop.repaint();


                        }
                    } else if (e.getClickCount() == 1 && mapTree != null && mapTree.getSelectedNode().getMapNode() instanceof Project) {
                        setView((Project) mapTree.getSelectedNode().getMapNode());
                        desktop.repaint();

                    }
                }catch (NullPointerException exception){

                }
            }
        });

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        getContentPane().add(scroll,BorderLayout.EAST);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(splitPane, BorderLayout.CENTER);
        splitPane.setMinimumSize(new Dimension(150, 250));
        splitPane.setDividerLocation(250);
        splitPane.setOneTouchExpandable(true);
    }

    private void setView(Project project) {

        if(projectViewList.isEmpty()) {
            ProjectViewView p = new ProjectViewView(project
                    , AppCore.getInstance().getMap().getProjectExplorer());
            projectViewList.add(p);
            projectViewView = p;
            desktop.add(projectViewView);
            desktop.revalidate();
        } else{
            for (ProjectViewView view : projectViewList) {
                if(view.getProject().equals(project)){
                    projectViewView = view;
                    desktop.add(projectViewView);
                    desktop.revalidate();
                    return;
                }
            }
            ProjectViewView p = new ProjectViewView(project
                    , AppCore.getInstance().getMap().getProjectExplorer());
            projectViewList.add(p);
            projectViewView = p;
            desktop.add(projectViewView);
            desktop.revalidate();

        }
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }
    public Color settColor() {
        return color = JColorChooser.showDialog(this,"Set color:",Color.cyan);
    }
    public Color getColor(){
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

}
