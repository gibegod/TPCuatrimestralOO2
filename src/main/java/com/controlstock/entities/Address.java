package com.controlstock.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String city;
	
	@NotNull
	private String street;
	
	@NotNull
	private int number;
	
	@NotNull
	private float latitude;
	
	@NotNull
	private float longitude;
	
	public Address() {};
	
	public Address(int id, String city, String street, int number, float latitude, float longitude) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/*
	public Address (int id) {
		this.id = id;
	}
	*/
	
	/*
	public Address(String city, String street, int number, float latitude, float longitude) {
		super();
		this.city = city;
		this.street = street;
		this.number = number;
		this.latitude = latitude;
		this.longitude = longitude;
	}*/


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
	
	public boolean equals(Address address) {
		return address.getLatitude() == latitude && address.getLongitude() == longitude;
	}
	
}
