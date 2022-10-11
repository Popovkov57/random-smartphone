package com.api.randomsmartphone.service;

import java.util.List;

import com.api.randomsmartphone.model.Smartphone;

public interface SmartphoneService {

	List<Smartphone> fetchSmartphonesList();
	
	Smartphone fetchSmartphoneById(Long id);
	
	Smartphone createSmartphone(Smartphone smartphone);
}
