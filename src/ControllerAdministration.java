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
	Iterable routeIter;
	IRoutes routeReader;
	ArrayList<ISubject> iSubjects;


	public ControllerAdministration() {
		airplaneFactory = FactoryAirplane.getInstance();
		trainFactory = FactoryTrain.getInstance();
		boatFactory = FactoryBoat.getInstance();
		iVisitor = new AdminIVisitor();
		hubManager = new ManagerTransitHub();
		vehicleManager = new ManagerVehicle();
		companyManager = new ManagerCompany();
		routeManager = ManagerRoute.getInstance();
		routeIter = (Iterable) routeManager;
		routeReader = (IRoutes) routeManager;
		iSubjects = new ArrayList<>();
		iSubjects.add((ISubject) routeManager);
		iSubjects.add(ManagerReservation.getInstance());

		populateManagers();
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
	public void createRoute(String startHubID, String endHubID, String startDate, String endDate, Company company, Vehicle vehicle) {

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
	 * @param route
	 */
	public void visit(Route route) {
		iVisitor.visit(route);
	}

	public void acceptVisitor(IVisitor visitor, IVisitable subject){
		subject.acceptVisitor(visitor);
	}

	public void attachObs(IObserver observer){
		for (ISubject subject : iSubjects){
			subject.attach(observer);
		}
	}

	public void detachObs(IObserver observer){
		for (ISubject subject : iSubjects){
			subject.detach(observer);
		}
	}

	private void notifyObs(){
		for (ISubject subject : iSubjects){
			subject.notifyObs();
		}
	}

	public ArrayList<Route> getAllRoutes(){
		return getRouteReader().getAllRoutes();
	}


	public void populateManagers(){

		FactoryAirplane factoryAirplane = FactoryAirplane.getInstance();
		FactoryBoat factoryBoat = FactoryBoat.getInstance();
		FactoryTrain factoryTrain = FactoryTrain.getInstance();

		Company airCanada = factoryAirplane.createCompany("AC", "AIRCAN", "555 rue des avions", 500);
		Company airTransat = factoryAirplane.createCompany("AT", "AIRTRA", "0 rue des nowheres", 1000);
		Company airBob = factoryAirplane.createCompany("AB", "AIRBOB", "51234 rue des ginettes", 200);

		TransitHub airportMontreal = factoryAirplane.createTransitHub("YUL", "Montreal");
		TransitHub airportToronto = factoryAirplane.createTransitHub("YYZ", "Toronto");
		TransitHub airportNewYork= factoryAirplane.createTransitHub("JFK", "New York");


		Route route0 = factoryAirplane.createRoute("YUL", "YYZ","2020.04.24:19.40",
				"2020.04.24:23.43", airBob, airBob.getVehicle(0));
		Route route1 = factoryAirplane.createRoute("YUL", "YYZ","2020.04.24:17.00",
				"2020.04.24:22.00", airBob, airBob.getVehicle(1));
		Route route2 = factoryAirplane.createRoute("YYZ", "JFK","2020.04.25:17.00",
				"2020.04.25:22.00", airCanada, airBob.getVehicle(1));
		Route route3 = factoryAirplane.createRoute("YUL", "JFK","2020.04.24:12.00",
				"2020.04.24:22.00", airTransat, airBob.getVehicle(0));


		Company bobWaters = factoryBoat.createCompany("BW", "BOBWTR", "999 rue bob", 600);
		Company vistaWaters = factoryBoat.createCompany("VW", "VSTWTR", "1234 rue alice", 600);
		Company aliceWaters = factoryBoat.createCompany("AW", "ALIWTR", "1234 rue des peuples", 600);

		TransitHub portMontreal = factoryBoat.createTransitHub("MTP", "Montreal");
		TransitHub portToronto = factoryBoat.createTransitHub("TTP", "Toronto");
		TransitHub portNewYork = factoryBoat.createTransitHub("NYP", "New York");

		Route route4 = factoryBoat.createRoute("MTP", "TTP","2020.04.24:17.00",
				"2020.04.24:22.00", bobWaters, bobWaters.getVehicle(0));
		Route route5 = factoryBoat.createRoute("TTP", "NYP","2020.04.25:17.00",
				"2020.04.25:22.00", vistaWaters, vistaWaters.getVehicle(0));
		Route route6 = factoryBoat.createRoute("MTP", "NYP","2020.04.24:12.00",
				"2020.04.24:22.00", aliceWaters, aliceWaters.getVehicle(0));


		Company viaRail = factoryTrain.createCompany("VR", "VIARAIL", "51234 rue des bob", 2000);
		Company realRail = factoryTrain.createCompany("RR", "REALRAIL", "51234 rue des alphonses", 2000);
		Company bobRail = factoryTrain.createCompany("BR", "BOBRAIL", "51234 rue des ginettes", 2000);

		TransitHub montrealStation = factoryTrain.createTransitHub("MTT", "Montreal");
		TransitHub torontoStation = factoryTrain.createTransitHub("TTT", "Montreal");
		TransitHub newYorkStation = factoryTrain.createTransitHub("NYT", "Montreal");

		Route route7 = factoryTrain.createRoute("MTT", "TTT","2020.04.24:17.00",
				"2020.04.24:22.00", viaRail, viaRail.getVehicle(0));
		Route route8 = factoryTrain.createRoute("TTT", "NYT","2020.04.25:17.00",
				"2020.04.25:22.00", realRail, realRail.getVehicle(1));
		Route route9 = factoryTrain.createRoute("MTT", "NYT","2020.04.24:12.00",
				"2020.04.24:22.00", bobRail, bobRail.getVehicle(0));


		companyManager.insert(airBob);
		companyManager.insert(airCanada);
		companyManager.insert(airTransat);
		companyManager.insert(aliceWaters);
		companyManager.insert(bobWaters);
		companyManager.insert(vistaWaters);
		companyManager.insert(bobRail);
		companyManager.insert(realRail);
		companyManager.insert(viaRail);


		hubManager.insert(montrealStation);
		hubManager.insert(torontoStation);
		hubManager.insert(newYorkStation);
		hubManager.insert(airportMontreal);
		hubManager.insert(airportToronto);
		hubManager.insert(airportNewYork);
		hubManager.insert(portMontreal);
		hubManager.insert(portNewYork);
		hubManager.insert(portToronto);



		routeManager.insert(route0);
		routeManager.insert(route1);
		routeManager.insert(route2);
		routeManager.insert(route3);
		routeManager.insert(route4);
		routeManager.insert(route5);
		routeManager.insert(route6);
		routeManager.insert(route7);
		routeManager.insert(route8);
		routeManager.insert(route9);


	}

	public IRoutes getRouteReader() {
		return routeReader;
	}

	public void setRouteReader(IRoutes routeReader) {
		this.routeReader = routeReader;
	}

	public FactoryTrain getTrainFactory() {
		return trainFactory;
	}

	public FactoryAirplane getAirplaneFactory() {
		return airplaneFactory;
	}

	public FactoryBoat getBoatFactory() {
		return boatFactory;
	}

	public IVisitor getiVisitor() {
		return iVisitor;
	}

	public EntityManager getHubManager() {
		return hubManager;
	}

	public void setHubManager(EntityManager hubManager) {
		this.hubManager = hubManager;
	}

	public EntityManager getVehicleManager() {
		return vehicleManager;
	}

	public void setVehicleManager(EntityManager vehicleManager) {
		this.vehicleManager = vehicleManager;
	}

	public EntityManager getCompanyManager() {
		return companyManager;
	}

	public void setCompanyManager(EntityManager companyManager) {
		this.companyManager = companyManager;
	}

	public EntityManager getRouteManager() {
		return routeManager;
	}

	public void setRouteManager(EntityManager routeManager) {
		this.routeManager = routeManager;
	}

	public Iterable getRouteIter() {
		return routeIter;
	}

	public void setRouteIter(Iterable routeIter) {
		this.routeIter = routeIter;
	}
}