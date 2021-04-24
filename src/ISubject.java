public interface ISubject {

    /**
     *
     * @param o
     */
    void attach(IObserver o);

    /**
     *
     * @param o
     */
    void detach(IObserver o);

    void notifyObs();

}