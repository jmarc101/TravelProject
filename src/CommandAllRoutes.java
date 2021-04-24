import java.util.ArrayList;

public class CommandAllRoutes extends Command
{
    public CommandAllRoutes(ControllerAdministration controller, ViewAdmin view) {
        super(controller, view);
    }

    @Override
    public void execute() {
        Iterator iterator = getController().routeIter.createIterator();

        while(!iterator.isDone()){

            Route route = (Route) iterator.currentItem();
            if (route == null) return;
            getController().visit(route);
            iterator.next();
        }
    }

    @Override
    public void unexecute() {

    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
