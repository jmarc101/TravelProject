
public class FactoryAirplane implements FactoryVehicle {

	private static FactoryAirplane instance;

;

	private FactoryAirplane() {
	}

	public static FactoryAirplane getInstance() {
		if (instance == null) instance = new FactoryAirplane();
		return instance;
	}

	/**
	 * 
	 * @param companyID
	 * @param name
	 * @param adr
	 * @param farePrice
	 */
	public Company createCompany(String companyID, String name, String adr, double farePrice) {
		return new CompanyAir(companyID, name, adr, farePrice);
	}

	/**
	 * 
	 * @param startHubID
	 * @param endHubID
	 * @param startDate
	 * @param endDate
	 * @param company
	 * @param vehicle
	 */
	public Route createRoute( String startHubID, String endHubID, String startDate, String endDate, Company company, Vehicle vehicle) {
		return new Route(company.useRouteID(), startHubID, endHubID, startDate, endDate, company, vehicle);
	}

	/**
	 * 
	 * @param id
	 * @param town
	 */
	public TransitHub createTransitHub(String id, String town) {

		return new TransitHubAirport(id,town);

	}


}