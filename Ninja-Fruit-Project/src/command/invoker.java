package command;

import interfaces.Command;

public class invoker {
	Command myCommand;
	public invoker(Command newCommand) {
		myCommand = newCommand;
	}
	
	public void execute() {
		myCommand.execute();
	}
}
