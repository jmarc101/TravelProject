public class CommandGetTransitHub extends Command {

	public CommandGetTransitHub(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\nViewing Hub info\n");
		String id = getView().listen("Enter Hub ID: ");
		TransitHub hub = (TransitHub) getController().hubManager.read(id.toUpperCase());
		if (hub == null){
			System.out.println("Invalid ID");
			return;
		}
		System.out.println("***INFO***");
		hub.toStrings();
		System.out.println("");
	}

	public void unexecute() {
		// TODO - implement getTransitHubCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement getTransitHubCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}