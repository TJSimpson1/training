package com.fdmgroup.designPatterns.command;

public class AppendCommand implements Command {

	StringBuilder sb;
	String text;
	int length;
	
	public AppendCommand(StringBuilder sb, String text){
		this.sb = sb;
		this.text = text;
	}
	
	public void execute() {
		length = sb.length();
		sb.append(text);
	}

	public void undo() {
		int end = sb.length();
		sb.replace(length, end, "");
	}

	public void redo() {
		sb.append(text);
	}

}
