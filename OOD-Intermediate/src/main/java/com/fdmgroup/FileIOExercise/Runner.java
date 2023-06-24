package com.fdmgroup.FileIOExercise;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		String file = "C:\\Windows\\Temp\\file.txt";
		String userInfoTextFile = "C:\\Windows\\Temp\\fileOfUserInfo.txt";
		String line = "This is a line of text.";
		
		FileReaderWriter fileReaderWriter = new FileReaderWriter();
		
		String fileContents = fileReaderWriter.readFile(file);
		System.out.println(fileContents);
		
		int numberOfEs = fileReaderWriter.readFileCharacterCounter(file, 'e');
		System.out.println("Number of 'e's: " + numberOfEs);
		int numberOfLs = fileReaderWriter.readFileCharacterCounter(file, 'l');
		System.out.println("Number of 'l's: " + numberOfLs);
		
//		fileReaderWriter.writeToFile(userInfoTextFile, "Travis Simpson, 4 Ox Pasture, travissimpson47@gmail.com");
//		fileReaderWriter.writeToFile(userInfoTextFile, "Holly Grinnell, 24 Belvoir Close, hollyg@gmail.com");
//		fileReaderWriter.writeToFile(userInfoTextFile, "John Doe, Avenue Road, johndoe@gmail.com");
		
		List<User> users = fileReaderWriter.readFileUserCreator(userInfoTextFile);
		for(User user : users) {
			System.out.println(user.getName() + " lives at " + user.getAddress() + " and has email address: " + user.getEmail());
		}

	}

}
