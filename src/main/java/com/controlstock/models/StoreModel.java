package com.controlstock.models;

import java.util.Set;

import javax.validation.constraints.Min;

public class StoreModel {

	private int id;
	
	private AddressModel address;

	@Min(value = 99999, message= "Description must have at least 6 characters")
	private long phoneNumber;

	private Set<EmployeeModel> setEmployees;

	private Set<BatchModel> setBatchs;

	public StoreModel() {}

	public StoreModel (int id, AddressModel address, long phoneNumber, Set<EmployeeModel> setEmployees, 
			Set<BatchModel> setBatchs) {
		super();
		setId(id);
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.setEmployees = setEmployees;
		this.setBatchs = setBatchs;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<EmployeeModel> getSetEmployees() {
		return setEmployees;
	}

	public void setSetEmployees(Set<EmployeeModel> setEmployees) {
		this.setEmployees = setEmployees;
	}
	
	public Set<BatchModel> getSetBatchs() {
		return setBatchs;
	}

	public void setSetBatchs(Set<BatchModel> setBatchs) {
		this.setBatchs = setBatchs;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreModel other = (StoreModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
