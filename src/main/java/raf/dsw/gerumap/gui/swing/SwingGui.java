package raf.dsw.gerumap.gui.swing;

import lombok.NoArgsConstructor;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.commadns.CommandManager;
import raf.dsw.gerumap.messageGenerator.Message;
import raf.dsw.gerumap.messageGenerator.MessageGeneratorImpl;
import raf.dsw.gerumap.observer.ISubscriber;

import javax.swing.*;

public class SwingGui implements Gui{

    private MessageGenerator messageGenerator;
    private CommandManager commandManager;

    public SwingGui(MessageGenerator msgimpl){
        this.messageGenerator = msgimpl;
        this.commandManager = new CommandManager();
        this.messageGenerator.addSubscriber(this);
    }
    @Override
    public void start() {
        MainFrame.getInstance().setVisible(true);
        MainFrame.getInstance().setLocationRelativeTo(null);
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionMenager().getUndoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionMenager().getUndoAction().setEnabled(true);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionMenager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionMenager().getRedoAction().setEnabled(true);
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public void update(Object notification, Object typeOfUpdate) {
        Message message = (Message) notification;
        JOptionPane.showMessageDialog(MainFrame.getInstance(), message.getContent(), message.getType(), 2);
    }
}
