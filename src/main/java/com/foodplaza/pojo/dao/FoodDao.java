package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.FeedBack;
import com.foodplaza.pojo.Food;

public interface FoodDao
{
	boolean addFood(Food food);
	boolean updateFood(Food food);
	boolean deleteFood(int foodId);
	Food searchFoodById(int foodId);
	List<Food> getAllFoods();
	List<Food> searchFoodByName(String foodName);
	List<Food> searchFoodByType(String foodType);
	List<Food> searchFoodByCategory(String foodCat);
	
	boolean addFeedback(FeedBack feedback);
	List<FeedBack> getAllFeedBack();

}
