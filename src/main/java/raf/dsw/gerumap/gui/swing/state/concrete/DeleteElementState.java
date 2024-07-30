package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.projectView.model.MapView;
import raf.dsw.gerumap.gui.swing.view.painter.model.Link;
import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;
import raf.dsw.gerumap.mapRepository.commadns.implementation.DeleteElementCommand;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.messageGenerator.EventType;
import raf.dsw.gerumap.gui.swing.state.State;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteElementState implements State {
    private List<MapNode> paintersToDelete = new ArrayList<>();
    @Override
    public void misKliknut(MapView map, int x, int y, int clickCount) {
        paintersToDelete.removeAll(paintersToDelete);
        if (map.getMapSelectionModel().getSelectedElements().isEmpty())
            AppCore.getInstance().getMessageGenerator().generate(EventType.MUST_SELECT_BEFORE_DELETE);
        for (Painter p : map.getMapSelectionModel().getSelectedElements()){
            paintersToDelete.add(p.getElement());
        }
        boolean ifClickedOnTopic = false;
        for (Painter p : map.getMapSelectionModel().getSelectedElements()) {
            if (p.elementAt(x, y)) {
                ifClickedOnTopic = true;
                break;
            }
        }

        if (!ifClickedOnTopic)
            return;

        for (Painter painter : map.getMapSelectionModel().getSelectedElements()) {
            for (Painter painter1 : map.getPainters()) {
                if (painter1 instanceof LinkPainter && (((Link) painter1.getElement()).getFromTopic().compare((Topic) painter.getElement())
                        || ((Link) painter1.getElement()).getToTopic().compare((Topic) painter.getElement()))) {
                    paintersToDelete.add(painter1.getElement());
                }
            }
        }
        AbstractCommand command = new DeleteElementCommand(map.getMap(), paintersToDelete);
        AppCore.getInstance().getGui().getCommandManager().addCommand(command);
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
