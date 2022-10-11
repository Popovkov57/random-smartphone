package com.api.randomsmartphone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Smartphone fetchSmartphoneById(Long id) {
		return repository.getReferenceById(id);
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
	public void deleteSmartphoneById(Long id) {
		repository.deleteById(id);
	}
}
