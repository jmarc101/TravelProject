public class CommandModifyCompany extends Command {
	private Company previousCompany;
	private String newCompanyId;


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
		previousCompany = company;
		newCompanyId = getView().listen("\n New ID ").toUpperCase();
		company.setCompanyID(newCompanyId);
		company.setName(getView().listen("New name "));
		company.setHeadquarterAddress(getView().listen("new Address "));
		company.setFarePrice(Double.parseDouble(getView().listen("new Fare Price ")));
		System.out.println("\nInformation Update");
	}

	public void unexecute() {
		getController().getCompanyManager().delete(newCompanyId);
		getController().getCompanyManager().insert(previousCompany);
		System.out.println("Undo last Modify Company");
	}

	public boolean isUndoable() {
		return true;
	}

}