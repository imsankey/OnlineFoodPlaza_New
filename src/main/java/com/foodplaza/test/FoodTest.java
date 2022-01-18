package com.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;

public class FoodTest {

	public static void main(String[] args) throws IOException {
		
		FoodDaoImpl fdl=new FoodDaoImpl();
		int foodId,choice=0;
		String foodName,foodType,foodCat,foodImage,foodDesc;
		double foodPrice;
		InputStreamReader str=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(str);
		Scanner sc=new Scanner(System.in);
		
		do {
		System.out.println("1.addFood\n2.GetAllFood\n3.searchById\n4.updateFood by Id\n5.deleteFoodBy Id\n6.search food by name\n7.search food by category\n8.search food by type\n9.add feedback\n10.getAll feedback\n11.exit");
		System.out.println("Enter the choice");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println("enter the food name");
			foodName=br.readLine();
			System.out.println("enter the food type");
			foodType=br.readLine();
			System.out.println("enter the food category");
			foodCat=br.readLine();
			System.out.println("enter the food Description");
			foodDesc=br.readLine();
			System.out.println("enter the food image");
			foodImage=br.readLine();
			System.out.println("enter the food price");
			foodPrice=sc.nextDouble();
			
			Food food=new Food(foodName,foodType,foodCat,foodImage,foodDesc,foodPrice);
			boolean b=fdl.addFood(food);
			if(b) {
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			
			break;
			
			
			
		case 2:
			System.out.println("All records");
			List<Food> foodList=fdl.getAllFoods();
			if(foodList!=null && !(foodList.isEmpty())) {
				Iterator<Food> it=foodList.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
			}
			else {
				System.out.println("food list is empty");
			}
			
			break;
			
		case 3:
			System.out.println("Enter the existing food id");
			foodId=sc.nextInt();
			food=fdl.searchFoodById(foodId);
			if(food!=null) {
				System.out.println(food);
			}
			else {
				System.out.println("food not found");
			}
			break;
			
		case 4:
			System.out.println("Enter the existing food id");
			foodId=sc.nextInt();
			System.out.println("Enter the food name");
			foodName=br.readLine();
			System.out.println("Enter the food type");
			foodType=br.readLine();
			System.out.println("Enter the food category");
			foodCat=br.readLine();
			System.out.println("Enter the food Description");
			foodDesc=br.readLine();
			System.out.println("Enter the food Image");
			foodImage=br.readLine();
			System.out.println("Enter the food price");
			foodPrice=sc.nextDouble();
			
			Food food1=new Food(foodName,foodType,foodCat,foodImage,foodDesc,foodPrice);
			food1.setFoodId(foodId);
			boolean b1=fdl.updateFood(food1);
			if(b1) {
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			
			break;
			
			
		case 5:
			
			System.out.println("enter the existing food id");
			foodId=sc.nextInt();
			boolean b2=fdl.deleteFood(foodId);
			if(b2) {
				System.out.println("success");
			}
			else
			{
				System.out.println("fail");
			}
			break;
			
		case 6:
			System.out.println("enter the existing Food Name");
			foodName=br.readLine();
			List<Food> foodList1=fdl.searchFoodByName(foodName);
			if(foodList1 !=null && !(foodList1.isEmpty())) {
				
				Iterator <Food> it=foodList1.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
			}
			else {
				System.out.println("food list is empty");
			}
			break;
			
			
		case 7:
			System.out.println("enter the existing Food category");
			foodCat=br.readLine();
			List<Food> foodList2=fdl.searchFoodByCategory(foodCat);
            if(foodList2 !=null && !(foodList2.isEmpty())) {
				
				Iterator <Food> it=foodList2.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
			}
            else {
				System.out.println("food list is empty");
			}
            break;
			
			
		case 8:
			System.out.println("enter the existing Food Type");
			foodType=br.readLine();
			List<Food> foodList3=fdl.searchFoodByType(foodType);
            if(foodList3 !=null && !(foodList3.isEmpty())) {
				
				Iterator <Food> it=foodList3.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
				
			}
            else {
				System.out.println("food list is empty");
			}
            break;
			
		case 9:
			
		case 10:
			
		case 11:
			
		
		}
		
		
		}while(choice!=12);
		
		
	}

}
