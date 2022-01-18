package com.foodplaza.test;

import java.util.Scanner;

import com.foodplaza.dao.LoginDaoImpl;

public class LoginTest {

	public static void main(String[] args) {
		
		LoginDaoImpl ldao=new LoginDaoImpl();
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the choice");
			System.out.println("1.User login");
			System.out.println("2.User change Password");
			System.out.println("3.Admin Login");
			System.out.println("4.Admin change password");
			
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("enter emailId of customer");
			    String emailId=sc.next();
			    System.out.println("enter customer password");
			    String custPassword=sc.next();
			    boolean b=ldao.userLogin(emailId, custPassword);
			    if(b)
			    {
			    	System.out.println("Login Succesfully");
			    }
			    else
			    {
			    	System.out.println("login failed");
			    }
			    break;
			    
			case 2:
				System.out.println("enter existing customer user name");
				String customerName=sc.next();
				System.out.println("enter new password");
				String password=sc.next();
				boolean b1=ldao.userChangePassword(customerName, password);
				if(b1)
				{
					System.out.println("update succesfully");
				}
				else
				{
					System.out.println(" not updated");
				}
				break;
				
			case 3:
				System.out.println("enter admin user name");
				String adminName1=sc.next();
				System.out.println("enter  password");
				String adminpassword2=sc.next();
				boolean b3=ldao.adminLogin(adminName1, adminpassword2);
				if(b3)
				{
					System.out.println("login succesfully");
				}
				else
				{
					System.out.println("Login failed");
				}
				break;
				
			case 4:
				System.out.println("enter admin user name");
				adminName1=sc.next();
				System.out.println("enter password to change");
				adminpassword2=sc.next();
				boolean b2=ldao.adminChangePassword(adminName1, adminpassword2);
				if(b2)
				{
					System.out.println("password changes succesfully");
				}
				else
				{
					System.out.println("password not change");
				}
				break;
				default :System.out.println("invalid input");
				
				//now run
				
				
			}
			
		}
		


	}

}
