package com.iocl.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PARCEL_IN")
public class ParcelInEntity {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARCEL_IN_S")
   @SequenceGenerator(name = "PARCEL_IN_S", sequenceName = "PARCEL_IN_S", allocationSize = 1)
    private Long inEntryId;
 
    private LocalDateTime entryDateTime;
    private String senderName;
    private String senderDepartment;
    private String senderLocation;
    private Long senderMobileNumber;
    private String toWhom;
    private String recipientDepartment;
    private Long recipientPhoneNumber;
    private String modeOfReceipt;
    private String barcodeNo;
   
}
