package com.hrms.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.model.Admin;
import com.hrms.model.Leave;
import com.hrms.model.Registration;
import com.hrms.service.LeaveService;
@Controller
public class LeaveController {

	@Autowired
	LeaveService leaves;
	
	
	
	@RequestMapping(value="leaves",method=RequestMethod.POST)
	public ModelAndView leaves(@RequestParam("company")String company,@RequestParam("empId")String empId,HttpServletRequest request)
	{
		ModelAndView mv = null;
		try{
			
			Registration reg = (Registration) request.getSession().getAttribute("logindetails");
			if(reg!=null)
			{
			String leavespol = leaves.leavePolicy(company);
			if(leavespol==null) leavespol="";
			ObjectMapper mapper = new ObjectMapper();
			if(!leavespol.isEmpty())
			{
			HashMap<String, Object> leavesPolicy = mapper.readValue(leavespol, HashMap.class);
			if(leavesPolicy.containsKey("message"))
			{
				mv = new ModelAndView("error");
				mv.addObject("message",leavesPolicy.get("message"));
			}
			else
			{
				HashMap<String, Object> map = leaves.leavesCount(empId, company);
				
				if(!map.containsKey("message"))
				{
					Admin admin = mapper.convertValue(leavesPolicy, Admin.class);
					Float pl = admin.getPaid_leave();
					Float cl = admin.getCasual_leave();
					
					Date joiningDate =reg.getRegistration_date();
					LocalDate localjoiningDate = joiningDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					Integer joiningMonth = localjoiningDate.getMonthValue();
					Date currentDate = new Date();
					LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					Integer  currentMonth = localDate.getMonthValue();
					long paidleave = 0;
					long casualleave = 0;
					long approved=0;
					long waiting=0;
					if(!map.containsKey("leaves"))
					{
						if(map.containsKey("waiting pl"))
						{
							paidleave = Long.parseLong((String) map.get("waiting pl"));
							waiting +=paidleave;
						}
						if(map.containsKey("waiting cl"))
						{
							casualleave = Long.parseLong((String) map.get("waiting cl"));
							waiting +=casualleave;
						}
						
						if(map.containsKey("approved pl"))
						{
							paidleave += Long.parseLong((String) map.get("approved pl"));
							approved +=paidleave;
						}
						if(map.containsKey("approved cl"))
						{
							casualleave += Long.parseLong((String) map.get("approved cl"));
							approved +=casualleave;
						}
						
						
					}
					if(joiningMonth<currentMonth)
					{
						paidleave   = (long) (pl*currentMonth) - paidleave;
						casualleave = (long)(cl*currentMonth) -casualleave;
						
					}
					mv = new ModelAndView("Leaves");
					mv.addObject("leavescount",map);
					mv.addObject("paidleave",paidleave);
					mv.addObject("casualleave", casualleave);
					mv.addObject("waiting",waiting);
					mv.addObject("approved", approved);
					mv.addObject("company", company);
					mv.addObject("empId", empId);
				}
				else
				{
					mv =  new ModelAndView("error");
					mv.addObject("message",map.get("message"));
				}
				
			}
			}
			else
			{
				mv = new ModelAndView("error");
				mv.addObject("error", "Please create leave policy contact admin");
			}
			}
			else
			{
				mv = new ModelAndView("Login");
				mv.addObject("errorMsg", "your session is out please login again");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="appliedLeaves",method=RequestMethod.POST)
	public @ResponseBody String appliedLeaves(@RequestParam("company")String company,@RequestParam("empId")String empId,HttpServletRequest request)
	{
		try{
			
			Registration reg = (Registration) request.getSession().getAttribute("logindetails");
			if(reg!=null)
			{
				
				HashMap<String, Object> leave = leaves.appliedeaves(empId, company);
				
				ObjectMapper mapper = new ObjectMapper();
				String response = mapper.writeValueAsString(leave);
				
				return response;
				
			}
			else
			{
				return "sessionout";
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
	
	
}
