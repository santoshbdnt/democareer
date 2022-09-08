package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HiringForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int applicationId;
	String name;
	String phone;
	String email;
	String message;
	
	String data;
	
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public HiringForm(int applicationId, String name, String phone, String email, String message, String data) {
		super();
		this.applicationId = applicationId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.data = data;
	}
	public HiringForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HiringForm [applicationId=" + applicationId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", message=" + message + ", data=" + data + "]";
	}
	
	
	

}
