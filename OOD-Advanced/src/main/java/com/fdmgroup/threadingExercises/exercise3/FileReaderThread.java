package com.fdmgroup.threadingExercises.exercise3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderThread extends Thread{
	private AverageCalculator averageCalculator = new AverageCalculator();
	private String fileName;
	
	public FileReaderThread(AverageCalculator averageCalculator, String fileName) {
		super();
		this.averageCalculator = averageCalculator;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		String currentLine;
		StringBuffer fileContents = new StringBuffer();
		
		try(FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);){
			while((currentLine = bufferedReader.readLine()) != null) {
				fileContents.append(currentLine + "\n");
				String[] stringArray = currentLine.split(",");
				for(String string : stringArray) {
					int eachNumber = Integer.parseInt(string);
					averageCalculator.addToTotal(eachNumber);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
