package com.fdmgroup.academyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Academy;
import com.fdmgroup.academyapi.repository.AcademyDAO;

@Service
public class AcademyService {

	@Autowired
	private AcademyDAO academyDAO;
	
	public List<Academy> getAllAcademies(){
		return academyDAO.findAll();	
	}
	
	public Academy createAcademy(Academy academy) {
		Academy existingAcademy = academyDAO.findByName(academy.getName());
		if (existingAcademy == null) {
			return academyDAO.save(academy);
		}
		return null;
	}
	
	public Academy getAcademy(int academyId) {
		Optional<Academy> academy = academyDAO.findById(academyId);
		
		if (academy.isPresent()) {
			return academy.get();
		}
		return null;
	}
	
	public boolean updateAcademy(Academy academy) {
		if (academyDAO.existsById(academy.getId())) {
			academyDAO.save(academy);
			return true;
		}
		return false;
	}
	
	public boolean removeAcademy(int academyId) {
		if (academyDAO.existsById(academyId)) {
			academyDAO.deleteById(academyId);
			return true;
		}
		return false;
	}
		
	public Academy getAcademyByCity(String name) {
		return academyDAO.findByName(name);
	}
	
}
