import java.util.ArrayList;

public class ManagerCompany implements EntityManager, Iterable {

	private ArrayList<Company> listCompany;

	public ManagerCompany() {
		this.listCompany = new ArrayList<>();
	}

	/**
	 * 
	 * @param e
	 */
	public void insert(TravelEntity e) {
		if (e instanceof Company) listCompany.add((Company) e);
	}

	/**
	 * 
	 * @param e
	 */
	public void update(TravelEntity e) {
		Company company = (Company) e;
		int index = -1;
		for (int i = 0; i < listCompany.size(); i++) {
			if (listCompany.get(i).getCompanyID().equals(company.getCompanyID())) {
				index = i;
			}
		}
		if (index == -1) return;
		listCompany.set(index, company);

	}

	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {

		listCompany.removeIf(e -> e.getCompanyID().equals(id));
	}

	/**
	 * 
	 * @param id
	 */
	public TravelEntity read(String id) {

		for (Company company : listCompany){
			if (company.getCompanyID().equals(id)) return company;
		}
		return null;
	}

	public void iterateCompanies(String type){
		switch (type){
			case "air":
				for (Company company : listCompany)
					if (company instanceof CompanyAir) company.toStrings();
				break;
			case "naval":
				for (Company company : listCompany)
					if (company instanceof CompanyNaval) company.toStrings();
				break;
			case "train":
				for (Company company : listCompany)
					if (company instanceof CompanyTrain) company.toStrings();
					break;
			}

	}

	public Iterator createIterator() {
		// TODO - implement ManagerCompany.createIterator
		throw new UnsupportedOperationException();
	}

}