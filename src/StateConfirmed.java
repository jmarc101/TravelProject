public class StateConfirmed implements IState {
	Seat seat;

	public StateConfirmed(Seat seat) {
		this.seat = seat;
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean reserve(String clientID) {
		// TODO - implement ConfirmedState.reserve
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param clientID
	 */
	public boolean freeSeat(String clientID) {
		// TODO - implement ConfirmedState.freeSeat
		throw new UnsupportedOperationException();
	}

	public boolean isAvailable() {

		return false;
	}

}