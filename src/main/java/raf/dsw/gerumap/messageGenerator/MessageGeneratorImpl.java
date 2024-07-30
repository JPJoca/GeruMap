package raf.dsw.gerumap.messageGenerator;

import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.gui.swing.SwingGui;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImpl implements MessageGenerator {

    private List<ISubscriber> subscribers;

    @Override
    public Message generate(EventType typeOfEvent) {
        if(typeOfEvent == EventType.CANT_ADD_CHILD)
            this.notifySubscriber(new Message("Nije moguce dodavanje dece", "Error"),
                    null);
        else if(typeOfEvent == EventType.CANT_EMPTY_STRING)
            this.notifySubscriber(new Message("Ne moze da se ostavi prazno ime", "Error"),
                    null);
        else if(typeOfEvent == EventType.CANT_DELETE_PROJECTEXPOLORER) {
            Message message = new Message("ProjectExpolorer se ne moze izbrisati",
                    "Error");
            this.notifySubscriber(message, null);
             }
        else if(typeOfEvent == EventType.MUST_SELECT)
            this.notifySubscriber(new Message("Morate selektovati polje pre dodavanja!", "Alert"), null);
        else if(typeOfEvent == EventType.CANT_RENAME_AUTHOR)
            this.notifySubscriber(new Message("Morate selektovati projekat da bi dodali autora", "Alert"), null);
        else if(typeOfEvent == EventType.CANT_ADD_TOPIC)
            this.notifySubscriber(new Message("Ne mozete dodati topic preko drugog topica", "Alert"), null);
        else  if(typeOfEvent == EventType.CANT_ADD_LINK)
            this.notifySubscriber(new Message("Morate tacno povezati dva topica", "Alert"), null);
        else if(typeOfEvent == EventType.MUST_SELECT_BEFORE_DELETE)
            this.notifySubscriber(new Message("Morate selektovati element pre brisanja", "Alert"), null);
        else if(typeOfEvent == EventType.MUST_SELECT_BEFORE_MOVE)
            this.notifySubscriber(new Message("Morate selektovati element pre pomeranja", "Alert"), null);
        else if(typeOfEvent == EventType.MUST_SELECT_BEFORE_RENAME)
            this.notifySubscriber(new Message("Morate selektovati topic pre nego ga preimenujete", "Error"), null);
        else if(typeOfEvent == EventType.MUST_SELECT_BEFORE_FILL)
            this.notifySubscriber(new Message("Morate selektovati topic pre nego mu promenite boju", "Error"), null);
        else if(typeOfEvent == EventType.MUST_SELECT_BEFORE_STROKE)
            this.notifySubscriber(new Message("Morate selektovati element pre nego mu postavite debljinu linije", "Error"), null);
        else  if(typeOfEvent == EventType.MUST_SELECT_ONLY_ONE)
            this.notifySubscriber(new Message("Morate selektovati samo jedan topic.","Alert"),null);
        else  if(typeOfEvent == EventType.MUST_INSERT_TEXT)
            this.notifySubscriber(new Message("Morate uneti broj !.","Eror"),null);
        else if(typeOfEvent == EventType.CANT_ZOOM_MORE)
            this.notifySubscriber(new Message("Ne mozete vise zumirati", "Alert"), null);
        else if(typeOfEvent == EventType.SAVE_SELECT)
            this.notifySubscriber(new Message("Morate selektovati mapu uma", "Error"), null);
        else if(typeOfEvent == EventType.SAVE_PROJECT)
            this.notifySubscriber(new Message("Morate selektovati Projekat", "Error"), null);
        else if(typeOfEvent == EventType.LOAD)
            this.notifySubscriber(new Message("Morate selektovati ProjektExplorer", "Error"), null);

        return null;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification, Object typeOfUpdate) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber subs : subscribers){
            subs.update(notification, typeOfUpdate);
        }
    }
}
