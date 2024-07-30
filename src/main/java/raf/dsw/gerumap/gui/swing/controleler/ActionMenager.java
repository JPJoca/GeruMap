package raf.dsw.gerumap.gui.swing.controleler;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controleler.stateActions.*;

@Getter
@Setter
public class ActionMenager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private InfoAction newInfoAction;
    private RenameProjectAction rename;
    private DeleteProjectAction delete;
    private SetAutor setAutor;
    private AddLinkAction addLinkAction;
    private AddTopicAction addTopicAction;
    private DeleteElementAction deleteElementAction;
    private MoveElementAction moveElementAction;
    private SelectAction selectAction;
    private ZoomAction zoomAction;
    private FillAction fillAction;
    private LasoSelectionAction lasoSelectionAction;
    private StrokeAction strokeAction;
    private RenameAction renameAction;
    private ZoomOutAction zoomOutAction;
    private UndoAction undoAction;
    private RedoAction redoAction;
    private LoadAction loadAction;
    private SaveAction saveAction;
    private SetCentralTopicAction setCentralTopicAction;
    private SaveImgAction saveImgAction;
    private TemplateAction templateAction;

    public ActionMenager(){
        innit();
    }

    private void innit() {
            exitAction = new ExitAction();
            newProjectAction = new NewProjectAction();
            newInfoAction = new InfoAction();
            rename = new RenameProjectAction();
            delete = new DeleteProjectAction();
            setAutor = new SetAutor();
            addLinkAction = new AddLinkAction();
            addTopicAction = new AddTopicAction();
            deleteElementAction = new DeleteElementAction();
            moveElementAction = new MoveElementAction();
            selectAction = new SelectAction();
            zoomAction = new ZoomAction();
            fillAction = new FillAction();
            lasoSelectionAction = new LasoSelectionAction();
            renameAction = new RenameAction();
            strokeAction = new StrokeAction();
            zoomOutAction = new ZoomOutAction();
            undoAction = new UndoAction();
            redoAction = new RedoAction();
            loadAction = new LoadAction();
            saveAction = new SaveAction();
            setCentralTopicAction = new SetCentralTopicAction();
            saveImgAction = new SaveImgAction();
            templateAction = new TemplateAction();
    }
}
