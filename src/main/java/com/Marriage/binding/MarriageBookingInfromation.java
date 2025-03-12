package com.Marriage.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MarriageBookingInfromation {

	private String guestName;
	private String fromAddress;
	private String toAddress;
	private Long mobileNum;
	private LocalDate marriageDate;
	private String pnr;
	private String MarriageStatus;
	private Double MarriagePrice;
}

