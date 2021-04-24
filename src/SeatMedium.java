public class SeatMedium extends Seat {

	private int column;
	private int number;

	public SeatMedium(String seatID, double price, char sectionID, int column) {
		super(seatID, price, sectionID);
		this.column = column;
	}
}