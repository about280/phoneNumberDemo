package com.about280.ashleigh.phonenumber.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.about280.ashleigh.phonenumber.persistance.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>  {

}
