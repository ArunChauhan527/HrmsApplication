package com.hrms.controller;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.model.Otp;
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
				 HashMap<String,Object>  map1 = mapper.readValue(response, HashMap.class);
				 Registration map = mapper.convertValue(map1, Registration.class);
				 mv.addObject("registration", map);
				 HttpSession session = request.getSession();
				 session.setAttribute("logindetails", map);
		  }
		   
	   }catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	}
		return mv;
	}
	
	
	@RequestMapping("sampleNationalholiday")
	public void sampleNationalholiday(HttpServletResponse response){
		
	}
	
	@RequestMapping("forgetPassword")
	public ModelAndView forgetPasswor(HttpServletResponse response){
		
		return new ModelAndView("forgetPassword");
	}
	
	@RequestMapping("forgetPasswordSubmit")
	public ModelAndView forgetPassword(@RequestParam("emailid")String emailid,HttpServletRequest request)
	{
		ModelAndView mv = null;
		try{
			
			if(emailid==null)emailid="";
			
			if(emailid.isEmpty())
			{
				mv = new ModelAndView("forgetPassword");
				mv.addObject("error", "Please enter emailId");
			}
			else{
				
				HashMap<String, Object> map =loginService.genrateOtp(emailid);
				
				if(map.containsKey("otp"))
				{
					mv = new ModelAndView("forgetPasswordSubmit");
					mv.addObject("otp", map.get("otp"));
					HttpSession session = request.getSession();
					session.setAttribute("otp", map.get("otp"));
					session.setAttribute("emailid", emailid);
				}
				else
				{
					mv = new ModelAndView("forgetPassword");
					mv.addObject("error", map.get("message"));
				}
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			mv = new ModelAndView("forgetPassword");
			mv.addObject("error", e.getMessage());
			
		}
		
		return mv;
	}
	
	
	@RequestMapping("changePassword")
	public ModelAndView changePassword(@RequestParam(value="otp",required=false)String otp,@RequestParam(value="newPassword")String newPassword,@RequestParam(value="confirmPassword")String confirmPassword,@RequestParam(value="oldPassword",required=false)String oldPassword,HttpServletRequest request){
	     ModelAndView mv = null;
		try{
			
			if(newPassword==null)newPassword="";
			if(oldPassword==null)oldPassword="";
			if(otp==null)otp="";
			if(confirmPassword==null)confirmPassword="";
			
			if(newPassword.isEmpty()&&confirmPassword.isEmpty())
			{
				mv = new ModelAndView("forgetPasswordSubmit");
				mv.addObject("error", "Please enter password");
				mv.addObject("newPassword", newPassword);
				mv.addObject("confirmPassword", confirmPassword);
				mv.addObject("oldPassword", oldPassword);
				mv.addObject("otp", otp);
				
			}
			else if(otp.isEmpty())
			{
				mv = new ModelAndView("forgetPasswordSubmit");
				mv.addObject("error", "Please enter otp");
				mv.addObject("newPassword", newPassword);
				mv.addObject("confirmPassword", confirmPassword);
				mv.addObject("oldPassword", oldPassword);
				mv.addObject("otp", otp);
			}
			
			else if(!newPassword.equals(confirmPassword))
			{
				mv = new ModelAndView("forgetPasswordSubmit");
				mv.addObject("error", "Please enter same password");
				mv.addObject("newPassword", newPassword);
				mv.addObject("confirmPassword", confirmPassword);
				mv.addObject("oldPassword", oldPassword);
				mv.addObject("otp", otp);
			}
			else 
			{
				
				
				HashMap<String, Object> map =  (HashMap<String, Object>) request.getSession().getAttribute("otp");
				
				Otp otp1 = new ObjectMapper().convertValue(map, Otp.class); 
				
			 if(!otp1.getOtp().equals(otp))
				{
					mv = new ModelAndView("forgetPasswordSubmit");
					mv.addObject("error", "incorrect otp");
					mv.addObject("newPassword", newPassword);
					mv.addObject("confirmPassword", confirmPassword);
					mv.addObject("oldPassword", oldPassword);
					mv.addObject("otp", otp);
				}
			 else{
				 
				Date date = otp1.getCreatedDate();
				Date now = Calendar.getInstance().getTime();
				SimpleDateFormat sdf  = new SimpleDateFormat("HH:mm:ss");
				String curDate = sdf.format(date);
				String nowt = sdf.format(now);
				Date otp_time = sdf.parse(curDate);
				otp_time = DateUtils.addMinutes(otp_time, 15);
				Date cur_time = sdf.parse(nowt);
				String emailid = (String) request.getSession().getAttribute("emailid");
				if(emailid==null)emailid="";
				if(otp_time.compareTo(cur_time)>=0)
				{
					HashMap<String, Object> req = new HashMap<>();
					req.put("otp", otp);
					req.put("emailid", emailid);
					req.put("password", Base64.getEncoder().encodeToString(newPassword.getBytes()));
				   HashMap<String , Object> result =	new ObjectMapper().readValue(loginService.changePassword(req), HashMap.class);
				   if(result.get("message").equals("success"))
				   {
					mv = new ModelAndView("Login");
					mv.addObject("errorMsg", "Password has been changed successfully");
				   }
				   else
				   {
					   mv = new ModelAndView("forgetPassword");
						mv.addObject("error","some error occured");
				   }
				}
				else
				{
					mv = new ModelAndView("forgetPassword");
					mv.addObject("error","otp has been expired");
				}
				
				
				
				
			}
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			mv = new ModelAndView("forgetPasswordSubmit");
			mv.addObject("error", "Some error occurs");
		}
		return mv;
	}
	
}
