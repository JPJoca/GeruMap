package raf.dsw.gerumap.core;

import raf.dsw.gerumap.mapRepository.commadns.CommandManager;
import raf.dsw.gerumap.observer.ISubscriber;

public interface Gui extends ISubscriber {
    void start();
    void disableUndoAction();
    void enableUndoAction();
    void disableRedoAction();
    void enableRedoAction();

    CommandManager getCommandManager();
}
