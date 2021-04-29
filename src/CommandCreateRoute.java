import java.util.ArrayList;

public class CommandCreateRoute extends Command {
	private String companyIdHistory;


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
		Vehicle vehicle = company.getVehicle(Integer.parseInt(info.get(6)) - 1);
		System.out.println("Route ID : " + company.getRouteID());
		companyIdHistory = company.getCompanyID();
		getController().createRoute(info.get(1), info.get(2), info.get(3),info.get(4),company,vehicle);

	}

	public void unexecute() {
		getController().routeManager.delete(companyIdHistory);
		System.out.println("Undo create Route");
	}

	public boolean isUndoable() {
		return true;
	}

}