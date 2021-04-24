public interface IReservation {

	/**
	 * 
	 * @param clientID
	 * @param seat
	 */
	boolean reserveSeat(String clientID, Seat seat);

	/**
	 * 
	 * @param reservationID
	 */
	boolean paySeat(String reservationID);

}