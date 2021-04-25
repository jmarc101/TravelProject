

public class FactoryTrain implements FactoryVehicle {

	private static FactoryTrain instance;
	private FactoryTrain() {
	}

	public static FactoryTrain getInstance() {
		if (instance == null) instance = new FactoryTrain();
		return instance;
	}

	@Override
	public Company createCompany(String companyID, String name, String adr, double farePrice) {

		return new CompanyTrain(companyID, name, adr, farePrice);
	}

	@Override
	public Route createRoute( String startHubID, String endHubID, String startDate, String endDate, Company company, Vehicle vehicle) {
		return new Route(company.useRouteID(), startHubID, endHubID, startDate, endDate, company, vehicle);
	}

	@Override
	public TransitHub createTransitHub(String id, String town) {
		return new TransitHubTrainStation(id,town);

	}

}