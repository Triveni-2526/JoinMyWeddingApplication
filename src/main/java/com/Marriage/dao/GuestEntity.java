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
@Table(name = "Guest_info")
public class GuestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer guestId;
	private String guestName;
	private String fromAddress;
	private String toAddress;
	private LocalDate marriageDate;
	private String reason;
	private Long mobileNum;
}
