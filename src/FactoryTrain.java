import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class FactoryTrain implements FactoryVehicle {

	private static FactoryTrain instance;
	int routeID = 1;
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
	public Route createRoute( String startHubID, String endHubID, LocalDate startDate, LocalDate endDate, Company company, Vehicle vehicle) {
		return new Route(String.valueOf(this.routeID++), startHubID, endHubID, startDate, endDate, company, vehicle);
	}

	@Override
	public TransitHub createTransitHub(String id, String town) {
		return new TransitHubTrainStation(id,town);

	}

	@Override
	public Vehicle createVehicle(ArrayList<Section> sections) {
		return null;
	}
}