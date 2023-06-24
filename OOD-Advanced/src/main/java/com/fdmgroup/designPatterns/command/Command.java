package com.fdmgroup.designPatterns.command;

public interface Command {

	public void execute();
	public void undo();
	public void redo();
	
}
