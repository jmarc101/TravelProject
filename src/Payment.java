public class Payment extends TravelEntity {

	private String reservationID;
	private double amount;
	private CreditCard creditCard;

	public Payment(String reservationID, CreditCard creditCard, double amount) {
		this.reservationID = reservationID;
		this.creditCard = creditCard;
		this.amount = amount;
	}

	public String getPaymentID() {
		return reservationID;
	}

	public void setPaymentID(String paymentID) {
		this.reservationID = paymentID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void toStrings(){
		System.out.println("ResID: " + reservationID + "| Amount: " + amount);
		creditCard.toStrings();
	}

	public boolean makePayment() {
		// creditcard machine stuff with cc info
		return true;
	}


}