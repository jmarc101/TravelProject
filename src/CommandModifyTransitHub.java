public class CommandModifyTransitHub extends Command {
	private TransitHub previousHub;
	private String newID;


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
		previousHub = hub;
		newID = getView().listen("New ID (length 3)  ").toUpperCase();
		hub.setHubID(newID);
		hub.setTown(getView().listen("New town "));

		System.out.println("\nInformation Update");


	}

	public void unexecute() {
		getController().getHubManager().delete(newID);
		getController().getHubManager().insert(previousHub);
		System.out.println("Undo last Modify Transit Hub");
	}

	public boolean isUndoable() {
		return true;
	}

}