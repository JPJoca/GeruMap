package raf.dsw.gerumap.mapRepository.commadns.implementation;

import raf.dsw.gerumap.gui.swing.view.painter.model.Topic;
import raf.dsw.gerumap.gui.swing.view.painter.view.Painter;
import raf.dsw.gerumap.mapRepository.commadns.AbstractCommand;

public class NameCommadn extends AbstractCommand {

    private Topic topic;
    private String name;
    private String preName;

    public NameCommadn(Topic topic, String name, String preName) {
        this.topic = topic;
        this.name = name;
        this.preName = preName;
    }

    @Override
    public void doCommand() {
        topic.setName(name);
    }

    @Override
    public void undoCommand() {
        topic.setName(preName);
    }
}
