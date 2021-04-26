public abstract class Seat extends TravelEntity {

	private String seatID;
	private double price;
	private String clientID;
	private IState iState;
	private char sectionID;
	private int column;
	private int number;


	public Seat(double price, char sectionID, int column, int number) {
		this.seatID = "" + sectionID + "C" + column + "|N" + number;
		this.price = price;
		this.sectionID = sectionID;
		this.column = column;
		this.number = number;

		iState = new StateAvailable(this);
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
		this.iState = IState;
	}

	public char getSectionID() {
		return sectionID;
	}

	public void setSectionID(char sectionID) {
		this.sectionID = sectionID;
	}



	public IState getState() {
		return this.iState;
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
		return iState.reserve(clientID);
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean freeSeat(String clientID) {
		return iState.freeSeat(clientID);
	}

	public boolean isAvailable() {

		return iState.isAvailable();
	}

	public IState getiState() {
		return iState;
	}

	public void setiState(IState iState) {
		this.iState = iState;
	}


}