package com.Marriage.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.Marriage.binding.Guest;
import com.Marriage.binding.MarriageBookingInfromation;
import com.Marriage.dao.BookingEntity;
import com.Marriage.dao.BookingRepo;
import com.Marriage.dao.GuestEntity;
import com.Marriage.dao.GuestRepo;

@Service
public class BookingServiceImpl implements BookService {

	private GuestRepo guestRepo;
	private BookingRepo bookingRepo;

	public BookingServiceImpl(GuestRepo guestRepo, BookingRepo bookingRepo) {
		this.guestRepo = guestRepo;
		this.bookingRepo = bookingRepo;
	}

	@Override
	public MarriageBookingInfromation bookMarriage(Guest guest) {
		String pnr = "";
		for (int i = 1; i <= 8; i++) {
			pnr = pnr + (int) (Math.random() * 10);
		}
		MarriageBookingInfromation mi = new MarriageBookingInfromation();
		mi.setPnr(pnr);
		mi.setMarriagePrice(12754.09);
		mi.setMarriageStatus("Confirmed.... You Can Attend this Marriage....!");
		mi.setGuestName(guest.getGuestName());
		mi.setFromAddress(guest.getFromAddress());
		mi.setToAddress(guest.getToAddress());
		mi.setMobileNum(guest.getMobileNum());
		mi.setMarriageDate(LocalDate.now());

		GuestEntity guestEntity = new GuestEntity();
		BeanUtils.copyProperties(guest, guestEntity);

		guestRepo.save(guestEntity);

		BookingEntity bookEntity = new BookingEntity();
		BeanUtils.copyProperties(mi, bookEntity);
		bookingRepo.save(bookEntity);

		return mi;

	}

	@Override
	public MarriageBookingInfromation getMarriageInformation(String pnr) {
		BookingEntity byPnr = bookingRepo.findByPnr(pnr);
		MarriageBookingInfromation bookingInfo = new MarriageBookingInfromation();
		BeanUtils.copyProperties(byPnr, bookingInfo);
		return bookingInfo;

	}

	@Override
	public MarriageBookingInfromation updateMarriageInfo(String pnr, Guest guest) {

		BookingEntity bookingdata = bookingRepo.findByPnr(pnr);

		if (bookingdata == null) {
			return null;
		}

		bookingdata.setGuestName(guest.getGuestName());
		bookingdata.setFromAddress(guest.getFromAddress());
		bookingdata.setToAddress(guest.getToAddress());

		bookingRepo.save(bookingdata);

		MarriageBookingInfromation updatedInfo = new MarriageBookingInfromation();
		BeanUtils.copyProperties(bookingdata, updatedInfo);
		return updatedInfo;
		
	}

	@Override
	public boolean cancelMarriage(String pnr) {
		BookingEntity bookMEntity = bookingRepo.findByPnr(pnr);
		if (bookMEntity != null) {
			bookingRepo.delete(bookMEntity);
			return true;
		}
		return false;
	}

}
