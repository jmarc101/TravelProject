import java.util.ArrayList;

public class ControllerClient extends Controller {

	private IVisitor iVisitor;

	EntityManager paymentManager;;
	EntityManager reservationManager;
	EntityManager routeManager;
	Iterable routeIter;
	IRoutes router;
	IReservation iReservation;
	ArrayList<ISubject> iSubjects;

	public ControllerClient() {
		super();
		paymentManager = new ManagerPayment();
		reservationManager = ManagerReservation.getInstance();
		routeManager = ManagerRoute.getInstance();
		routeIter = (Iterable) routeManager;
		iVisitor = new ClientIVisitor();
		router = (IRoutes) routeManager;
		iReservation = (IReservation) reservationManager;
		iSubjects = new ArrayList<>();

	}

	public boolean reserveSeat(String routeID, String clientID, String seatID) {
		if (iReservation.reserveSeat(routeID, clientID, seatID)){
			notifyObs();
			return true;
		}
		return false;
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

	public void acceptVisitor(IVisitable subject){
		subject.acceptVisitor(iVisitor);
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


	public ArrayList<Route> getRoutesByHub(String vehicleType, String startHubID, String endHubID){
		return router.getRoutesByHub(vehicleType, startHubID, endHubID);
	}

	public ArrayList<Route> getRoutesByDate(String vehicleType, String date){
		return router.getRoutesByDate(vehicleType,date);
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