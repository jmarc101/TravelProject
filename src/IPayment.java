public interface IPayment {

	/**
	 * 
	 * @param amount
	 * @param cc
	 */
	boolean makePayment(double amount, CreditCard cc);

	/**
	 * 
	 * @param amount
	 * @param cc
	 */
	boolean refundPayment(double amount, CreditCard cc);

}