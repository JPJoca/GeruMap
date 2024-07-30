package raf.dsw.gerumap.mapRepository.commadns;

public abstract class AbstractCommand {
    public abstract void doCommand();
    public abstract void undoCommand();
}
