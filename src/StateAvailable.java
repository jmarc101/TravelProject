public class StateAvailable implements IState {

    public StateAvailable() {
    }

    /**
     *
     * @param clientID
     */
    public boolean reserve(String clientID) {
        // TODO - implement AvailableState.reserve
        throw new UnsupportedOperationException();
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