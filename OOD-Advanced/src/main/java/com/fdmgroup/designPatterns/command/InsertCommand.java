package com.fdmgroup.designPatterns.command;

public class InsertCommand implements Command {

	private int offset;
	private String text;
	private StringBuilder sb;
	
	public InsertCommand(StringBuilder sb, int offset, String text) {
		this.offset = offset;
		this.text = text;
		this.sb = sb;
	}

	public void execute() {
		sb.insert(offset, text);
	}

	public void undo() {
		int end = offset + text.length();
		sb.replace(offset, end, "");

	}

	public void redo() {
		execute();
	}

}
