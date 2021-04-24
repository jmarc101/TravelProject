public interface IVisitor {

    /**
     *
     * @param route
     */
    void visit(Route route);
    void visit(Route route, char classID);

}