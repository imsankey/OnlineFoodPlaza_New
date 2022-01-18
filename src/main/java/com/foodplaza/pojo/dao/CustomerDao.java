package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Customer;

public interface CustomerDao
{
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(String emailId);
	List<Customer> showAllCustomer();
	Customer searchCustomerByEmail(String custemail);

}
