package com.fdmgroup.designPatterns.command;

public class Client {

	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		
		StringBuilder receiver = new StringBuilder();
		
		invoker.runCommand(new AppendCommand(receiver,"this "));
		invoker.runCommand(new AppendCommand(receiver,"is "));
		invoker.runCommand(new AppendCommand(receiver,"a "));
		invoker.runCommand(new AppendCommand(receiver,"sentence "));		
		invoker.runCommand(new InsertCommand(receiver,10,"short "));
		System.out.println(receiver);
		
		invoker.undoCommand();
		System.out.println(receiver);
		
		invoker.undoCommand();
		System.out.println(receiver);
		
		invoker.redoCommand();
		System.out.println(receiver);
		
		invoker.redoCommand();
		System.out.println(receiver);
	}

}
