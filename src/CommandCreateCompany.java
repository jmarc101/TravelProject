import java.util.ArrayList;

public class CommandCreateCompany extends Command {


	public CommandCreateCompany(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\n\nCreating Company\nEnter information below");
		ArrayList<String> info = getView().getCompanyInfo();
		getController().createCompany(info.get(0),info.get(1).toUpperCase(),
				info.get(2).toUpperCase(), info.get(3), Double.parseDouble(info.get(4)));
		System.out.println("Company Created");

	}

	public void unexecute() {
		// TODO - implement CreateCompanyCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement CreateCompanyCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}