import java.util.ArrayList;

public abstract class Vehicle extends TravelEntity {


	private String vehicleID;
	private int maxCapacity;
	private ArrayList<Section> sections;

	public Vehicle(String vehicleID, ArrayList<Section> sections) {
		this.vehicleID = vehicleID;
		this.sections = sections;
	}

	public String getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public ArrayList<Section> getSections() {
		return sections;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}

	/**
	 * 
	 * @param section
	 */
	public void addSection(Section section) {
		// TODO - implement Vehicle.addSection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param section
	 */
	public void modifySection(Section section) {
		// TODO - implement Vehicle.modifySection
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param section
	 */
	public void deleteSection(Section section) {
		// TODO - implement Vehicle.deleteSection
		throw new UnsupportedOperationException();
	}


}