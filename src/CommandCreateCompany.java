import java.util.ArrayList;

public class CommandCreateCompany extends Command {
	private Company compaynHistory;


	public CommandCreateCompany(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\n\nCreating Company\nEnter information below");
		ArrayList<String> info = getView().getCompanyInfo();
		Double price = info.get(4).length() == 0 ? 0 : Double.parseDouble(info.get(4));
		getController().createCompany(info.get(0),info.get(1).toUpperCase(),
				info.get(2).toUpperCase(), info.get(3), price);
		compaynHistory = (Company) getController().companyManager.read(info.get(1));
		System.out.println("Company Created");

	}

	public void unexecute() {
		getController().getCompanyManager().delete(compaynHistory.getCompanyID());
		System.out.println("Undo create Company");
	}

	public boolean isUndoable() {
		return true;
	}

}