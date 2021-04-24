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


	}

	public void unexecute() {
		// TODO - implement GetCompanyCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement GetCompanyCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}