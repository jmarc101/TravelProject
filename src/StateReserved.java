public class StateReserved implements IState {
	Seat seat;

	public StateReserved(Seat seat) {
		this.seat = seat;
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean reserve(String clientID) {
		// TODO - implement ReservedState.reserve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean freeSeat(String clientID) {
		// TODO - implement ReservedState.freeSeat
		throw new UnsupportedOperationException();
	}

	public boolean isAvailable() {

		return false;
	}

}