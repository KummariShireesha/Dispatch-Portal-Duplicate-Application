package com.iocl.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PARCEL_OUT")
public class ParcelOutEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PARCEL_OUT_S")
//	@SequenceGenerator(name = "PARCEL_OUT_S",sequenceName = "PARCEL_OUT_S",allocationSize = 1)
	private String trackingId;
	
	private LocalDateTime dateTime;
	private String senderName; 	
	private String senderLocation;
	private String senderDepartment;
	private Long senderNumber;
	private String recipientName;
	private String recipientLocation;
	private String recipientDepartment;
	private Long recipientNumber;
	private Double parcelWeight;
	private String unit;//25grams
	private String barcode;
	public void setCreatedDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	public void setCreatedDate1(Date date) {
		// TODO Auto-generated method stub
		
	}
	
}
