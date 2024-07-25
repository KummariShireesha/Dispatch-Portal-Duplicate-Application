package com.iocl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iocl.entity.IOCLEmployees;

public interface IOCLEmployeeRepository extends JpaRepository<IOCLEmployees,Integer>{

}
