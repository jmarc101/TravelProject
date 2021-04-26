public class Reservation extends TravelEntity {


	private String reservationID;
	private String clientID;
	private String routeID;
	private Payment payment;
	private String seatID;
	private double price;

	public Reservation(String reservationID, String clientID, String routeID, String seatID, double price) {
		this.reservationID = reservationID;
		this.clientID = clientID;
		this.routeID = routeID;
		this.seatID = seatID;
		this.price = price;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

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
		String paid = "Paid";
		if (payment == null) paid = "Unpaid";
		return "ResId:" + reservationID + "| Client:" + clientID + "| Seat:" +
				seatID + "| Route: " + routeID + "| Amount: " + price +  "| Status:" +paid;
	}

}