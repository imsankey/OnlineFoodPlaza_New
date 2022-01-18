package com.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) throws IOException
	{
		CustomerDaoImpl cdl=new CustomerDaoImpl();
		int custId,choice=0;
		String cust_name,emailId,password,contactNo,address;
		InputStreamReader str=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(str);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1.Add customer details\n2.Update customer details by customer id\n3.Delete Customer \n4.Show all Customer\n5.Search Customer By email");
		System.out.println("Enter the choice");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter customer name");
			cust_name=br.readLine();
			System.out.println("Enter customer email");
			emailId=br.readLine();
			System.out.println("Enter Password");
			password=br.readLine();
			System.out.println("Enter contact number");
			contactNo=br.readLine();
			System.out.println("Enter customer Address");
			address=br.readLine();
			
			Customer c=new Customer(cust_name,emailId,password,contactNo,address);
			boolean b=cdl.addCustomer(c);
			if(b) {
				System.out.println("Success");
			}
			else {
				System.out.println("fail");
			}
			
			break;
			
		case 2:
			System.out.println("Enter the existing customer email Id");
			emailId=br.readLine();
			System.out.println("Enter customer name");
			cust_name=br.readLine();
			System.out.println("Enter Password");
			password=br.readLine();
			System.out.println("Enter contact number");
			contactNo=br.readLine();
			System.out.println("Enter customer Address");
			address=br.readLine();
			
			Customer c1=new Customer(cust_name,emailId,password,contactNo,address);
			c1.setEmailId(emailId);
			boolean b1=cdl.updateCustomer(c1);
			if(b1) {
				System.out.println("Success");
			}
			else {
				System.out.println("fail");
			}
			
			break;
			
		case 3:
			System.out.println("Enter the existing customer email Id");
			emailId=sc.next();
			boolean b2=cdl.deleteCustomer(emailId);
			if(b2) {
				System.out.println("Success");
			}
			else {
				System.out.println("fail");
			}
			
			break;
			
		case 4:
			
		case 5:
			
			
			
		}
		
		



	}

}
