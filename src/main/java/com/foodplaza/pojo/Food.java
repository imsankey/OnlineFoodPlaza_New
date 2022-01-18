package com.foodplaza.pojo;

public class Food 
{
	private int foodId;
	private String foodName,foodType,foodCat,foodDesc,foodImage;
	private double price;
	
	public Food()
	{
		
	}
	
	public Food( String foodName, String foodType, String foodCat, String foodDesc, String foodImage,
			double price) {
		super();
		
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodCat = foodCat;
		this.foodDesc = foodDesc;
		this.foodImage = foodImage;
		this.price = price;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getFoodCat() {
		return foodCat;
	}

	public void setFoodCat(String foodCat) {
		this.foodCat = foodCat;
	}

	public String getFoodDesc() {
		return foodDesc;
	}

	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}

	public String getFoodImage() {
		return foodImage;
	}

	public void setFoodImage(String foodImage) {
		this.foodImage = foodImage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodCat=" + foodCat
				+ ", foodDesc=" + foodDesc + ", foodImage=" + foodImage + ", price=" + price + "]";
	}
	
	
	
	
	

}
