package com.about280.ashleigh.phonenumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.about280.ashleigh.phonenumber.persistance.model.PhoneNumber;
import com.about280.ashleigh.phonenumber.service.PhoneNumberServiceInterface;

@RestController
public class PhoneNumberController {

	@Autowired
	private PhoneNumberServiceInterface phoneNumberService;
	
	@PostMapping(value = "/phoneNumbers/{phoneNumber}/activate")
	public ResponseEntity<Void> activatePhoneNumber(
			@PathVariable String phoneNumber) {
		phoneNumberService.activatePhoneNumber(phoneNumber);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/customer/{customerId}/phoneNumbers")
	public ResponseEntity<List<PhoneNumber>> getAllPhoneNumbersForCustomer(@PathVariable Long customerId) {
		return ResponseEntity.ok().body(phoneNumberService.getAllPhoneNumbersForCustomer(customerId));
	}
	
	@GetMapping(value = "/phoneNumbers")
	public ResponseEntity<List<PhoneNumber>> getAllPhoneNumbers() {
        return ResponseEntity.ok().body(phoneNumberService.getAllPhoneNumbers());
	}

}
