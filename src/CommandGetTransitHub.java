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

		getView().listen("\n <<<Press enter to go back to menu");

	}

	public void unexecute() {

	}

	public boolean isUndoable() {
		return false;
	}

}