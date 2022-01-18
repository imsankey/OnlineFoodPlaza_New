package com.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.dao.CartDaoImp;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Food;

public class CartTest {

	public static void main(String[] args) throws IOException {
		
		CartDaoImp cadl=new CartDaoImp();
		int foodId,quantity,choice=0,cartId;
		String foodName,EmailId;
		double foodPrice,totalPrice;
		
		InputStreamReader str=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(str);
		Scanner sc=new Scanner(System.in);
		
		do {
		System.out.println("1.add cart\n2.see cart deatails\n3.delete cart by cartId\n4.claer cart by emailId");
		System.out.println("enter your choice");
		choice =sc.nextInt();
		
		switch(choice){
		
		case 1:
			System.out.println("add food Id");
			foodId=sc.nextInt();
			System.out.println("add food quantity");
			quantity=sc.nextInt();
			System.out.println("add cusomer emailId");
			EmailId=br.readLine();
			System.out.println("add food Name");
			foodName=br.readLine();
			System.out.println("add food food price");
			foodPrice=sc.nextDouble();
			totalPrice=quantity*foodPrice;
			Cart cart=new Cart(foodId,quantity,EmailId,foodName,foodPrice,totalPrice);
			boolean b=cadl.addToCart(cart);
			if(b) {
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			
			break;
			
			
		case 2:
			System.out.println("enter existing email id");
			EmailId=br.readLine();
			List<Cart> cartlist=cadl.showCart(EmailId);
             if(cartlist !=null && !(cartlist.isEmpty())) {
				
				Iterator <Cart> it=cartlist.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
			}
             else {
 				System.out.println("cart list is empty");
 			}
             break;
             
		case 3:
			
			System.out.println("enter the existing cart id");
			cartId=sc.nextInt();
			boolean b2=cadl.deleteCart(cartId);
			if(b2) {
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			break;
			
		case 4:
			
			System.out.println("enter the existing email id");
			EmailId=br.readLine();
			boolean b3=cadl.clearCart(EmailId);
			if(b3) {
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			break;
			
			
			
		}
		
		}while(choice!=5);
		
		

	}

}
