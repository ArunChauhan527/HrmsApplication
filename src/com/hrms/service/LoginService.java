package com.hrms.service;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService {

	
	String getLogin(String username,String password) throws JsonProcessingException;
	HashMap<String, Object> genrateOtp(String emailid);
	String changePassword(HashMap<String, Object> map) throws JsonProcessingException;
	
}