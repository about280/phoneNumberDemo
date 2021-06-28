package com.about280.ashleigh.phonenumber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Phone number not found")
public class PhoneNumberNotFoundException extends RuntimeException {
}