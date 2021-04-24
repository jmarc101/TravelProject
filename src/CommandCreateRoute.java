import java.util.ArrayList;

public class CommandCreateRoute extends Command {



	public CommandCreateRoute(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("*** Creating Route ***");
		ArrayList<String> info = getView().getRouteInfo();
		if (info == null){
			System.out.println("Invalide info");
			return;
		}
		Company company = (Company)getController().companyManager.read(info.get(5));
		Vehicle vehicle = company.getVehicle(Integer.parseInt(info.get(6)));
		System.out.println("Route ID : " + company.getRouteID());
		getController().createRoute(info.get(1), info.get(2), info.get(3),info.get(4),company,vehicle);

	}

	public void unexecute() {
		// TODO - implement CreateRouteCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement CreateRouteCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}