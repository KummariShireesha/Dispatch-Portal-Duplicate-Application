package com.iocl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="IOCL_EMPLOYEES")
public class IOCLEmployees {
	@Id
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	@Column(name="PASSWORD")
	private String employeePassword;
	@Column(name="DESIGNATION")
	private String designation;
	@Column(name="EMAIL_ID")
	private String emailId;
	@Column(name="PHONE_NUMBER")
	private Long phoneNumber;	
	
}
