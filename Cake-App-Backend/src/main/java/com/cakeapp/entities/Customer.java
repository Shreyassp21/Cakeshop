package com.cakeapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	private String name;
	private String address;
	@Id
	private String email;
	private String pwd;
	private String mobile;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", email=" + email + ", pwd=" + pwd + ", mobile="
				+ mobile + "]";
	}

	
}
