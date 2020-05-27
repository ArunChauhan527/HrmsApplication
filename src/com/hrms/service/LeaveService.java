package com.hrms.service;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LeaveService {

	String leavePolicy(String company) throws JsonProcessingException;
	HashMap<String, Object> leavesCount(String empId,String industry);
	
}
