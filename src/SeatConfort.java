public class SeatConfort extends Seat {

	public SeatConfort(String seatID, double price, char sectionID, int column) {
		super(seatID, price, sectionID);
		this.column = column;
	}

	private int column;
	private int number;

}