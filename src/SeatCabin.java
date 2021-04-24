import java.util.ArrayList;

public class SeatCabin extends Seat {

	public SeatCabin(String seatID, double price, char sectionID) {
		super(seatID, price, sectionID);
	}

	public ArrayList<String> getListClients() {
		return listClients;
	}

	public void setListClients(ArrayList<String> listClients) {
		this.listClients = listClients;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	private ArrayList<String> listClients;
	private int occupancy;

	public boolean asFreeSpace() {
		// TODO - implement SeatCabin.asFreeSpace
		throw new UnsupportedOperationException();
	}

}