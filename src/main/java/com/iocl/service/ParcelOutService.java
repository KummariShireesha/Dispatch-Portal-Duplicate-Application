package com.iocl.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.iocl.dto.ParcelOutDTO;
import com.iocl.entity.ParcelOutEntity;
import com.iocl.repository.ParcelOutRepository;

@Service
public class ParcelOutService {
	@Autowired
	private ParcelOutRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	private static final String TRACKING_NAME_PREFIX="IOCL";

	public ResponseEntity<ParcelOutEntity> createOutParcel(ParcelOutDTO dto) {
	try{
		System.out.println("DTO:"+ dto);
		 ParcelOutEntity parcel=mapper.map(dto,ParcelOutEntity.class);
		 String lastUsedTrackingName = getLastUsedTrackingName();
	        
	        // Generate the next tracking name
	        String nextTrackingName = generateNextTrackingName(lastUsedTrackingName);
	        parcel.setTrackingId(nextTrackingName);
	       //parcels.add(parcel);
	        ParcelOutEntity insert = repository.save(parcel);
	        return new ResponseEntity<>(insert, HttpStatus.OK);
	}
	catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	 private String getLastUsedTrackingName() {
	        List<ParcelOutEntity> parcels = repository.findAllByOrderByTrackingIdDesc();
	        if (!parcels.isEmpty()) {
	            ParcelOutEntity lastParcel = parcels.get(0);
	            return lastParcel.getTrackingId();
	        }
	        return null;
	 }// If no parcels are present in the database, return null
	 private String generateNextTrackingName(String lastUsedTrackingName) {
	        if (lastUsedTrackingName != null) {
	            String serialNumberStr = lastUsedTrackingName.substring(TRACKING_NAME_PREFIX.length());
	            int serialNumber = Integer.parseInt(serialNumberStr);
	            serialNumber++; // Increment the serial number
	            if (serialNumber < 10) {
	                return TRACKING_NAME_PREFIX + "0" + serialNumber;
	            } else {
	                return TRACKING_NAME_PREFIX + serialNumber;
	            }
       
	        } else {
	            return TRACKING_NAME_PREFIX+ "01";
	        }
	 }
// If no parcels are present in the database, start from IOCL

	
	
	public ResponseEntity<List<ParcelOutEntity>> getAllOutParcels() {
		// TODO Auto-generated method stub
		
	  List<ParcelOutEntity>	records=repository.findAll();
      if(records.isEmpty()) {
		   return ResponseEntity.notFound().build();
	   }
	return new ResponseEntity<>(records,HttpStatus.OK);
	
	}//all close
	

	public ResponseEntity<ParcelOutEntity> updateParcelOut(String trackingId, ParcelOutDTO dto) {
		
	ParcelOutEntity	id=repository.findByTrackingId(trackingId);
	if(id!=null) {
	ParcelOutEntity	parcel=mapper.map(dto, ParcelOutEntity.class);
	         parcel.setTrackingId(id.getTrackingId());
	        ParcelOutEntity parcels=repository.save(parcel);
	        return new ResponseEntity<>(parcels,HttpStatus.OK);
	}
	return ResponseEntity.notFound().build();
      
	}




	public ResponseEntity<ParcelOutEntity> cancelParcelOut(String trackingId) {
		
	ParcelOutEntity	id=repository.findByTrackingId(trackingId);
	if(id!=null) {
		  ParcelOutEntity  parcel=mapper.map(id,ParcelOutEntity.class);
		  parcel.setTrackingId(id.getTrackingId());
		 repository.deleteById(trackingId);
		 
		 return new ResponseEntity<>(HttpStatus.OK);
	}
		return ResponseEntity.notFound().build();
		
	}

}
//
//	public ResponseEntity<List<ParcelOutEntity>> getTrackingNumber(Long recipientPhoneNumber) {
//		// TODO Auto-generated method stub
//		if(!repository.existsByRecipientPhoneNumber(recipientPhoneNumber)) {
//			return ResponseEntity.notFound().build();
//		}
//	    List<ParcelOutEntity> trackingids=repository.findAll();
//		
//		return new ResponseEntity<>(trackingids,HttpStatus.OK);
//	}


