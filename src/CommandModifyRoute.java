public class CommandModifyRoute extends Command {
	private Route route;
	private String oldStartTime;
	private String oldEndTime;

	public CommandModifyRoute(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\nViewing Route info\n");
		String id = getView().listen("Enter Route ID: ");
		route = (Route) getController().getRouteManager().read(id);
		if (route == null){
			System.out.println("Invalid ID");
			return;
		}
		System.out.println("Only dates are modifiable in routes");
		oldStartTime = route.getDateDebut();
		oldEndTime = route.getDateFin();
		route.setDateDebut(getView().listen("New Start date/time (YYYY.MM.DD:hh.mm"));
		route.setDateFin(getView().listen("New end date/time (YYYY.MM.DD:hh.mm"));
		System.out.println("*** Route modified! ***");
	}

	public void unexecute() {
		route.setDateDebut(oldStartTime);
		route.setDateFin(oldEndTime);
		System.out.println("Undoed last Modify Route");
	}

	public boolean isUndoable() {
		return true;
	}

}