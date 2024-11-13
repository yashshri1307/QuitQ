package com.hexaware.service;

import java.util.List;
import java.util.Optional;

import com.hexaware.entity.Cart;

public class CartServiceImp implements ICartService{

	@Override
	public Cart addCartItem(Cart cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> getCartItemById(Integer cartItemId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Cart> getCartItemsByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCartItemQuantity(Integer cartItemId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCartItem(Integer cartItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearCustomerCart(Integer customerId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
