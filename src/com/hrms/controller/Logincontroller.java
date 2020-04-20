package com.hrms.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.model.Registration;
import com.hrms.service.LoginService;

@Controller
public class Logincontroller {

	@Autowired
	@Qualifier("loginService")
	LoginService loginService;
	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		return new ModelAndView("Login");
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/logincheck")
	public ModelAndView loginCheck(@RequestParam("username")String username,@RequestParam("password")String password,HttpServletRequest request)
	{ 
		ModelAndView mv =null;
	   try{
		  
		  String response =  loginService.getLogin(username, password);
		   
		  if(response.contains("{\"message"))
		  {
			 mv = new ModelAndView("Login");
			 HashMap<String , String> map = new HashMap<>();
			 ObjectMapper mapper = new ObjectMapper();
			 map = mapper.readValue(response, HashMap.class);
			 mv.addObject("errorMsg", map.get("message"));
			 
 		  }
		  else
		  {
			  mv = new ModelAndView("Dashboard");
				 ObjectMapper mapper = new ObjectMapper();
				 Registration  map = mapper.readValue(response, Registration.class);
				 mv.addObject("Registration", map);
		  }
		   
	   }catch (Exception e) {
		// TODO: handle exception
	}
		return mv;
	}
}
