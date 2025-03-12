package com.Marriage.dao;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="Marriage_info")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private String guestName;
	private String fromAddress;
	private String toAddress;
	private Long mobileNum;
	private LocalDate marriageDate;
	private String pnr;
	private String MarriageStatus;
	private Double MarriagePrice;
}
