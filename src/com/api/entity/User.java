//$Id$
package com.api.entity;

public class User {

	private Long id;
	private String fname;
	private String lname;
	private Long mobile;
	private String email;
	private Integer status;
	private Integer gender;
	private Long modified_on;
	private Long modified_by;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Long getModified_on() {
		return modified_on;
	}
	public void setModified_on(Long modified_on) {
		this.modified_on = modified_on;
	}
	public Long getModified_by() {
		return modified_by;
	}
	public void setModified_by(Long modified_by) {
		this.modified_by = modified_by;
	}
	
	
	
	
}
