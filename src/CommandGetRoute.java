public class CommandGetRoute extends Command {


	public CommandGetRoute(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\nViewing Route info\n");
		String id = getView().listen("Enter route ID: ");
		Route route = (Route) getController().routeManager.read(id);
		if (route == null){
			System.out.println("Invalid ID");
			return;
		}
		getController().acceptVisitor(route);
		getView().listen("\n <<<Press enter to go back to menu");

	}

	public void unexecute() {

	}

	public boolean isUndoable() {
		return false;
	}

}