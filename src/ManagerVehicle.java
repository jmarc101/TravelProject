import java.util.ArrayList;

public class ManagerVehicle implements Iterable, EntityManager {

	private ArrayList<Vehicle> listVehicle;

	public Iterator createIterator() {
		// TODO - implement ManagerVehicle.createIterator
		throw new UnsupportedOperationException();
	}

	public void insert(TravelEntity e) {

		if (e instanceof User) listVehicle.add((Vehicle) e);
	}


	public void update(TravelEntity e) {
		Vehicle vehicle = (Vehicle) e;
		int index = -1;
		for (int i = 0; i < listVehicle.size(); i++) {
			if (listVehicle.get(i).getVehicleID().equals(vehicle.getVehicleID())) {
				index = i;
			}
		}
		if (index == -1) return;
		listVehicle.set(index, vehicle);
	}


	public void delete(String id) {
		listVehicle.removeIf(e -> e.getVehicleID().equals(id));
	}


	public TravelEntity read(String id) {
		for (Vehicle vehicle : listVehicle){
			if (vehicle.getVehicleID().equals(id)) return vehicle;
		}

		return null;
	}
}