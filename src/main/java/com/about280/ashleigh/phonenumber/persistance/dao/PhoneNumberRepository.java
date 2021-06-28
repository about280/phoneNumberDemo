package com.about280.ashleigh.phonenumber.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.about280.ashleigh.phonenumber.persistance.model.PhoneNumber;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long>  {

	PhoneNumber findByNumber(String number);
}
