package com.api.randomsmartphone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.randomsmartphone.exception.ResourceNotFoundException;
import com.api.randomsmartphone.model.Smartphone;
import com.api.randomsmartphone.repository.SmartphoneRepository;
import com.api.randomsmartphone.service.SmartphoneService;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

	@Autowired
	private SmartphoneRepository repository;
	
	@Override
	public List<Smartphone> fetchSmartphonesList() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Smartphone> fetchSmartphoneById(Long id) {
		
		Smartphone smartphone = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Smartphone with ID: " + id + " not found !"));
		
		return ResponseEntity.ok().body(smartphone);
	}

	@Override
	public Smartphone createSmartphone(Smartphone smartphone) {
		Smartphone newSmartphone = new Smartphone(
				smartphone.getBrand(),
				smartphone.getModel(),
				smartphone.getDetails(),
				smartphone.getReleased()
		);
		return repository.save(newSmartphone);
	}

	@Override
	public ResponseEntity<Smartphone> updateSmartphone(Long id, Smartphone smartphone) {
		Smartphone psmartphone = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Smartphone with ID: " + id + " not found !"));
		smartphone.setId(psmartphone.getId());
		repository.save(smartphone);
		return ResponseEntity.ok(smartphone);
	}

	@Override
	public ResponseEntity<String> deleteSmartphoneById(Long id) {
		Smartphone smartphone = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Smartphone with ID: " + id + " not found !"));
		repository.deleteById(smartphone.getId());
		return ResponseEntity.ok("Smartphone deleted with success!");
		
	}
}
