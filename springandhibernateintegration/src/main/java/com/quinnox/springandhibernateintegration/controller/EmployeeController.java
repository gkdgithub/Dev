package com.quinnox.springandhibernateintegration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quinnox.springandhibernateintegration.model.Employee;
import com.quinnox.springandhibernateintegration.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	@Qualifier(value="employeeService1")
	private EmployeeService employeeService;
	
	@RequestMapping(value={"/","/list"}, method=RequestMethod.GET)
	public String listEmployees(Model model){
		List<Employee> employees=employeeService.findAllEmployees();
		model.addAttribute("employees",employees);
		return "allemployees";		
	}
	
	@GetMapping(value="/new")
	public ModelAndView newEmployee(){
		Employee employee=new Employee();
		ModelAndView modelAndView=new ModelAndView("employeeForm");
		modelAndView.addObject("employee", employee);
		return modelAndView;		
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, 
			ModelMap modelMap){
		
		if(bindingResult.hasErrors()){
			return "employeeForm";
		}
		employeeService.saveEmployee(employee);
		modelMap.addAttribute("message","Employee "+employee.getName()+" Got registered successfully ");
		return "success";
	}
	
	@GetMapping(value="/edit")
	public String editEmployee(@RequestParam("id") int id, Model model){
		Employee employee=employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employeeForm";		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int id){
		employeeService.deleteEmployeeById(id);
		return "redirect:/list";	
	}
	
}
