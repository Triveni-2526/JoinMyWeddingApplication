package com.Marriage.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Marriage.binding.Guest;
import com.Marriage.binding.MarriageBookingInfromation;
import com.Marriage.service.BookService;


@RestController
public class MarriageController {

	private BookService bookService;

	public MarriageController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping(value = "/bookMarriage", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<MarriageBookingInfromation> bookMarriageFromController(@RequestBody Guest guest) {
		MarriageBookingInfromation marrInfo = bookService.bookMarriage(guest);
		System.out.println("post method ended...");
		return new ResponseEntity<MarriageBookingInfromation>(marrInfo, HttpStatus.OK);


	}

	@GetMapping("/getInfo/{pnr}")

	// produces= {"application/{pnr}"};
	// consumes = {"application/json"};
	public ResponseEntity<MarriageBookingInfromation> getMarriageFromRestController(@PathVariable String pnr) {
		MarriageBookingInfromation MarrInformation = bookService.getMarriageInformation(pnr);
		return new ResponseEntity<MarriageBookingInfromation>(MarrInformation, HttpStatus.OK);

	}

	@PutMapping("/updateInfo/{pnr}")

	// produces= {"application/json"},
	// consumes = {"application/json"})

	public ResponseEntity<MarriageBookingInfromation> updateTicket(@PathVariable String pnr, @RequestBody Guest guest) {
		MarriageBookingInfromation updatedInfo = bookService.updateMarriageInfo(pnr, guest);
		return new ResponseEntity<MarriageBookingInfromation>(updatedInfo, HttpStatus.OK);
		
	}

	@DeleteMapping("/cancel/{pnr}")
	// produces= {"application/{pnr}"};
	// consumes = {"application/mesg"};
	public ResponseEntity<String> cancelTicket(@PathVariable String pnr) {
		boolean isDeleted = bookService.cancelMarriage(pnr);
		if (isDeleted) {
			return new ResponseEntity<>("I am Not Interested to join this marriage,so this " + pnr + " has been cancelled.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("BookingNum is not found with this Pnr " + pnr, HttpStatus.NOT_FOUND);
		}
		
	}
}
