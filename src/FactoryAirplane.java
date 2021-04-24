import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class FactoryAirplane implements FactoryVehicle {

	private static FactoryAirplane instance;
	private int vehicleID = 1;
	private int routeID = 1;

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
	public Route createRoute( String startHubID, String endHubID, LocalDate startDate, LocalDate endDate, Company company, Vehicle vehicle) {
		return new Route(String.valueOf(this.routeID++), startHubID, endHubID, startDate, endDate, company, vehicle);
	}

	/**
	 * 
	 * @param id
	 * @param town
	 */
	public TransitHub createTransitHub(String id, String town) {

		return new TransitHubAirport(id,town);

	}

	/**
	 * 
	 * @param sections
	 */
	public Vehicle createVehicle(ArrayList<Section> sections) {
		return new VehicleAirplane(String.valueOf(vehicleID++), sections);
	}

}