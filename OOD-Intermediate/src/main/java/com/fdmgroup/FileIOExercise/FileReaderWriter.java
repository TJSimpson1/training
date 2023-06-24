package com.fdmgroup.FileIOExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
	
	public void writeToFile(String file, String line) {
		try(FileWriter fileWriter = new FileWriter(file, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);){
			bufferedWriter.write(line);
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
	
	public int readFileCharacterCounter(String file, char character) {
		int counter = 0;
		String currentLine;
		StringBuffer fileContents = new StringBuffer();
		
		try(FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);){
			while((currentLine = bufferedReader.readLine()) != null) {
				fileContents.append(currentLine + "\n");
				for(int index = 0; index < currentLine.length(); index++) {
					if(currentLine.charAt(index) == character) {
						counter++;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return counter;
		
	}
	
	public List<User> readFileUserCreator(String file) {
		List<User> users = new ArrayList<User>();
		String currentLine;
		StringBuffer fileContents = new StringBuffer();
		
		try(FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);){
			while((currentLine = bufferedReader.readLine()) != null) {
				fileContents.append(currentLine + "\n");
				User user = new User();
				String[] stringList = currentLine.split(", ");
				user.setName(stringList[0]);
				user.setAddress(stringList[1]);
				user.setEmail(stringList[2]);
				users.add(user);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return users;
		
	}

}
