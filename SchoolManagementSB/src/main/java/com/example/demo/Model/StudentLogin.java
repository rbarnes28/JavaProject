package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="student_login")
public class StudentLogin {
	@Column
	@Id
	private String rollno;
	@Column
	private String name;
	@Column
	private String logintime;
	@Column
	private String logouttime;
	
	public StudentLogin() {
		this.rollno = null;
		this.name = null;
		this.logintime = null;
		this.logouttime = null;
		
	}
	
	public StudentLogin(String rollno, String name, String logintime, String logouttime) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.logintime = logintime;
		this.logouttime = logouttime;
	}
	
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
