package com.api.randomsmartphone.utils;

import java.util.Comparator;

import com.api.randomsmartphone.model.Smartphone;

public class SortSmartphoneByName implements Comparator<Smartphone>{
	
	private String sortByName;
	
	public SortSmartphoneByName(String sortByName) {
		this.sortByName = sortByName;
	}

	@Override
	public int compare(Smartphone o1, Smartphone o2) {
		
		if (this.sortByName.equals("asc")) {
			return o1.getBrand().compareTo(o2.getBrand());
		}
		if (this.sortByName.equals("dsc")) {
			return -(o1.getBrand().compareTo(o2.getBrand()));
		}
		return 0;
		
	}
	
}
