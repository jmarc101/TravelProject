import java.util.Stack;

public class CommandHistory {
	private Stack<IUndoableCommand> listCommands;
	public CommandHistory() {
		this.listCommands = new Stack<>();
	}



	/**
	 * 
	 * @param uc
	 */
	public void push(IUndoableCommand uc) {
		listCommands.push(uc);
	}

	public IUndoableCommand pop() {
		return listCommands.pop();
	}

}