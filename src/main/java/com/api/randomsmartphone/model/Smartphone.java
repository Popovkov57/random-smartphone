package com.api.randomsmartphone.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.NonFinal;

@Entity
@Table(name = "smartphones")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
public class Smartphone {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brand")
	@NonNull String brand;
	
	@Column(name = "model")
	@NonFinal String model;
	
	@Column(name = "details")
	@NonNull String details;
	
	@Column(name = "released")
	@NonNull Date released;

	public Smartphone(@NonNull String brand, String model, @NonNull String details, @NonNull Date released) {
		this.brand = brand;
		this.model = model;
		this.details = details;
		this.released = released;
	}
}
