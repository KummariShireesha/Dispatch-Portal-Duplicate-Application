package com.iocl.controller;

import java.util.List;

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

import com.iocl.dto.ParcelInDTO;
import com.iocl.dto.ParcelOutDTO;
import com.iocl.entity.ParcelOutEntity;
import com.iocl.service.ParcelOutService;

@RestController
@RequestMapping("/parcel/out")
public class ParacelOutController {
	@Autowired
	private ParcelOutService service;
	
	@PostMapping("/create")
	public ResponseEntity<ParcelOutEntity> createOutParcel(@RequestBody ParcelOutDTO dto){
		return service.createOutParcel(dto);
		
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<ParcelOutEntity>> getAllOutParcels(){
		return service.getAllOutParcels();
		
	}
	@PutMapping("/update/{trackingId}")
	public ResponseEntity<ParcelOutEntity> updateParcelOut(@PathVariable String trackingId,@RequestBody ParcelOutDTO dto){
		return service.updateParcelOut(trackingId,dto);
	}
	@DeleteMapping("/cancel/{trackingId}")
	public ResponseEntity<ParcelOutEntity> cancelParcelOut(@PathVariable String trackingId){
		return service.cancelParcelOut(trackingId);
		
	}
//	@GetMapping("/tracking/{recipientPhoneNumber}")
//	public ResponseEntity<List<ParcelOutEntity>> getTrackingNumber(@PathVariable Long recipientPhoneNumber ){
//		return service.getTrackingNumber(recipientPhoneNumber);
//		
//	}
	
	

}
