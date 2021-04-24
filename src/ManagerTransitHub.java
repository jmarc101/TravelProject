import java.util.ArrayList;

public class ManagerTransitHub implements EntityManager, Iterable {

	private ArrayList<TransitHub> listTransitHubs;

	public ManagerTransitHub() {
		listTransitHubs = new ArrayList<>();
	}

	/**
	 * 
	 * @param id
	 */
	public TravelEntity read(String id) {
		for (TransitHub transitHub : listTransitHubs){
			if (transitHub.getHubID().equals(id)) return transitHub;
		}
		return null;
	}

	/**
	 * 
	 * @param e
	 */
	public void insert(TravelEntity e) {
		if (e instanceof TransitHub) listTransitHubs.add((TransitHub) e);
	}

	/**
	 * 
	 * @param e
	 */
	public void update(TravelEntity e) {
		TransitHub transitHub = (TransitHub) e;
		int index = -1;
		for (int i = 0; i < listTransitHubs.size(); i++) {
			if (listTransitHubs.get(i).getHubID().equals(transitHub.getHubID())) {
				index = i;
			}
		}
		if (index == -1) return;
		listTransitHubs.set(index, transitHub);
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		listTransitHubs.removeIf(e -> e.getHubID().equals(id));

	}

	public Iterator createIterator() {
		// TODO - implement ManagerTransitHub.createIterator
		throw new UnsupportedOperationException();
	}

}