package com.about280.ashleigh.phonenumber.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.about280.ashleigh.phonenumber.exception.CustomerNotFoundException;
import com.about280.ashleigh.phonenumber.exception.PhoneNumberNotFoundException;
import com.about280.ashleigh.phonenumber.persistance.dao.CustomerRepository;
import com.about280.ashleigh.phonenumber.persistance.dao.PhoneNumberRepository;
import com.about280.ashleigh.phonenumber.persistance.model.Customer;
import com.about280.ashleigh.phonenumber.persistance.model.PhoneNumber;

@ExtendWith(SpringExtension.class)
public class PhoneNumberServiceTest {

	@Mock
	private CustomerRepository customerRepository;
	
	@Mock
	private PhoneNumberRepository phoneNumberRepository;
	
	private PhoneNumberService unitUnderTest;
	
	@BeforeEach
	public void setup()
	{
		unitUnderTest = new PhoneNumberService(customerRepository,
				phoneNumberRepository);
	}

	@Test
	void testGetAllPhoneNumbersForCustomerNotFound() {
		when(customerRepository.findById(any())).thenReturn(Optional.empty());
		Assertions.assertThrows(CustomerNotFoundException.class, () -> {
			 unitUnderTest.getAllPhoneNumbersForCustomer(1l);
		  });
		
	}
	
	@Test
	void testGetAllPhoneNumbersForCustomerSuccess() {
		when(customerRepository.findById(any())).thenReturn(Optional.of(new Customer()));
		List<PhoneNumber> retval = unitUnderTest.getAllPhoneNumbersForCustomer(1l);
		assertNull(retval);
	}
	
	@Test
	void testGetAllPhoneNumbers() {
		unitUnderTest.getAllPhoneNumbers();
		verify(phoneNumberRepository, atLeast(1)).findAll();
	}
	
	@Test
	void testActivatePhoneNumberNotFound() {
		 Assertions.assertThrows(PhoneNumberNotFoundException.class, () -> {
			 unitUnderTest.activatePhoneNumber("test");
		  });
	}
	
	@Test
	void testActivatePhoneNumberSuccess() {
		when(phoneNumberRepository.findByNumber(any())).thenReturn(new PhoneNumber());
		unitUnderTest.activatePhoneNumber("test");
		verify(phoneNumberRepository, atLeast(1)).save(any());
	}

}
