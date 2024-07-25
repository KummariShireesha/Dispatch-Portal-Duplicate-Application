package com.iocl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.dto.IOCLEmployeesDTO;
import com.iocl.service.IOCLEmployeeService;

@RestController
@RequestMapping("/Iocl/employees")
public class EmployeeController {
	@Autowired
	private IOCLEmployeeService service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "WELCOME TO TAPSO";
		
	}
	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody IOCLEmployeesDTO dto){
		return service.saveEmployee(dto);
		
	}
	@GetMapping("/get/all")
	public ResponseEntity<?> getAllEmployees(){
		return service.getAllEmployees();
		
	}
	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer employeeId){
		return service.deleteEmployeesById(employeeId);
		
	}
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<?> updateEmployeeById(@PathVariable Integer employeeId,@RequestBody IOCLEmployeesDTO dto){
		return service.updateEmployeeById(employeeId,dto);
		
	}
	@GetMapping("/get/employeeId/{employeeId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId){
		return service.getEmployeeById(employeeId);
		
	}
}
