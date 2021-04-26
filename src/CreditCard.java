public class CreditCard {

	private String nameOnCard;
	private String creditCardNumber;
	private String creditCardExp;
	private String cvv;

	public CreditCard(String nameOnCard, String creditCardNumber, String creditCardExp, String cvv) {
		this.nameOnCard = nameOnCard;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExp = creditCardExp;
		this.cvv = cvv;
	}

	public void toStrings(){
		System.out.println("*** CreditCard Info ***");
		System.out.println("Name: " + nameOnCard + "| CC number:" +
				creditCardNumber + "| Exp: " + creditCardExp + "| CVV: " + cvv);
	}
}