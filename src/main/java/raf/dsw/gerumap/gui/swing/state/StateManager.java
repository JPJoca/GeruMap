package raf.dsw.gerumap.gui.swing.state;

import raf.dsw.gerumap.gui.swing.controleler.stateActions.SetCentralTopicAction;
import raf.dsw.gerumap.gui.swing.state.concrete.*;

public class StateManager {
    private State currentState;
    private ZoomState zoomState;
    private SelectState selectState;
    private MoveElementState moveElementState;
    private DeleteElementState deleteElementState;
    private AddLinkState addLinkState;
    private AddTopicState addTopicState;
    private FillState fillState;
    private LasoSelectionState lasoSelectionState;
    private StrokeState strokeState;
    private RenameState renameState;
    private SetCentralTopicState  setCentralTopicState;

    private ZoomOutState zoomOutState;

    public StateManager(){
        initStates();
    }

    private void initStates() {
        currentState = null;
        zoomState = new ZoomState();
        selectState = new SelectState();
        moveElementState = new MoveElementState();
        deleteElementState = new DeleteElementState();
        addLinkState = new AddLinkState();
        addTopicState = new AddTopicState();
        fillState = new FillState();
        lasoSelectionState = new LasoSelectionState();
        strokeState = new StrokeState();
        renameState = new RenameState();
        zoomOutState = new ZoomOutState();
        setCentralTopicState = new SetCentralTopicState();
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setZoomOutState(){
        currentState = zoomOutState;
    }

    public void setZoomState(){
        currentState = zoomState;
    }

    public void setSelectState(){
        currentState = selectState;
    }

    public void setMoveElementState(){
        currentState = moveElementState;
    }

    public void setDeleteElementState(){
        currentState = deleteElementState;
    }

    public void setAddLinkState(){
        currentState = addLinkState;
    }

    public void setAddTopicState(){
        currentState = addTopicState;
    }

    public void setFillState(){
        currentState = fillState;
    }

    public void setLasoSelectionState(){ currentState = lasoSelectionState;}

    public void setStrokeState(){currentState = strokeState;}

    public void setRenameState(){currentState = renameState;}

    public void setCentralTopicAction() {
        currentState = setCentralTopicState;
    }
}
