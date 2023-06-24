package com.fdmgroup.academyapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.academyapi.models.Academy;
import com.fdmgroup.academyapi.service.AcademyService;


@RestController
@RequestMapping("/api/v1/academy")
@CrossOrigin(origins="http://localhost:3000")
public class AcademyController {

	@Autowired
	private AcademyService academyService;
	
	@GetMapping
	public List<Academy> getAcademies(){
		return academyService.getAllAcademies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Academy> getAcademy(@PathVariable int id){	
		Academy academy = academyService.getAcademy(id);
		
		if (academy != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(academy);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAcademy(@PathVariable int id){
		if (academyService.removeAcademy(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Academy> createAcademy(@RequestBody Academy academy){
		Academy createdAcademy = academyService.createAcademy(academy);
		
		if (createdAcademy != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{academyId}")
					.buildAndExpand(createdAcademy.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping
	public ResponseEntity<Academy> updateBook(@RequestBody Academy academy) {
		
		if (academyService.updateAcademy(academy)) {
			return ResponseEntity.ok(academy);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Academy> getAcademyByCity(@PathVariable("name")String name){
		Academy academy = academyService.getAcademyByCity(name);
		
		if (academy != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(academy);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
