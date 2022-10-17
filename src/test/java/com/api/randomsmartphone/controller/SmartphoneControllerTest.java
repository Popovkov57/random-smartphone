package com.api.randomsmartphone.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.api.randomsmartphone.model.Smartphone;
import com.api.randomsmartphone.repository.SmartphoneRepository;
import com.api.randomsmartphone.service.LoggingService;
import com.api.randomsmartphone.service.SmartphoneService;

@WebMvcTest(SmartphoneController.class)
public class SmartphoneControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TestRestTemplate restTemplate;
	
	@MockBean
	private SmartphoneRepository repository;
	
	@MockBean
	private SmartphoneService smartphoneService;
	
	@MockBean
	private LoggingService loggingService;
	
	@Test
	public void fetchSmartphoneList_shouldReturnAllSmartphone() throws Exception {
		
		//arrange
		List<Smartphone> list = new ArrayList<>();
		list.add(new Smartphone("Apple", "Iphone 14", "Iphone Details", new Date(Long.parseLong("1666023484269"))));
		list.add(new Smartphone("Samsung", "Galaxy Z", "Samsung Details", new Date(Long.parseLong("1666023484269"))));
		list.add(new Smartphone("Google", "Pixel", "Pixels Details", new Date(Long.parseLong("1666023484269"))));

		//act
		given(smartphoneService.fetchSmartphonesList(null))
		.willReturn(list);
		
		//assert
		mockMvc.perform(MockMvcRequestBuilders.get("/smartphone")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
	}

	@Test
	public void fetchSmartphoneById_shouldReturnOneSmartphone() throws Exception {
	
		//arrange
		Smartphone mockedSmartphone = new Smartphone(
				"Apple", "Iphone 14", "Iphone Details", new Date(Long.parseLong("1666023484269")));
		ResponseEntity<Smartphone> mockedResponse = ResponseEntity
				.ok(mockedSmartphone);
	
		//act
		given(smartphoneService.fetchSmartphoneById(Long.parseLong("1")))
		.willReturn(mockedResponse);

		//assert
		mockMvc.perform(MockMvcRequestBuilders.get("/smartphone/1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("brand").value("Apple"));
	}
}
