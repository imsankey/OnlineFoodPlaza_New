package com.foodplaza.dao;

public interface LoginDao {
	
	boolean userLogin(String custEmailId,String custPassword);
	boolean userChangePassword(String custEmailId,String newPassword);
	boolean adminLogin(String adminEmailId,String adminPassword);
	boolean adminChangePassword(String adminEmailId,String adminPassword);

}
