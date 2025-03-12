package com.Marriage.service;


import com.Marriage.binding.Guest;
import com.Marriage.binding.MarriageBookingInfromation;


public interface BookService {

	public MarriageBookingInfromation bookMarriage(Guest guest);
	public MarriageBookingInfromation getMarriageInformation(String pnr);
	public MarriageBookingInfromation updateMarriageInfo(String pnr, Guest guest);
	public boolean cancelMarriage(String pnr);
	
}
