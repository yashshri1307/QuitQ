package com.hexaware.entity;

import java.time.LocalDateTime;

public class Cart {

   
    private Integer cartItemId;
    private Integer cartId;
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
    private LocalDateTime addedDate;

       public Cart() {
        super();
    }

        public Cart(Integer cartItemId, Integer cartId, Integer customerId, Integer productId, Integer quantity, LocalDateTime addedDate) {
        super();
        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.addedDate = addedDate;
    }

    
    public Integer getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Integer cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

   
    @Override
    public String toString() {
        return "Cart{" +
                "cartItemId=" + cartItemId +
                ", cartId=" + cartId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", addedDate=" + addedDate +
                '}';
    }
}
