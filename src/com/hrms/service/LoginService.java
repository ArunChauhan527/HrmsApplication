package com.hrms.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginService {

	
	String getLogin(String username,String password) throws JsonProcessingException;
	
}