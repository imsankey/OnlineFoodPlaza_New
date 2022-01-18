package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Cart;

public interface CartDao 
{
	boolean addToCart(Cart cart);
	List<Cart> showCart(String EmailId);
	boolean deleteCart(int cartId);
	boolean clearCart(String EmailId);
	
	

}
