package com.api.randomsmartphone.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "smartphones")
public class Smartphone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "released")
	private Date released;

	public Smartphone() {}
	
	public Smartphone(String brand, String model, String details, Date released) {
		this.brand = brand;
		this.model = model;
		this.details = details;
		this.released = released;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Date getReleased() {
		return released;
	}
	
	public void setReleased(Date released) {
		this.released = released;
	}

	@Override
	public String toString() {
		return "Smartphone [id=" + id + ", brand=" + brand + ", model=" + model + ", details=" + details + ", released="
				+ released + "]";
	}
}
