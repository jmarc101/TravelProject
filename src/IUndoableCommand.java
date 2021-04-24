public interface IUndoableCommand {

    void execute();

    void unexecute();

    boolean isUndoable();

}