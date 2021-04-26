import java.util.ArrayList;

public class ManagerPayment implements EntityManager {

	private ArrayList<Payment> listPayment;



	public ManagerPayment() {
		listPayment = new ArrayList<>();
	}

	/**
	 * 
	 * @param e
	 */
	public void insert(TravelEntity e) {
		if (e instanceof Payment) listPayment.add((Payment) e);
	}

	/**
	 * 
	 * @param e
	 */
	public void update(TravelEntity e) {
		Payment payment = (Payment) e;
		int index = -1;
		for (int i = 0; i < listPayment.size(); i++) {
			if (listPayment.get(i).getPaymentID().equals(payment.getPaymentID())) {
				index = i;
			}
		}
		if (index == -1) return;
		listPayment.set(index, payment);
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		listPayment.removeIf(e -> e.getPaymentID().equals(id));
	}

	/**
	 * 
	 * @param id
	 */
	public TravelEntity read(String id) {
		for (Payment payment : listPayment){
			if (payment.getPaymentID().equals(id)) return payment;
		}
		return null;
	}


}