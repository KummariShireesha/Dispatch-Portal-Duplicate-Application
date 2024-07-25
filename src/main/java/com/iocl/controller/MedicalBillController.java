package com.iocl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iocl.dto.MedicalBillDTO;
import com.iocl.entity.MedicalBillEntity;
import com.iocl.service.MedicalBillService;

@RestController
@RequestMapping("/medical/bill")
public class MedicalBillController {
//	@Autowired
//	private MedicalBillService service;
//	@PostMapping("/entry")
//	public ResponseEntity<MedicalBillEntity> addMedicalBill(@RequestBody MedicalBillDTO dto){
//		
//		return service.addMedicalBill(dto);
//		
//	}
//	@GetMapping("/history")
//	public ResponseEntity<MedicalBillEntity> getMedicalBills(){
//		return service.getMedicalBills();
//		
//	}
//	
//	

}
