package edu.mum.models;

public class Order {
    private Cart cart;
    private User user;
    private String billingAddress;
    private String shippingAddress;
    private PaymentType paymentType;
    
    public Order(Cart cart, User user, String billingAddress, String shippingAddress, PaymentType paymentType) {
        super();
        this.cart = cart;
        this.user = user;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.paymentType = paymentType;
    }

    public Cart getCart() {
        return cart;
    }
    
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
