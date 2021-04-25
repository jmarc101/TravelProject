
public class FactoryBoat implements FactoryVehicle {

	private static FactoryBoat instance;

	private FactoryBoat() {
	}

	public static FactoryBoat getInstance() {
		if (instance == null) instance = new FactoryBoat();
		return instance;
	}


	@Override
	public Company createCompany(String companyID, String name, String adr, double farePrice) {
		return new CompanyNaval(companyID, name, adr, farePrice);

	}


	public Route createRoute( String startHubID, String endHubID, String startDate, String endDate, Company company, Vehicle vehicle) {
		return new Route(company.useRouteID(), startHubID, endHubID, startDate, endDate, company, vehicle);

	}

	@Override
	public TransitHub createTransitHub(String id, String town) {
		return new TransitHubPort(id,town);

	}

}