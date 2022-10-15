package com.api.randomsmartphone.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.randomsmartphone.model.Smartphone;

public interface SmartphoneService {

	List<Smartphone> fetchSmartphonesList();
	
	ResponseEntity<Smartphone> fetchSmartphoneById(Long id);
	
	Smartphone createSmartphone(Smartphone smartphone);
	
	ResponseEntity<Smartphone> updateSmartphone(Long id, Smartphone smartphone);
	
	ResponseEntity<String> deleteSmartphoneById(Long id);
	
	ResponseEntity<Smartphone> getRandomSmartphone();
}
