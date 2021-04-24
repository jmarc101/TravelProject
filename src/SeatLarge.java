public class SeatLarge extends Seat {
	private int column;
	private int number;


	public SeatLarge(String seatID, double price, char sectionID, int column) {
		super(seatID, price, sectionID);
		this.column = column;
	}


}