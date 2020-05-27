package com.hrms.service;
import java.util.Base64;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value="loginService")
public class LoginServiceImpl implements LoginService {
    @Value("${resource.url}")
	private String url;
	@Override
	public String getLogin(String username, String password) throws JsonProcessingException {
		try{
			/* String url =""; */
		   String result="";
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost postUrl = new HttpPost(url+"/loginDB");
			System.out.println(postUrl);
			HashMap<String ,String> request =new HashMap<String, String>();
			request.put("username", username);
			request.put("password", Base64.getEncoder().encodeToString(password.getBytes()));
			postUrl.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(request)));
               System.out.println(new ObjectMapper().writeValueAsString(request));
			HttpResponse response = client.execute(postUrl);
            if(response.getStatusLine().getStatusCode()==200)
            {
            	result = EntityUtils.toString(response.getEntity());
            }
            else
            {
            	result = EntityUtils.toString(response.getEntity());
            }
			System.out.println(result);
			return result;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HashMap<String,String> map = new HashMap<>();
			map.put("message","Some error occured");
			ObjectMapper mapper = new ObjectMapper();
			
			return mapper.writeValueAsString(map);	
		}
		
	}
	@Override
	public HashMap<String, Object> genrateOtp(String emailid) {
		// TODO Auto-generated method stub
		try{
		
			String result ="";
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(url+"/genrateOtp?emailid="+emailid);
			HttpResponse response = client.execute(post);
			result = EntityUtils.toString(response.getEntity());
			HashMap<String, Object> map = new ObjectMapper().readValue(result, HashMap.class);
			return map;
			
		}catch (Exception e) {
			// TODO: handle exception
			HashMap<String, Object> map = new HashMap<>();
			map.put("message", e.getMessage());
			return map;
		}
		
	}
	@Override
	public String changePassword(HashMap<String, Object> map) throws JsonProcessingException {
		// TODO Auto-generated method stub
		try{
			
			String result="";
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost postUrl = new HttpPost(url+"/otpChangePassword");
			System.out.println(postUrl);
			postUrl.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(map)));
			HttpResponse response = client.execute(postUrl);
            if(response.getStatusLine().getStatusCode()==200)
            {
            	result = EntityUtils.toString(response.getEntity());
            }
            else
            {
            	result = EntityUtils.toString(response.getEntity());
            }
			System.out.println(result);
			return result;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			HashMap<String,String> map1 = new HashMap<>();
			map.put("message","Some error occured");
			ObjectMapper mapper = new ObjectMapper();
			
			return mapper.writeValueAsString(map1);	
		}
		

	}

}
