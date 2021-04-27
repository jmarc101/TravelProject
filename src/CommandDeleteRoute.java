public class CommandDeleteRoute extends Command {


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

		getController().visit(route);

		String choice = getView().listen("\nAre you sure? (yes|no) ");
		if (choice.equals("no")) {
			System.out.println("** Not erasing **\n");
			return;
		}
		getController().getRouteManager().delete(id);
		System.out.printf("*** Data Erased ***");
	}

	public void unexecute() {
		// TODO - implement DeleteRouteCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement DeleteRouteCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}