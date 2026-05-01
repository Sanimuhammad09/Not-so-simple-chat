package com.example.coffeeshop.model;

import java.util.UUID;

public class Order {
    private String orderId;
    private Customer customer;
    private Coffee coffee;
    private boolean isReady;

    public Order(Customer customer, Coffee coffee) {
        this.orderId = UUID.randomUUID().toString();
        this.customer = customer;
        this.coffee = coffee;
        this.isReady = false;
    }

    // For Part04 requirement: Order(String)
    public Order(String coffeeName) {
        this.orderId = UUID.randomUUID().toString();
        this.isReady = false;
        // In a real app we'd resolve coffeeName to Coffee object
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
