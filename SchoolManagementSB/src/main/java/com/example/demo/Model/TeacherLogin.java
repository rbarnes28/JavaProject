package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="teacher_login")
public class TeacherLogin {
	@Column
	@Id
	private String empID;
	@Column
	private String name;
	@Column
	private String date;
	@Column
	private String logintime;
	@Column
	private String logouttime;
	
	public TeacherLogin() {
		this.empID = null;
		this.name = null;
		this.date = null;
		this.logintime = null;
		this.logouttime = null;
		
	}

	public TeacherLogin(String empID, String name, String date, String logintime, String logouttime) {
		super();
		this.empID = empID;
		this.name = name;
		this.date = date;
		this.logintime = logintime;
		this.logouttime = logouttime;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public String getLogouttime() {
		return logouttime;
	}

	public void setLogouttime(String logouttime) {
		this.logouttime = logouttime;
	}
	
}
