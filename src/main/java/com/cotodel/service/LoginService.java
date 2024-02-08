package com.cotodel.service;

import com.cotodel.response.UserRegistrationRequest;

public interface LoginService {

	String sendOtp(String userName, String mobile);
	String verifyOtp(String userName, String mob, String otp);
	String registerUser(UserRegistrationRequest userForm);
	String verifyRegisterUser(UserRegistrationRequest userForm);
	public void sendEmailToEmployee(UserRegistrationRequest userForm);
	public void sendEmailVerificationCompletion(UserRegistrationRequest userForm);

}
