package com.about280.ashleigh.phonenumber.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.about280.ashleigh.phonenumber.persistance.model.PhoneNumber;
import com.about280.ashleigh.phonenumber.service.PhoneNumberService;

@ExtendWith(SpringExtension.class)
public class PhoneNumberControllerTest {
	
	@Mock
	private PhoneNumberService phoneNumberService;
	
	@InjectMocks
	PhoneNumberController unitUnderTest = new PhoneNumberController();
	
	@Test
	void testActivatePhoneNumber() throws Exception {
		ResponseEntity<Void> entity = unitUnderTest.activatePhoneNumber("test");
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
	@Test
	void testGetAllPhoneNumbers() throws Exception {
		ResponseEntity<List<PhoneNumber>> entity = unitUnderTest.getAllPhoneNumbers();
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

	@Test
	void testGetAllPhoneNumbersForCustomer() throws Exception {
		ResponseEntity<List<PhoneNumber>> entity = unitUnderTest.getAllPhoneNumbersForCustomer(1l);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}
	
}
