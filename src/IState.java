public interface IState {

    /**
     *
     * @param clientID
     */
    boolean reserve(String clientID);

    /**
     *
     * @param clientID
     */
    boolean freeSeat(String clientID);

    boolean isAvailable();

}