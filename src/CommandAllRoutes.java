
public class CommandAllRoutes extends Command
{
    public CommandAllRoutes(ControllerAdministration controller, ViewAdmin view) {
        super(controller, view);
    }

    @Override
    public void execute() {

        System.out.println("**** Airplane Routes ****");
        for (Route route : getController().getAllRoutes()) {
            if (route.getVehicle() instanceof VehicleAirplane) {
                getController().visit(route);
            }
        }
        System.out.println("**** Train Routes ****");
        for (Route route : getController().getAllRoutes()) {
            if (route.getVehicle() instanceof VehicleTrain) {
                getController().visit(route);
            }
        }
        System.out.println("**** Boat Routes ****");
        for (Route route : getController().getAllRoutes()) {
            if (route.getVehicle() instanceof VehicleBoat) {
                getController().visit(route);
            }
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
