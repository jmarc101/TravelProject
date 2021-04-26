public interface IReservation {

	boolean reserveSeat(String routeID, String clientID, String seat);;


	Payment makePayment(String resId, CreditCard cc);

	boolean refundPayment(double amount, CreditCard cc);

}
