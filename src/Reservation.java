public class Reservation extends TravelEntity {

	private String reservationID;
	private String clientID;
	private String routeID;
	private Payment payment;
	private String seatID;

	public String getReservationID() {
		return reservationID;
	}

	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public Reservation getReservation() {
		// TODO - implement Reservation.getReservation
		throw new UnsupportedOperationException();
	}

	public boolean isValid() {
		// TODO - implement Reservation.isValid
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Reservation.toString
		throw new UnsupportedOperationException();
	}

}