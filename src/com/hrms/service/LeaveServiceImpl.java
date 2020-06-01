package com.hrms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.model.Leave;

@Service
public class LeaveServiceImpl  implements LeaveService{

	@Value("${resource.url}")
	String url;
	
	@Override
	public String leavePolicy(String company) throws JsonProcessingException {
		// TODO Auto-generated method stub
		
		try{
			
			String result="";
			
			HttpClient client  = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url+"/adminLeave?company="+company);
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode()==200)
			{
			
				result = EntityUtils.toString(response.getEntity());
			}
			else
			{
				result = EntityUtils.toString(response.getEntity());
			}
			
			
			return result;
		}
		catch (Exception e) {
			// TODO: handle exception
		HashMap<String, Object> result  = new HashMap<>();
		result.put("message", e.getMessage());
		return new ObjectMapper().writeValueAsString(result);
		
		}
		
	}

	@Override
	public HashMap<String, Object> leavesCount(String empId, String industry) {
		// TODO Auto-generated method stub
		try
		{
           String result="";
			
			HttpClient client  = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url+"/leavesCount?empId="+empId+"&industry="+industry);
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode()==200)
			{
			
				result = EntityUtils.toString(response.getEntity());
			}
			else
			{
				result = EntityUtils.toString(response.getEntity());
			}
			
			HashMap<String, Object> map = new ObjectMapper().readValue(result, HashMap.class);
			
			return map;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			HashMap<String, Object> map = new HashMap<>();
			map.put("message", e.getMessage());
			return map;
		}
	}

	@Override
	public HashMap<String, Object> appliedeaves(String empId, String industry) {
		// TODO Auto-generated method stub
		try
		{
		
			 String result="";
				
				HttpClient client  = HttpClientBuilder.create().build();
				HttpPost post = new HttpPost(url+"/appliedLeaves?empId="+empId+"&industry="+industry);
				HttpResponse response = client.execute(post);
				if(response.getStatusLine().getStatusCode()==200)
				{
				
					result = EntityUtils.toString(response.getEntity());
				}
				else
				{
					result = EntityUtils.toString(response.getEntity());
				}
				
				HashMap<String, Object> map = new ObjectMapper().readValue(result,HashMap.class);
				
				return map;
			
		}
		catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
			HashMap<String, Object> map = new HashMap<>();
			map.put("message", e.getMessage());
			return map;
		}
		
	}

}
