package com.about280.ashleigh.phonenumber.service;

import java.util.List;

import com.about280.ashleigh.phonenumber.persistance.model.PhoneNumber;


public interface PhoneNumberServiceInterface {

	public void activatePhoneNumber(String phoneNumber);

	public List<PhoneNumber> getAllPhoneNumbersForCustomer(Long customerId);
	
    public List<PhoneNumber> getAllPhoneNumbers();

}