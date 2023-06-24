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
import com.fdmgroup.academyapi.models.Course;
import com.fdmgroup.academyapi.models.Trainer;
import com.fdmgroup.academyapi.service.TrainerService;

@RestController
@RequestMapping("/api/v1/trainer")
@CrossOrigin(origins="http://localhost:3000")
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	@GetMapping
	public List<Trainer> getTrainers(){
		return trainerService.getAllTrainers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable int id){	
		Trainer trainer = trainerService.getTrainer(id);
		
		if (trainer != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(trainer);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrainer(@PathVariable int id){
		if (trainerService.removeTrainer(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
		Trainer createdTrainer = trainerService.createTrainer(trainer);
		
		if (createdTrainer != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{TrainerId}")
					.buildAndExpand(createdTrainer.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping
	public ResponseEntity<Trainer> updateBook(@RequestBody Trainer trainer) {
		
		if (trainerService.updateTrainer(trainer)) {
			return ResponseEntity.ok(trainer);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("academy")
	public List<Trainer> getAllTrainersByAcademy(@RequestBody Academy academy){	
		return trainerService.listTrainersByAcademy(academy);
	}
	
	@GetMapping("course")
	public List<Trainer> getAllTrainersByCourse(@RequestBody Course course){	
		return trainerService.listTrainersByCourse(course);
	}
	
}
