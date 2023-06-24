package com.fdmgroup.academyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Stream;
import com.fdmgroup.academyapi.repository.LearningStreamDAO;

@Service
public class StreamService {
	@Autowired
	private LearningStreamDAO streamDAO;
	
	public List<Stream> getAllStreams(){
		return streamDAO.findAll();	
	}
	
	public Stream createStream(Stream stream) {
		if (streamDAO.findByName(stream.getName()) == null) {
			return streamDAO.save(stream);
		}
		return null;
	}
	
	public Stream getStream(int streamId) {
		Optional<Stream> stream = streamDAO.findById(streamId);
		
		if (stream.isPresent()) {
			return stream.get();
		}
		return null;
	}
	
	public boolean updateStream(Stream stream) {
		if (streamDAO.existsById(stream.getId())) {
			streamDAO.save(stream);
			return true;
		}
		return false;
	}
	
	public boolean removeStream(int streamId) {
		if (streamDAO.existsById(streamId)) {
			streamDAO.deleteById(streamId);
			return true;
		}
		return false;
	}
}
