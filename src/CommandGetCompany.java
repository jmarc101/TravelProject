public class CommandGetCompany extends Command {


	public CommandGetCompany(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {
		System.out.println("\nViewing Company info\n");
		String id = getView().listen("Enter Company ID: ");
		Company company = (Company) getController().companyManager.read(id);
		if (company == null){
			System.out.println("Invalid ID");
			return;
		}

		company.toStrings();
		getView().listen("\n <<<Press enter to go back to menu");


	}

	public void unexecute() {

	}

	public boolean isUndoable() {
		return false;
	}

}