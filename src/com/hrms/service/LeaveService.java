package com.hrms.service;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hrms.model.Leave;

public interface LeaveService {

	String leavePolicy(String company) throws JsonProcessingException;
	
	HashMap<String, Object> leavesCount(String empId,String industry);
	
	HashMap<String, Object> appliedeaves(String empId,String industry);
	
}
