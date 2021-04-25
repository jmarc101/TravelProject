import java.util.ArrayList;

public abstract class Section extends TravelEntity {

	protected Class sectionClass;
	ArrayList<Seat> seats;
	double companyPrice;

	public Section(Class sectionClass, double companyPrice) {
		this.sectionClass = sectionClass;
		this.companyPrice = companyPrice;
		seats = new ArrayList<>();

		createSeat();

	}


	private void createSeat(){
		int numSeats = sectionClass.getMaxCapacity();
		int numCol = 6;
		int seatPerCol = numSeats / 6;
		int extraSeat = numSeats % 6;

		for (int i = 1; i <= numCol; i++) {
			for (int j = 1; j <=seatPerCol ; j++) {
				addSeat(new SeatMedium(companyPrice, sectionClass.getId(), i, j));
			}
		}
		for (int i = 0; i < extraSeat; i++) {
			addSeat(new SeatMedium(companyPrice,sectionClass.getId(),7,i));
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