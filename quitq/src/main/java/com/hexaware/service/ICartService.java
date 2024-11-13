package com.hexaware.service;
import java.util.List;
import java.util.Optional;
import com.hexaware.entity.Cart;

public interface ICartService {

    
    Cart addCartItem(Cart cartItem);

    Optional<Cart> getCartItemById(Integer cartItemId);

    List<Cart> getCartItemsByCustomerId(Integer customerId);
    
    void updateCartItemQuantity(Integer cartItemId, int quantity);

    void deleteCartItem(Integer cartItemId);

    void clearCustomerCart(Integer customerId);
}