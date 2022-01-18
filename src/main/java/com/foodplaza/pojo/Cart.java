package com.foodplaza.pojo;

public class Cart
{
	private int cartId,foodId,quantity;
	private String emailId,foodName;
	private double totalprice,foodPrice;
	
	public Cart()
	{
		
	}
	
	public Cart( int foodId, int quantity, String emailId, String foodName, double foodPrice,double totalprice) {
		super();
		
		this.foodId = foodId;
		this.quantity = quantity;
		this.emailId = emailId;
		this.foodName = foodName;
		this.foodPrice=foodPrice;
		this.totalprice = totalprice;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", quantity=" + quantity + ", emailId=" + emailId
				+ ", foodName=" + foodName + ",foodPrice=" + foodPrice + ", totalprice=" + totalprice + "]";
	}
	
	
	

}
