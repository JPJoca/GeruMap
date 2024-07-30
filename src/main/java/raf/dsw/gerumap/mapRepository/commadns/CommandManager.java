package raf.dsw.gerumap.mapRepository.commadns;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.MapRepositoryImpl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<AbstractCommand> commands = new ArrayList<>();
    private int currentCommand = 0;

    public void addCommand(AbstractCommand command){
        while(currentCommand < commands.size())
            commands.remove(currentCommand);
        commands.add(command);
        doCommand();
    }

    public void doCommand() {
        if(currentCommand < commands.size()){
            commands.get(currentCommand++).doCommand();
            AppCore.getInstance().getGui().enableUndoAction();
        }

        if(currentCommand == commands.size())
            AppCore.getInstance().getGui().disableRedoAction();
    }

    public void undoCommand(){
        if(currentCommand > 0){
            AppCore.getInstance().getGui().enableRedoAction();
            commands.get(--currentCommand).undoCommand();
        }
        if(currentCommand == 0)
            AppCore.getInstance().getGui().disableUndoAction();
    }
}
