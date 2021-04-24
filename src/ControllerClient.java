public class ControllerClient extends Controller {

	private IVisitor IVisitor;

	EntityManager paymentManager;;
	EntityManager reservationManager;
	EntityManager routeManager;

	public ControllerClient() {
		super();
		paymentManager = new ManagerPayment();
		reservationManager = new ManagerReservation();
		routeManager = new ManagerRoute();
	}



	/**
	 *
	 * @param clientID
	 * @param seat
	 */
	public boolean reserveSeat(String clientID, Seat seat) {
		// TODO - implement ControllerClient.reserveSeat
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param reservationID
	 */
	public boolean paySeat(String reservationID) {
		// TODO - implement ControllerClient.paySeat
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param amount
	 * @param cc
	 */
	public boolean makePayment(double amount, CreditCard cc) {
		// TODO - implement ControllerClient.makePayment
		throw new UnsupportedOperationException();
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
	public void visit(Route route) {
		// TODO - implement ControllerClient.visit
		throw new UnsupportedOperationException();
	}

}