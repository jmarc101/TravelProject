import java.util.ArrayList;

public class CommandCreateTransitHub extends Command {
	private String previousHubID;

	public CommandCreateTransitHub(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {

		System.out.println("\n\nCreating Hub\nEnter information below");
		ArrayList<String> info = getView().getHubInfo();
		getController().createTransitHub(info.get(0),info.get(1).toUpperCase(), info.get(2));
		previousHubID = info.get(1);
		System.out.println("Hub Created");
	}

	public void unexecute() {
		getController().getHubManager().delete(previousHubID);
		System.out.println("Undo create Transit Hub");
	}

	public boolean isUndoable() {
		return true;
	}

}