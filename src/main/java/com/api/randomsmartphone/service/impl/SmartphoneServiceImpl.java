package com.api.randomsmartphone.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.randomsmartphone.exception.ResourceNotFoundException;
import com.api.randomsmartphone.model.Smartphone;
import com.api.randomsmartphone.repository.SmartphoneRepository;
import com.api.randomsmartphone.service.SmartphoneService;
import com.api.randomsmartphone.utils.SortSmartphoneByName;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

	@Autowired
	private SmartphoneRepository repository;
	
	Logger logger = LoggerFactory.getLogger(SmartphoneServiceImpl.class);
	
	@Override
	public List<Smartphone> fetchSmartphonesList(String sortByName) {
		List<Smartphone> list = repository.findAll();
		if(sortByName != null) {
			Collections.sort(list, new SortSmartphoneByName(sortByName));
		}
		return list;
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

	@Override
	public ResponseEntity<Smartphone> getRandomSmartphone() {
		Random random = new Random();
		List<Smartphone> list = repository.findAll();
		return ResponseEntity.ok(list.get(random.nextInt(list.size())));
	}
}
