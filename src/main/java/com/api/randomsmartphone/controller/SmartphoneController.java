package com.api.randomsmartphone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.randomsmartphone.model.Smartphone;
import com.api.randomsmartphone.service.SmartphoneService;

@RestController
public class SmartphoneController {
	
	@Autowired
	private SmartphoneService smartphoneService;
	
    @GetMapping("/smartphone") 
    public List<Smartphone> fetchSmartphoneList() { 
        return smartphoneService.fetchSmartphonesList();
    }
    
    @GetMapping(path="/smartphone/{id}")
    public Smartphone fetchSmartphoneById(@PathVariable Long id) {
    	return smartphoneService.fetchSmartphoneById(id);
    }
}
