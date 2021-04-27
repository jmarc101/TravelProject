import java.util.ArrayList;

public class ManagerReservation implements EntityManager, IReservation, Iterable, ISubject {

	private ArrayList<Reservation> listReservations;
	private ManagerRoute managerRoute;
	private ArrayList<IObserver> obs;
	private int reservationID = 1;
	private static ManagerReservation instance;


	public static ManagerReservation getInstance() {
		if (instance == null) instance = new ManagerReservation();
		return instance;
	}
	private ManagerReservation() {

		listReservations = new ArrayList<>();
		obs = new ArrayList<>();
		 managerRoute = ManagerRoute.getInstance();
	}

	/**
	 * 
	 * @param e
	 */
	public void insert(TravelEntity e) {

		if (e instanceof Reservation) listReservations.add((Reservation) e);
		notifyObs();
	}

	/**
	 * 
	 * @param e
	 */
	public void update(TravelEntity e) {
		Reservation reservation = (Reservation) e;
		int index = -1;
		for (int i = 0; i < listReservations.size(); i++) {
			if (listReservations.get(i).getReservationID().equals(reservation.getReservationID())) {
				index = i;
			}
		}
		if (index == -1) return;
		listReservations.set(index, reservation);
		notifyObs();
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		listReservations.removeIf(e -> e.getReservationID().equals(id));
		notifyObs();
	}

	/**
	 * 
	 * @param id
	 */
	public TravelEntity read(String id) {
		for (Reservation reservation : listReservations){
			if (reservation.getReservationID().equals(id)) return reservation;
		}
		return null;
	}



	@Override
	public boolean reserveSeat(String routeID, String clientID, String seatID) {

		Route route = (Route)managerRoute.read(routeID);
		if (route == null){	return false;}
		Seat seat = null;

		for (Seat seat1 : route.getSeats()){
			if (seat1.getSeatID().equals(seatID)){
				seat = seat1;
			}
		}
		if (seat == null){ return false; }
		boolean reserved = seat.reserve(clientID);

		if (reserved){
			String resID = "r" + String.format("%8s",reservationID++).replace(' ', '0');
			insert(new Reservation(resID, clientID,routeID,seatID, seat.getPrice()));
			System.out.println("Reservation ID: "+ resID);

		}
		return reserved;
	}



	public Payment makePayment(String resId, CreditCard cc) {
		Reservation reservation = (Reservation) read(resId);
		Payment payment = new Payment(resId, cc, reservation.getPrice());
		if (!payment.makePayment()) return null;
		reservation.setPayment(payment);
		return payment;
	}

	/**
	 * 
	 * @param amount
	 * @param cc
	 */
	public boolean refundPayment(double amount, CreditCard cc) {
		// TODO - implement ManagerReservation.refundPayment
		throw new UnsupportedOperationException();
	}

	public Iterator createIterator() {
		return new ManagerIterator(this);
	}

	@Override
	public ArrayList<TravelEntity> getList() {
		ArrayList<TravelEntity> list = new ArrayList<>();
		for (Reservation reservation : listReservations){
			list.add(reservation);
		}
		return list;
	}


	public void attach(IObserver o) {
		if (obs.contains(o)) return;
		obs.add(o);
	}


	public void detach(IObserver o) {
		obs.remove(o);
	}

	public void notifyObs() {
		for (IObserver o : obs){
			o.update();
		}
	}

}