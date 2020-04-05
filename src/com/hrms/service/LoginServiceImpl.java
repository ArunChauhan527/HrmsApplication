package com.hrms.service;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService {

	@Override
	public String getLogin(String username, String password) throws JsonProcessingException {
		// TODO Auto-generated method stub
		try{
		   String url ="";
		   String result="";
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost postUrl = new HttpPost(url);
			postUrl.setEntity(new StringEntity(""));
			HttpResponse response = client.execute(postUrl);
            if(response.getStatusLine().getStatusCode()==200)
            {
            	result = EntityUtils.toString(response.getEntity());
            }
            else
            {
            	result = EntityUtils.toString(response.getEntity());
            }
			
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

}
