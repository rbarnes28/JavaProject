package com.example.demo.Model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentDetails {
	@Column
	  @Id
	  private String sid;
	  @Column
	  private String student_name;
	  
	  @Column
	  private String fee_paid;
	  
	  @Column
	  private String date;
	  
	  @Column
	  private Time time;
	public PaymentDetails() {
		this.sid = null;
		this.student_name = null;
		this.fee_paid = null;
		this.date = null;
		this.time = null;
	}
	public PaymentDetails(String sid, String student_name, String fee_paid, String date, Time time) {
		super();
		this.sid = sid;
		this.student_name = student_name;
		this.fee_paid = fee_paid;
		this.date = date;
		this.time = time;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getFee_paid() {
		return fee_paid;
	}

	public void setFee_paid(String fee_paid) {
		this.fee_paid = fee_paid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

	  
	  
	  
	  
	  
	  

}
