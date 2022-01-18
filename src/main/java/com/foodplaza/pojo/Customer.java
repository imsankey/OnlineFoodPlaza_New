package com.foodplaza.pojo;

import java.io.Serializable;

public class Customer implements Serializable
{
	private String cust_name,emailId,password,contactNo,address;
	

	public Customer(String cust_name, String emailId, String password, String contactNo, String address) {
		super();
		this.cust_name = cust_name;
		this.emailId = emailId;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
	}
	
	public Customer(){
		
	}
	

	



	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cust_name=" + cust_name + ", emailId=" + emailId + ", password=" + password + ", contactNo="
				+ contactNo + ", address=" + address + "]";
	}
	
	

}
