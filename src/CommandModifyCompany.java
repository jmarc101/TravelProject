public class CommandModifyCompany extends Command {


	public CommandModifyCompany(ControllerAdministration controller, ViewAdmin view) {
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
		company.setCompanyID(getView().listen("\n New ID ").toUpperCase());
		company.setName(getView().listen("New name "));
		company.setHeadquarterAddress(getView().listen("new Address "));
		company.setFarePrice(Double.parseDouble(getView().listen("new Fare Price ")));
		System.out.println("\nInformation Update");
	}

	public void unexecute() {
		// TODO - implement ModifyCompanyCommand.unexecute
		throw new UnsupportedOperationException();
	}

	public boolean isUndoable() {
		// TODO - implement ModifyCompanyCommand.isUndoable
		throw new UnsupportedOperationException();
	}

}