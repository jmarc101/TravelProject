import java.util.ArrayList;

public class ControllerClient extends Controller {

	private IVisitor iVisitor;

	EntityManager paymentManager;;
	EntityManager reservationManager;
	EntityManager routeManager;
	Iterable routeIter;
	IRoutes router;
	IReservation iReservation;

	public ControllerClient() {
		super();
		paymentManager = new ManagerPayment();
		reservationManager = new ManagerReservation();
		routeManager = ManagerRoute.getInstance();
		routeIter = (Iterable) routeManager;
		iVisitor = new ClientIVisitor();
		router = (IRoutes) routeManager;
		iReservation = (IReservation) reservationManager;

	}

	public boolean reserveSeat(String routeID, String clientID, String seatID) {
		return iReservation.reserveSeat(routeID, clientID, seatID);
	}

	/**
	 *
	 * @param reservationID
	 */
	public boolean makePayment(String reservationID,CreditCard card) {
		Payment payment = iReservation.makePayment(reservationID, card);
		if (payment == null) return false;

		paymentManager.insert(payment);
		return true;
	}

	/**
	 *
	 * @param amount
	 * @param cc
	 */
	public boolean refundPayment(double amount, CreditCard cc) {
		// TODO - implement ControllerClient.refundPayment
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param route
	 */
	public void visit(Route route, char classID) {
		iVisitor.visit(route, classID);
	}

	public ArrayList<Route> getRoutesByHub(String vehicleType, char section, String startHubID, String endHubID){
		return router.getRoutesByHub(vehicleType, section, startHubID, endHubID);
	}

	public ArrayList<Route> getRoutesByDate(String vehicleType, char section, String date){
		return router.getRoutesByDate(vehicleType,section,date);
	}

	public ArrayList<Route> getAllRoutes(){
		return router.getAllRoutes();
	}

	public IVisitor getIVisitor() {
		return iVisitor;
	}

	public EntityManager getPaymentManager() {
		return paymentManager;
	}

	public EntityManager getReservationManager() {
		return reservationManager;
	}

	public EntityManager getRouteManager() {
		return routeManager;
	}

	public Iterable getRouteIter() {
		return routeIter;
	}

	public Iterator getReservationIterator(){
		return ((Iterable) reservationManager).createIterator();
	}
}