package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.FillComand;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.*;
import java.awt.event.KeyEvent;

public class FillState implements State {



    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        if(map.getMapSelectionModel().getSelectedElements().isEmpty()){
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT_BEFORE_FILL);
            return;
        }
        Color color = MainFrame.getInstance().getColor();
        for(Painter painter: map.getMapSelectionModel().getSelectedElements()){
            AbstractCommand command = new FillComand(map.getMap(),(Topic) painter.getElement(),painter.getElement().getColor(),color);
            AppCore.getInstance().getGui().getCommandManager().addCommand(command);

            painter.getElement().setColor(color);
        }
    }


    @Override
    public void misPovucen(MapView map, int x, int y) {

    }

    @Override
    public void misPusten(MapView map, int x, int y) {


    }

    @Override
    public void dugmeKliknuto(MapView view, KeyEvent e) {

    }
}
