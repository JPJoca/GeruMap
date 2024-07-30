package raf.dsw.gerumap.gui.swing.projectView.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.ToolToolbar;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.gui.swing.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProjectViewView extends JPanel implements ISubscriber {
    private JTabbedPane tabbedPane;
    private JLabel author;
    private JLabel projectName;
    private Project project;
    private ProjectExplorer projectExplorer;
    private MindMap mindMap;
    private MapView emptyPanle;
    private ToolToolbar toolbar;
    private JPanel leftPanel, rightPanel;
    private StateManager stateManager;
    private List<MapView> mapViewList;
    public ProjectViewView(Project project, ProjectExplorer projectExplorer){
        this.project = project;
        this.toolbar = new ToolToolbar();
        this.projectExplorer = projectExplorer;
        this.project.addSubscriber(this);
        this.projectExplorer.addSubscriber(this);
        this.mapViewList = new ArrayList<>();
        init();
    }
    private void init() {
        stateManager = new StateManager();
        leftPanel = new JPanel();
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.HORIZONTAL);
        this.makePanel(project);
        author = new JLabel("Author: " + project.getAuthor());
        projectName = new JLabel("Project name : " + project.getName());
        emptyPanle = new MapView(null);
        rightPanel = new JPanel();

        this.setLayout(new BorderLayout());
        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));
        leftPanel.add(author);
        leftPanel.add(projectName);
        leftPanel.add(tabbedPane);
        rightPanel.add(toolbar);

        this.add(leftPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);

    }



    private MapView makeTextPanel(MindMap e){
        if(mapViewList.isEmpty()){
            MapView panel = new MapView(e);
            panel.setLayout(new GridLayout(1, 1));
            panel.setBackground(new Color(0xABABAF));
            mapViewList.add(panel);
            return panel;
        } else{
            for (MapView mapView : mapViewList) {
                if(mapView.getMap().equals(e)){
                    return mapView;
                }
            }
            MapView panel = new MapView(e);
            panel.setLayout(new GridLayout(1, 1));
            panel.setBackground(new Color(0xABABAF));
            mapViewList.add(panel);
            return panel;
        }
    }

    private void makePanel(Project project){
        leftPanel.remove(tabbedPane);
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.HORIZONTAL);
        for(MapNode el : project.getChildren()){
            MindMap tmpMindMap = (MindMap) el;
            MapView newTab = makeTextPanel(tmpMindMap);
            newTab.fillPainter();
            JScrollPane scrollBar = new JScrollPane(newTab);
            scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

            tabbedPane.addTab(tmpMindMap.getName(), scrollBar);
        }
        leftPanel.add(tabbedPane);
    }

    private void updateDestop(){
        MainFrame.getInstance().getDesktop().removeAll();
        MainFrame.getInstance().setProjectViewView(this);
        MainFrame.getInstance().getDesktop().add(this, BorderLayout.CENTER);
        MainFrame.getInstance().getDesktop().revalidate();
    }

    @Override
    public void update(Object notification, Object typeOfUpdate) {
        if(notification instanceof Project && typeOfUpdate instanceof String) {
            this.author.setText(("Autor: " + ((Project) notification).getAuthor()));
            this.projectName.setText(("Projekat: " + ((Project) notification).getName()));
            updateDestop();
        }else if(notification instanceof Project && typeOfUpdate instanceof MapNode){
            this.makePanel((Project) notification);
            updateDestop();
        }else if(notification instanceof MindMap && typeOfUpdate instanceof String){
            this.makePanel(project);
            updateDestop();
        }else if(notification instanceof ProjectExplorer && typeOfUpdate instanceof MapNode){
            MainFrame.getInstance().getDesktop().removeAll();
            MainFrame.getInstance().getDesktop().add(emptyPanle);
            MainFrame.getInstance().getDesktop().revalidate();
        }
    }




    public void startAddLinkState(){
        this.stateManager.setAddLinkState();
    }

    public void startAddTopicState(){
        this.stateManager.setAddTopicState();
    }

    public void startDeleteElementState(){
        this.stateManager.setDeleteElementState();
    }

    public void startMoveElementState(){
        this.stateManager.setMoveElementState();
    }

    public void startSelectState(){
        this.stateManager.setSelectState();
    }

    public void startZoomState(){
        this.stateManager.setZoomState();
    }

    public void startZoomOutState(){
        this.stateManager.setZoomOutState();
    }

    public void startFillState(){this.stateManager.setFillState();}

    public void startLasoSelectState(){this.stateManager.setLasoSelectionState();}

    public void startRenameState(){this.stateManager.setRenameState();}

    public void startStrokeState(){this.stateManager.setStrokeState();}

    public void startCentralTopicAction() {
        this.stateManager.setCentralTopicAction();
    }

    public void misKliknut(MapView map, int x, int y, int clickCount) {
        if(this.getStateManager().getCurrentState() != null);
        try {
            this.stateManager.getCurrentState().misKliknut(map, x, y, clickCount);
        } catch (NullPointerException e){

        }
    }

    public void misPovucen(MapView mapView, int x, int y){
        if(this.getStateManager().getCurrentState() != null);
            try{
                this.stateManager.getCurrentState().misPovucen(mapView, x, y);
            } catch (NullPointerException e){
                e.printStackTrace();
            }
}

    public void misPusten(MapView mapView, int x, int y){
        if(this.getStateManager().getCurrentState() != null);
            try{
                this.stateManager.getCurrentState().misPusten(mapView, x, y);
            } catch (NullPointerException e){
                e.printStackTrace();
        }
}
    public void dugmeKliknuto(MapView view, KeyEvent e){
        this.stateManager.getCurrentState().dugmeKliknuto(view, e);
    }
}
