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

import com.fdmgroup.academyapi.models.Stream;
import com.fdmgroup.academyapi.service.StreamService;

@RestController
@RequestMapping("/api/v1/stream")
@CrossOrigin(origins="http://localhost:3000")
public class StreamController {

	@Autowired
	private StreamService streamService;
	
	@GetMapping
	public List<Stream> getStreams(){
		return streamService.getAllStreams();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Stream> getLearningStream(@PathVariable int id){	
		Stream stream = streamService.getStream(id);
		
		if (stream != null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(stream);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLearningStream(@PathVariable int id){
		if (streamService.removeStream(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping
	public ResponseEntity<Stream> createLearningStream(@RequestBody Stream stream){
		Stream createdStream = streamService.createStream(stream);
		
		if (createdStream != null) {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{LearningStreamId}")
					.buildAndExpand(createdStream.getId())
					.toUri();
			return ResponseEntity
					.created(location)
					.build();
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
	@PutMapping
	public ResponseEntity<Stream> updateBook(@RequestBody Stream stream) {
		
		if (streamService.updateStream(stream)) {
			return ResponseEntity.ok(stream);
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
