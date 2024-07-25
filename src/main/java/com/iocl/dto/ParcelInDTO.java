package com.iocl.dto;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParcelInDTO {

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
