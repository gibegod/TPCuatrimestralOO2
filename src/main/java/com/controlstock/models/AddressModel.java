package com.controlstock.models;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AddressModel {
	
	private int id;
	
	@Size(min= 3, message= "City must have at least 3 characters")
	private String city;
	
	@Size(min= 3, message= "Street must have at least 3 characters")
	private String street;
	
	@Positive(message="Number must be positive")
	private int number;

	private float latitude;	

	private float longitude;
	
	public AddressModel() {};
	
	public AddressModel(int id, String city, String street, int number, float latitude, float longitude) {
		super();
		this.setId(id);
		this.city = city;
		this.street = street;
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public boolean equals(AddressModel addressmodel) {
		return addressmodel.getLatitude() == latitude && addressmodel.getLongitude() == longitude;
	}
}