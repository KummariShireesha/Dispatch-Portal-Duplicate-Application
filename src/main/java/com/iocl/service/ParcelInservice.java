package com.iocl.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iocl.dto.ParcelInDTO;
import com.iocl.entity.ParcelInEntity;
import com.iocl.repository.ParcelInRepository;

@Service
public class ParcelInservice {
	@Autowired
	private ParcelInRepository repository;

	@Autowired
	private ModelMapper mapper;

	public ResponseEntity<ParcelInEntity> saveParcel(ParcelInDTO dto) {

		try {
			System.out.println("DETO:: " + dto);
			ParcelInEntity parcel = mapper.map(dto, ParcelInEntity.class);
//			ParcelInEntity parcel=new ParcelInEntity();
//			parcel.setEntryDateT
//			parcel.setReceivedFrom(dto.getReceivedFrom());
//			parcel.setToWhom(dto.getToWhom());
//			parcel.setModeOfReceipt(dto.getModeOfReceipt());
//			parcel.setDeliveryNumber(dto.getDeliveryNumber());
//			parcel.setDesignation(dto.getDesignation());
//			parcel.setPhoneNumber(dto.getPhoneNumber());

			ParcelInEntity parcelIn = repository.save(parcel);
			return new ResponseEntity<>(parcelIn, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<ParcelInEntity>> getAllInParcels() {
		// TODO Auto-generated method stub

		List<ParcelInEntity> InParcelsHistory = repository.findAll();
		
		if(!InParcelsHistory.isEmpty()) {
		return new ResponseEntity<>(InParcelsHistory,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	}

	
	public ResponseEntity<ParcelInEntity> updateParcel(Long inEntryId, ParcelInDTO dto) {
		// TODO Auto-generated method stub
	
	ParcelInEntity parc=repository.findByInEntryId(inEntryId);
		if(parc!=null) {
			ParcelInEntity parcel=mapper.map(dto ,ParcelInEntity.class);
			parcel.setInEntryId(parc.getInEntryId());
		ParcelInEntity	updateParcel=repository.save(parcel);
			return new ResponseEntity<>(updateParcel,HttpStatus.OK);
			}
		return ResponseEntity.notFound().build();
		
		
	}

	public ResponseEntity<ParcelInEntity> deleteParcel(Long parcelId) {
		
	if(!repository.existsById(parcelId)){
	   return ResponseEntity.notFound().build();
	  }
	    repository.deleteById(parcelId);
		return ResponseEntity.noContent().build();
	}

	

}
