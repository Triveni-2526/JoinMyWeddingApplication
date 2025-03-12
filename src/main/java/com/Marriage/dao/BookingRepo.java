package com.Marriage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<BookingEntity, Integer>{
	
   public BookingEntity findByPnr(String pnr);
   
}
