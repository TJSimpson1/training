package com.fdmgroup.designPatterns.command;

import java.util.Stack;

public class Invoker {

	Stack<Command> executed = new Stack<Command>(); 
	Stack<Command> undone = new Stack<Command>();
	
	public void runCommand(Command command){
		command.execute();
		executed.push(command);
	}
	
	public void undoCommand(){
		Command command = executed.pop();
		command.undo();
		undone.push(command);
	}
	
	public void redoCommand(){
		Command command = undone.pop();
		command.redo();
		executed.push(command);
	}
	
	
}
