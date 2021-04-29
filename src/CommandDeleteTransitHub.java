public class CommandDeleteTransitHub extends Command {
	private TransitHub previousTransitHub;


	public CommandDeleteTransitHub(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {

		System.out.println("\nModifying Hub info\n");
		String id = getView().listen("Enter Hub ID: ").toUpperCase();
		TransitHub hub = (TransitHub) getController().hubManager.read(id.toUpperCase());
		if (hub == null){
			System.out.println("Invalid ID");
			return;
		}
		System.out.println("***INFO***");
		hub.toStrings();

		String choice = getView().listen("\n\nAre you sure? (yes|no) ");
		if (choice.equals("no")) {
			System.out.println("** Not erasing **\n");
			return;
		}
		previousTransitHub = hub;
		getController().hubManager.delete(id);
		System.out.printf("*** Data Erased ***\n");
	}

	public void unexecute() {
		getController().getHubManager().insert(previousTransitHub);
		System.out.println("Undo delete Transit Hub");
	}

	public boolean isUndoable() {
		return true;
	}

}