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
import com.iocl.entity.ParcelInEntity;
import com.iocl.service.ParcelInservice;

@RestController
@RequestMapping("/parcels/in")
public class ParcelInController {
	@Autowired
	private ParcelInservice service;
	@PostMapping("/create")
	public ResponseEntity<ParcelInEntity> saveParcel(@RequestBody ParcelInDTO dto){
		return service.saveParcel(dto);
		
	}
	
	@GetMapping("/history")
	public ResponseEntity<List<ParcelInEntity>> getAllInParcels(){
		return service.getAllInParcels();
		
	}

	@PutMapping("/update/{inEntryId}")
	public ResponseEntity<ParcelInEntity> updateParcel(@PathVariable Long inEntryId,@RequestBody ParcelInDTO dto){
		return service.updateParcel(inEntryId,dto);
		
	}
	@DeleteMapping("/delete/{parcelId}")
	public ResponseEntity<ParcelInEntity> deleteParcel(@PathVariable Long parcelId){
		return service.deleteParcel(parcelId);
		
	}

}
