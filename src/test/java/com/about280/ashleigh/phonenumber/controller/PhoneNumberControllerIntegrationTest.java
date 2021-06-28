package com.about280.ashleigh.phonenumber.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class PhoneNumberControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	void testActivatePhoneSuccess() throws Exception {
		mvc.perform(post("/phoneNumbers/99995555/activate")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	void testActivatePhoneNotFound() throws Exception {
		mvc.perform(post("/phoneNumbers/99999999/activate")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isNotFound());
	}
	
	@Test
	void testAllPhoneNumbers() throws Exception {
		mvc.perform(get("/phoneNumbers")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	void testAllPhoneNumbersForCustomer() throws Exception {
		mvc.perform(get("/customer/1/phoneNumbers")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

	@Test
	void testAllPhoneNumbersForCustomerNotFound() throws Exception {
		mvc.perform(get("/customer/11111/phoneNumbers")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isNotFound());
	}
}
