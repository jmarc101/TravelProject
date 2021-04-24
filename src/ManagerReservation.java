import java.util.ArrayList;

public class ManagerReservation implements EntityManager, IReservation, IPayment, Iterable {

	private ArrayList<Reservation> listReservations;

	public ManagerReservation() {
		listReservations = new ArrayList<>();
	}

	/**
	 * 
	 * @param e
	 */
	public void insert(TravelEntity e) {
		if (e instanceof Reservation) listReservations.add((Reservation) e);
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
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		listReservations.removeIf(e -> e.getReservationID().equals(id));
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

	/**
	 * 
	 * @param clientID
	 * @param seat
	 */
	public boolean reserveSeat(String clientID, Seat seat) {
		// TODO - implement ManagerReservation.reserveSeat
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservationID
	 */
	public boolean paySeat(String reservationID) {
		// TODO - implement ManagerReservation.paySeat
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param amount
	 * @param cc
	 */
	public boolean makePayment(double amount, CreditCard cc) {
		// TODO - implement ManagerReservation.makePayment
		throw new UnsupportedOperationException();
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
		// TODO - implement ManagerReservation.createIterator
		throw new UnsupportedOperationException();
	}

}