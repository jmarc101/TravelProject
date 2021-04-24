import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class FactoryBoat implements FactoryVehicle {

	int routeID = 1;

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


	public Route createRoute( String startHubID, String endHubID, LocalDate startDate, LocalDate endDate, Company company, Vehicle vehicle) {
		return new Route(String.valueOf(this.routeID++), startHubID, endHubID, startDate, endDate, company, vehicle);

	}

	@Override
	public TransitHub createTransitHub(String id, String town) {
		return new TransitHubPort(id,town);

	}

	@Override
	public Vehicle createVehicle(ArrayList<Section> sections) {
		return null;
	}
}