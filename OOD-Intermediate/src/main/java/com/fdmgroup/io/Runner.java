package com.fdmgroup.io;

public class Runner {

	public static void main(String[] args) {
		String file = "C:\\Windows\\Temp\\file.txt";
		String line = "This is a line of text.";
		
		FileIO fileIO = new FileIO();
		fileIO.writeToFile(file, line);
				
		String fileContents = fileIO.readFile(file);
		System.out.println(fileContents);

	}

}
