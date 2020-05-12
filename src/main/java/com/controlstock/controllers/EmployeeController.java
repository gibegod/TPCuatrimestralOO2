package com.controlstock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.controlstock.helpers.ViewRouteHelper;
import com.controlstock.models.EmployeeModel;
import com.controlstock.services.IAddressService;
import com.controlstock.services.IEmployeeService;
import com.controlstock.services.IStoreService;
import com.controlstock.services.implementation.StoreService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	
	@GetMapping("")
	public ModelAndView index () {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLOYEE_INDEX);
		mAV.addObject("employees", employeeService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLOYEE_NEW);
		mAV.addObject("employee", new EmployeeModel());
		mAV.addObject("stores", storeService.getAll());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("employee") EmployeeModel employeeModel) {
		employeeService.insert(employeeModel);
		return new RedirectView(ViewRouteHelper.EMPLOYEE_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLOYEE_UPDATE);
		mAV.addObject("employee", employeeService.findById(id));
		mAV.addObject("stores", storeService.getAll());
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("employee") EmployeeModel employeeModel) {
		employeeService.update(employeeModel);
		return new RedirectView(ViewRouteHelper.EMPLOYEE_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete (@PathVariable("id") int id) {
		employeeService.remove(id);
		return new RedirectView(ViewRouteHelper.EMPLOYEE_ROOT);
	}
		
}
