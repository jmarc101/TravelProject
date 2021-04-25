import java.util.ArrayList;

public abstract class Vehicle extends TravelEntity {


	private String vehicleID;
	private int maxCapacity;
	private ArrayList<Section> sections;

	public Vehicle(String vehicleID, ArrayList<Section> sections) {
		this.vehicleID = vehicleID;
		this.sections = sections;
		setMaxCapacity();
	}

	public void setMaxCapacity(){
		int total = 0;
		for (Section section : sections){
			total += section.sectionClass.getMaxCapacity();
		}
		maxCapacity = total;
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

	public ArrayList<Seat> getSeats(){
		ArrayList<Seat> list = new ArrayList<>();
		for (Section section : sections){
			list.addAll(section.seats);
		}

		return list;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}

	public void toStrings(){};

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