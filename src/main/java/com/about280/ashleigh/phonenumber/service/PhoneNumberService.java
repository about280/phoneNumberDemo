package com.about280.ashleigh.phonenumber.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.about280.ashleigh.phonenumber.exception.CustomerNotFoundException;
import com.about280.ashleigh.phonenumber.exception.PhoneNumberNotFoundException;
import com.about280.ashleigh.phonenumber.persistance.dao.CustomerRepository;
import com.about280.ashleigh.phonenumber.persistance.dao.PhoneNumberRepository;
import com.about280.ashleigh.phonenumber.persistance.model.Customer;
import com.about280.ashleigh.phonenumber.persistance.model.PhoneNumber;

@Service
public class PhoneNumberService implements PhoneNumberServiceInterface {

	private final CustomerRepository customerRepository;
	
	private final PhoneNumberRepository phoneNumberRepository;
	
	@Autowired
	public PhoneNumberService(CustomerRepository customerRepository,
			PhoneNumberRepository phoneNumberRepository) {
		this.customerRepository = customerRepository;
		this.phoneNumberRepository = phoneNumberRepository;
	}
    
	public void activatePhoneNumber(String number) {
		PhoneNumber phoneNumber = phoneNumberRepository.findByNumber(number);
		if (phoneNumber == null) {
			throw new PhoneNumberNotFoundException();
		}
		phoneNumber.setActive(true);
		phoneNumberRepository.save(phoneNumber);
	}
	
	public List<PhoneNumber> getAllPhoneNumbersForCustomer(Long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isEmpty()) {
			throw new CustomerNotFoundException();
		}
		return customer.get().getPhoneNumbers();
    }
	
    public List<PhoneNumber> getAllPhoneNumbers() {
    	return phoneNumberRepository.findAll();
    }

}
