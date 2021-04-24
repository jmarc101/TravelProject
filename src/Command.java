public abstract class Command implements IUndoableCommand {

    private ControllerAdministration controller;
    private ViewAdmin view;

    public Command(ControllerAdministration controller, ViewAdmin view) {
        this.controller = controller;
        this.view = view;
    }

    public abstract void execute();

    public abstract void unexecute();

    public abstract boolean isUndoable();


    public ControllerAdministration getController() {
        return controller;
    }

    public void setController(ControllerAdministration controller) {
        this.controller = controller;
    }

    public ViewAdmin getView() {
        return view;
    }

    public void setView(ViewAdmin view) {
        this.view = view;
    }
}