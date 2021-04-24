public class CommandDeleteCompany extends Command {

	public CommandDeleteCompany(ControllerAdministration controller, ViewAdmin view) {
		super(controller, view);
	}

	public void execute() {

		System.out.println("\nDeleting Company info\n");
		String id = getView().listen("Enter Company ID: ").toUpperCase();
		Company company = (Company) getController().companyManager.read(id);
		if (company == null){
			System.out.println("Invalid ID");
			return;
		}

		company.toStrings();

		String choice = getView().listen("\nAre you sure? (yes|no) ");
		if (choice.equals("no")) {
			System.out.println("** Not erasing **\n");
			return;
		}
		getController().companyManager.delete(id);
		System.out.printf("*** Data Erased ***");
	}

	public void unexecute() {
		// TODO - implement DeleteCompanyCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement DeleteCompanyCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}