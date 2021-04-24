public class SeatNarrow extends Seat {
	private int column;
	private int number;


	public SeatNarrow(String seatID, double price, char sectionID, int column) {
		super(seatID, price, sectionID);
		this.column = column;
	}



}