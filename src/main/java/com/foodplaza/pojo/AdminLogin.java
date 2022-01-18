package com.foodplaza.pojo;

public class AdminLogin
{
	private String adminEmailId,password;
	
	
	public AdminLogin()
	{
		
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminLogin [adminEmailId=" + adminEmailId + ", password=" + password + "]";
	}
	
	
	

}
