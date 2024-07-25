package com.iocl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.iocl.dto.IOCLEmployeesDTO;
import com.iocl.entity.IOCLEmployees;
import com.iocl.repository.IOCLEmployeeRepository;
@Service
public class IOCLEmployeeService {
	@Autowired
	private IOCLEmployeeRepository repository;

	public ResponseEntity<?> saveEmployee(IOCLEmployeesDTO dto) {
	
		IOCLEmployees employees=new IOCLEmployees();	
	    employees.setEmployeeId(dto.getEmployeeId());
		employees.setEmployeeName(dto.getEmployeeName());
		employees.setEmployeePassword(dto.getEmployeePassword());
		employees.setDesignation(dto.getDesignation());
		employees.setEmailId(dto.getEmailId());
		employees.setPhoneNumber(dto.getPhoneNumber());
		
		 IOCLEmployees   emp=repository.save(employees);
		 
		return new ResponseEntity<>(emp,HttpStatus.CREATED);
	}

	public ResponseEntity<?> getAllEmployees() {
		// TODO Auto-generated method stub
	List<IOCLEmployees>	 employees=repository.findAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

	public ResponseEntity<?> deleteEmployeesById(Integer employeeId) {
		if(!repository.existsById(employeeId))
			return ResponseEntity.notFound().build();
		repository.deleteById(employeeId);
		return ResponseEntity.noContent().build();
		// TODO Auto-generated method stub
		
	}

	
	public ResponseEntity<?> updateEmployeeById(Integer employeeId, IOCLEmployeesDTO dto) {
		if(!repository.existsById(employeeId))
			return ResponseEntity.notFound().build();
		IOCLEmployees employees=new IOCLEmployees();
		employees.setEmployeeId(dto.getEmployeeId());
		employees.setEmployeeName(dto.getEmployeeName());
		employees.setEmployeePassword(dto.getEmployeePassword());
		employees.setDesignation(dto.getDesignation());
		employees.setEmailId(dto.getEmailId());
		employees.setPhoneNumber(dto.getPhoneNumber());
		repository.save(employees);
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}

	public ResponseEntity<?> getEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		
	Optional<IOCLEmployees>	employee=repository.findById(employeeId);
		
		return employee.map(ResponseEntity :: ok).orElse(ResponseEntity.notFound().build());
	}


}
