
public class CommandAllRoutes extends Command
{
    public CommandAllRoutes(ControllerAdministration controller, ViewAdmin view) {
        super(controller, view);
    }

    @Override
    public void execute() {

        System.out.println("\n**** Airplane Routes ****");
        for (Route route : getController().getAllRoutes()) {
            if (route.getVehicle() instanceof VehicleAirplane) {
                getController().acceptVisitor(route);
            }
        }
        System.out.println("\n**** Train Routes ****");
        for (Route route : getController().getAllRoutes()) {
            if (route.getVehicle() instanceof VehicleTrain) {
                getController().acceptVisitor(route);
            }
        }
        System.out.println("\n**** Boat Routes ****");
        for (Route route : getController().getAllRoutes()) {
            if (route.getVehicle() instanceof VehicleBoat) {
                getController().acceptVisitor(route);
            }
        }
        getView().listen("\n <<<Press enter to go back to menu");
    }

    @Override
    public void unexecute() {

    }

    @Override
    public boolean isUndoable() {
        return false;
    }
}
