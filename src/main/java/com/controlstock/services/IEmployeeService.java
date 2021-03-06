package com.controlstock.services;

import java.util.List;
import java.util.Set;

import com.controlstock.entities.Employee;
import com.controlstock.models.EmployeeModel;

public interface IEmployeeService {
	
	public List<Employee> getAll();
	
	public EmployeeModel findById(int id);
	
	public EmployeeModel insertOrUpdate(EmployeeModel employeeModel);
	
	public boolean remove(int id);

	EmployeeModel insert(EmployeeModel employeeModel);

	EmployeeModel update(EmployeeModel employeeModel);
	
	public List<Employee> getEmployeeByStore(int idStore);
	
	public void calculatePay(Employee e, int idSale);
	
	public Set<Employee> setSalarys(String date);
	
}
