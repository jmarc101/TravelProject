public class CommandModifyTransitHub extends Command {


	public CommandModifyTransitHub(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\nModifying Hub info\n");
		String id = getView().listen("Enter Hub ID: ");
		TransitHub hub = (TransitHub) getController().hubManager.read(id.toUpperCase());
		if (hub == null){
			System.out.println("Invalid ID");
			return;
		}
		System.out.println("***INFO***");
		hub.toStrings();
		System.out.println("\n\n *** ENTER NEW INFO ***");
		hub.setHubID(getView().listen("New ID (length 3)  ").toUpperCase());
		hub.setTown(getView().listen("New town "));

		System.out.println("\nInformation Update");


	}

	public void unexecute() {
		// TODO - implement ModifyTransitHubCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement ModifyTransitHubCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}