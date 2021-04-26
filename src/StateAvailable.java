public class StateAvailable implements IState {

    Seat seat;
    public StateAvailable(Seat seat) {
        this.seat = seat;
    }

    /**
     *
     * @param clientID
     */
    public boolean reserve(String clientID) {
        seat.setClientID(clientID);
        seat.setiState(new StateReserved(seat));
        return true;
    }

    /**
     *
     * @param clientID
     */
    public boolean freeSeat(String clientID) {
        return true;
    }

    public boolean isAvailable() {
        return true;
    }

}