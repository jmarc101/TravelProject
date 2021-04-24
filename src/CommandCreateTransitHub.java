import java.util.ArrayList;

public class CommandCreateTransitHub extends Command {


	public CommandCreateTransitHub(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {

		System.out.println("\n\nCreating Hub\nEnter information below");
		ArrayList<String> info = getView().getHubInfo();
		getController().createTransitHub(info.get(0),info.get(1).toUpperCase(), info.get(2));
		System.out.println("Hub Created");
	}

	public void unexecute() {
		// TODO - implement CreateTransitHubCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement CreateTransitHubCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}