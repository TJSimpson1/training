package com.fdmgroup.io;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author Travis Simpson
 * 
 * @version 1.0
 * 
 * This class is used to read and write to/from a file.
 *
 */

public class FileIO {
	
	private Logger logger = LogManager.getLogger(FileIO.class);
	
//	public void writeToFile(String file, String line) {
//		
//		BufferedWriter bufferedWriter = null;
//		try {
//			FileWriter fileWriter = new FileWriter(file, true);
//			bufferedWriter = new BufferedWriter(fileWriter);
//			bufferedWriter.write(line);
//			bufferedWriter.newLine();
//			System.out.println("Line written to file");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				bufferedWriter.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	/**
	 * This method writes a line of text to a file.
	 * 
	 * @param file - The path of the file to write the line to.
	 * @param line - The line of text to be written to the file.
	 */
	public void writeToFile(String file, String line) {
		logger.debug("File is: " + file + " --- Line is: " + line);
		logger.trace("Entering writeToFile method.");
		
		try (FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);) {
			logger.trace("Entering try block in writeToFile method.");
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			logger.info("Line written to file.");
		} catch (IOException e) {
			logger.error("Problem writing to file.");
			e.printStackTrace();
		}
	}

	/**
	 * This method reads a given file.
	 * 
	 * @param file - The path of the file to be read.
	 * @return - A string with the contents of the text file.
	 */
	public String readFile(String file) {
		String currentLine;
		StringBuffer fileContents = new StringBuffer();
		
		try(FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);){
			while((currentLine = bufferedReader.readLine()) != null) {
				fileContents.append(currentLine + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileContents.toString();
	}
}
