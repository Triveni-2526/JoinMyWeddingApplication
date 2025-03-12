package com.Marriage.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Guest {

	private String guestName;
	private String fromAddress;
	private String toAddress;
	private LocalDate marriageDate;
	private String reason;
	private Long mobileNum;

}
