import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ControllerAdministration extends Controller {

	private final FactoryTrain trainFactory;
	private final FactoryAirplane airplaneFactory;
	private final FactoryBoat boatFactory;
	private final IVisitor iVisitor;
	EntityManager hubManager;
	EntityManager vehicleManager;
	EntityManager companyManager;
	EntityManager routeManager;

	public ControllerAdministration() {
		airplaneFactory = FactoryAirplane.getInstance();
		trainFactory = FactoryTrain.getInstance();
		boatFactory = FactoryBoat.getInstance();
		iVisitor = new AdminIVisitor();
		hubManager = new ManagerTransitHub();
		vehicleManager = new ManagerVehicle();
		companyManager = new ManagerCompany();
		routeManager = new ManagerRoute();
	}

	/**
	 * 
	 * @param companyID
	 * @param name
	 * @param adr
	 * @param farePrice
	 */
	public void createCompany(String type, String companyID, String name, String adr, double farePrice) {

		switch (type) {
			case "air" -> companyManager.insert(airplaneFactory.createCompany(companyID, name, adr, farePrice));
			case "naval" -> companyManager.insert(boatFactory.createCompany(companyID, name, adr, farePrice));
			case "train" -> companyManager.insert(trainFactory.createCompany(companyID, name, adr, farePrice));
		}
	}

	/**
	 *  @param startHubID
	 * @param endHubID
	 * @param startDate
	 * @param endDate
	 * @param company
	 * @param vehicle
	 */
	public void createRoute(String startHubID, String endHubID, LocalDate startDate, LocalDate endDate, Company company, Vehicle vehicle) {

		routeManager.insert(airplaneFactory.createRoute(startHubID, endHubID, startDate, endDate, company, vehicle));

	}
	/**
	 * 
	 * @param id
	 * @param town
	 */
	public void createTransitHub(String type, String id, String town) {

		switch (type) {
			case "air" -> hubManager.insert(airplaneFactory.createTransitHub(id, town));
			case "naval" -> hubManager.insert(boatFactory.createTransitHub(id, town));
			case "train" -> hubManager.insert(trainFactory.createTransitHub(id, town));
		}

	}

	/**
	 * 
	 * @param sections
	 */
	public Vehicle createVehicle(ArrayList<Section> sections) {
		if (sections.get(0) instanceof SectionPlane){
			return airplaneFactory.createVehicle(sections);
		}

		return  null;
	}

	/**
	 * 
	 * @param route
	 */
	public void visit(Route route) {
		// TODO - implement ControllerAdministration.visit
		throw new UnsupportedOperationException();
	}


}