import java.util.ArrayList;

public abstract class Seat extends TravelEntity {

	private String seatID;
	private double price;
	private String clientID;
	private IState IState;
	private char sectionID;
	private int column;
	private int number;


	public Seat(double price, char sectionID, int column, int number) {
		this.seatID = "C" + column + "|N" + number;
		this.price = price;
		this.sectionID = sectionID;
		this.column = column;
		this.number = number;

		IState = new StateAvailable();
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public void setState(IState IState) {
		this.IState = IState;
	}

	public char getSectionID() {
		return sectionID;
	}

	public void setSectionID(char sectionID) {
		this.sectionID = sectionID;
	}


	public boolean setState() {
		// TODO - implement Seat.setState
		throw new UnsupportedOperationException();
	}

	public IState getState() {
		return this.IState;
	}

	public Route getRoute() {
		// TODO - implement Seat.getRoute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean reserve(String clientID) {
		// TODO - implement Seat.reserve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean freeSeat(String clientID) {
		// TODO - implement Seat.freeSeat
		throw new UnsupportedOperationException();
	}

	public boolean isAvailable() {

		return IState.isAvailable();
	}

	public IState getIState() {
		return IState;
	}

	public void setIState(IState IState) {
		this.IState = IState;
	}
}