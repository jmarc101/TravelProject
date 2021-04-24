public class Payment extends TravelEntity {

	private String paymentID;
	private String clientID;
	private String seatID;
	private double amount;
	private Reservation reservation;



	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public Payment getPayment() {
		// TODO - implement Payment.getPayment
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ccINfo
	 */
	public boolean makePayment(String ccINfo) {
		// TODO - implement Payment.makePaiement
		throw new UnsupportedOperationException();
	}

}