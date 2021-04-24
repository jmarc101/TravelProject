import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public abstract interface FactoryVehicle {

	/**
	 * 
	 * @param companyID
	 * @param name
	 * @param adr
	 * @param farePrice
	 */
	abstract Company createCompany(String companyID, String name, String adr, double farePrice);

	/**
	 *
	 * @param startHubID
	 * @param endHubID
	 * @param startDate
	 * @param endDate
	 * @param company
	 * @param vehicle
	 */
	abstract Route createRoute(String startHubID, String endHubID, String startDate, String endDate, Company company, Vehicle vehicle);

	/**
	 * 
	 * @param id
	 * @param town
	 */
	abstract TransitHub createTransitHub(String id, String town);

	/**
	 * 
	 * @param sections
	 */
	abstract Vehicle createVehicle(ArrayList<Section> sections);

}