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
import com.fdmgroup.academyapi.models.Stream;
import com.fdmgroup.academyapi.models.Trainee;
import com.fdmgroup.academyapi.service.TraineeService;

@RestController
@RequestMapping("/api/v1/trainee")
@CrossOrigin(origins="http://localhost:3000")
public class TraineeController {

	@Autowired
	private TraineeService traineeService;
	
	@GetMapping
	public List<Trainee> getAlltrainees(){
		return traineeService.getAlltrainees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trainee> gettrainee(@PathVariable int id){	
		Trainee trainee = traineeService.getTrainee(id);
		
		if (trainee != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(trainee);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTrainee(@PathVariable int id){
		if (traineeService.removetrainee(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Trainee> createtrainee(@RequestBody Trainee trainee){	
		Trainee createdTrainee = traineeService.createTrainee(trainee);
		
		if (createdTrainee != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{traineeId}")
					.buildAndExpand(createdTrainee.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping
	public ResponseEntity<Trainee> updateBook(@RequestBody Trainee trainee) {
		
		if (traineeService.updateTrainee(trainee)) {
			return ResponseEntity.ok(trainee);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("academy")
	public List<Trainee> getAlltraineesByAcademy(@RequestBody Academy academy){		
		return traineeService.getTraineesByAcademy(academy);
	}
	
	@GetMapping("stream")
	public List<Trainee> getAlltraineesByTrainee(@RequestBody Stream stream){	
		return traineeService.getTraineesByStream(stream);
	}
	
}
