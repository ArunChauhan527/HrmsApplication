package com.hrms.model;

import java.util.Date;


public class NationalHoliday {
	

	int sno;
	String holiday;
	Date occured_date;
	String region;
	String department;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public Date getOccured_date() {
		return occured_date;
	}
	public void setOccured_date(Date occured_date) {
		this.occured_date = occured_date;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}
