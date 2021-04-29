public class CommandDeleteRoute extends Command {
	private Route previousRoute;


	public CommandDeleteRoute(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\nDeleting Route\n");
		String id = getView().listen("Enter route ID: ").toUpperCase();
		Route route = (Route) getController().getRouteManager().read(id);
		if (route == null){
			System.out.println("Invalid ID");
			return;
		}

		getController().acceptVisitor(route);

		String choice = getView().listen("\nAre you sure? (yes|no) ");
		if (choice.equals("no")) {
			System.out.println("** Not erasing **\n");
			return;
		}
		previousRoute = route;
		getController().getRouteManager().delete(id);
		System.out.printf("*** Data Erased ***");
	}

	public void unexecute() {
		getController().getRouteManager().insert(previousRoute);
		System.out.println("Undo delete Route");
	}

	public boolean isUndoable() {
		return true;
	}

}