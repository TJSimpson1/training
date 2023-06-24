package com.fdmgroup.json.example;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Runner {

	public static void main(String[] args) {
		Academy academy = new Academy();
		academy.setLocation("London");
		academy.setAddress("Cottons Centre");
		academy.setPopup(false);
		
		Trainee trainee = new Trainee();
		trainee.setName("John Smith");
		trainee.setAcademy(academy);
		trainee.setStream("Java");
		trainee.setSignedOff(true);
		
//		Academy academy = new Academy("London", "Cottons Center", false);
//		Trainee trainee = new Trainee("John Smith", "Java", academy, true); //Does not work by default when using constructors with arguments
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		//File file = new File("/Users/bvcott/Desktop/trainee.json"); //Mac
		File file = new File("c:\\temp\\trainee.json"); //Windows
		
			try {
				objectMapper.writeValue(file, trainee);
				Trainee traineeFromFile = objectMapper.readValue(file, Trainee.class);
				System.out.println(traineeFromFile.getName());
				System.out.println(traineeFromFile.getAcademy().getLocation());
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		

	}

}
