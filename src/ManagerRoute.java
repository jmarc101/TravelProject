import java.util.ArrayList;
import java.util.Date;

public class ManagerRoute implements EntityManager, Iterable, IRoutes {

	private ArrayList<Route> listRoutes;

	public ManagerRoute() {
		listRoutes = new ArrayList<>();
	}

	/**
	 * @param e
	 */
	public void insert(TravelEntity e) {
		if (e instanceof Route) listRoutes.add((Route) e);
	}

	/**
	 * @param id
	 */
	public TravelEntity read(String id) {
		for (Route route : listRoutes) {
			if (route.getRouteID().equals(id)) return route;
		}
		return null;
	}

	/**
	 * @param e
	 */
	public void update(TravelEntity e) {
		Route route = (Route) e;
		int index = -1;
		for (int i = 0; i < listRoutes.size(); i++) {
			if (listRoutes.get(i).getRouteID().equals(route.getRouteID())) {
				index = i;
			}
		}
		if (index == -1) return;
		listRoutes.set(index, route);
	}

	/**
	 * @param id
	 */
	public void delete(String id) {
		listRoutes.removeIf(e -> e.getRouteID().equals(id));

	}

	public ArrayList<Route> getListRoutes() {
		return listRoutes;
	}

	public Iterator createIterator() {
		Iterator iter = new ManagerIterator(this, listRoutes);
		return iter;
	}

	/**
	 * @param companyID
	 */
	public ArrayList<Route> getRoutesByCompany(String companyID) {
		// TODO - implement ManagerRoute.getRoutesByCompany
		throw new UnsupportedOperationException();
	}

	/**
	 * @param startHubID
	 * @param endHubID
	 */
	public ArrayList<Route> getRoutesByHub(String startHubID, String endHubID) {
		// TODO - implement ManagerRoute.getRoutesByHub
		throw new UnsupportedOperationException();
	}

	/**
	 * @param date
	 */
	public ArrayList<Route> getRoutesByDate(Date date) {
		// TODO - implement ManagerRoute.getRoutesByDate
		throw new UnsupportedOperationException();
	}
}
