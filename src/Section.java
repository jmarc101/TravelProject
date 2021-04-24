import java.util.ArrayList;

public abstract class Section extends TravelEntity {

	protected Class sectionClass;
	ArrayList<Seat> seats;
	double companyPrice;
	int id = 0;

	public Section(Class sectionClass, double companyPrice) {
		this.sectionClass = sectionClass;
		this.companyPrice = companyPrice;
		seats = new ArrayList<>();

		int numSeats = sectionClass.getMaxCapacity();

		for (int i = 0; i < numSeats; i++) {
			addSeat(new SeatNarrow(String.valueOf(++id), companyPrice, sectionClass.getId(), 1));
		}
	}



	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setPrice() {
		// TODO - implement Section.setPrice
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param seat
	 */
	public void addSeat(Seat seat) {

		this.seats.add(seat);
	}

	/**
	 * 
	 * @param seat
	 */
	public boolean modifySeat(Seat seat) {
		// TODO - implement Section.modifySeat
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param seat
	 */
	public boolean deleteSeat(Seat seat) {
		// TODO - implement Section.deleteSeat
		throw new UnsupportedOperationException();
	}


}