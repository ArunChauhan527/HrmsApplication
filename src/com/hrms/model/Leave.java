package com.hrms.model;

import java.util.Date;


public class Leave {


	Integer sno;
	Integer emp_code;
	String type;
	String status;
    Date appliedon;
    String applied_by;
    Date approved_on;
    String approved_by;
    String updated_by;
    Date updated_on;
    String industry;
    String comp_code;
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public Integer getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(Integer emp_code) {
		this.emp_code = emp_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAppliedon() {
		return appliedon;
	}
	public void setAppliedon(Date appliedon) {
		this.appliedon = appliedon;
	}
	public String getApplied_by() {
		return applied_by;
	}
	public void setApplied_by(String applied_by) {
		this.applied_by = applied_by;
	}
	public Date getApproved_on() {
		return approved_on;
	}
	public void setApproved_on(Date approved_on) {
		this.approved_on = approved_on;
	}
	public String getApproved_by() {
		return approved_by;
	}
	public void setApproved_by(String approved_by) {
		this.approved_by = approved_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public Date getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getComp_code() {
		return comp_code;
	}
	public void setComp_code(String comp_code) {
		this.comp_code = comp_code;
	}
	
	
}
