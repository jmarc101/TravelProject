import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class ManagerRoute implements EntityManager, Iterable, IRoutes {

	private ArrayList<Route> listRoutes = new ArrayList<>();
	private static ManagerRoute instance;

	private ManagerRoute() {
	}


	public static ManagerRoute getInstance() {
		if (instance == null) instance = new ManagerRoute();
		return instance;
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

	public ArrayList<Route> getAllRoutes() {

		return listRoutes;
	}

	public Iterator createIterator() {
		Iterator iter = new ManagerIterator(this, listRoutes);
		return iter;
	}


	@Override
	public ArrayList<Route> getRoutesByHub(String vehicleType, char section, String startHubID, String endHubID) {
		ArrayList<Route> list = new ArrayList<>();

		for (Route route : listRoutes) {
			if ((route.getStartHubID().equals(startHubID) && route.getEndHubID().equals(endHubID))) {

				switch (vehicleType) {
					case "airplane" -> {
						if (route.getVehicle() instanceof VehicleAirplane)
							list.add(route);
					}
					case "boat" -> {
						if (route.getVehicle() instanceof VehicleBoat)
							list.add(route);
					}
					case "train" -> {
						if (route.getVehicle() instanceof VehicleTrain)
							list.add(route);
					}
				}
			}
		}


		return list;
	}

	@Override
	public ArrayList<Route> getRoutesByDate(String vehicleType, char section, String date) {

		ArrayList<Route> list = new ArrayList<>();

		for (Route route : listRoutes){

			switch (vehicleType){
				case "airplane" -> { if (route.getVehicle() instanceof VehicleAirplane && extractDate(date, route.getDateDebut()))
					list.add(route);}
				case "boat" -> {if (route.getVehicle() instanceof VehicleBoat && extractDate(date, route.getDateDebut()))
					list.add(route);}
				case "train" -> {if (route.getVehicle() instanceof VehicleTrain && extractDate(date, route.getDateDebut()))
					list.add(route);}
			}
		}
		return list;
	}
	public boolean extractDate(String dateWanted, String dateRoute){
		if (dateWanted.length()<9) return false;
		return dateRoute.substring(0, 9).equals(dateWanted.substring(0, 9));
	}

}
