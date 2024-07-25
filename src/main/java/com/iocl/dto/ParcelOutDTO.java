package com.iocl.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelOutDTO {
	
	
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

}
