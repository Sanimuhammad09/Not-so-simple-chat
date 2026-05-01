package com.example.coffeeshop.model;

public class Customer {
    private String name;
    private boolean loyaltyMember;

    public Customer(String name, boolean loyaltyMember) {
        this.name = name;
        this.loyaltyMember = loyaltyMember;
    }

    public String getName() {
        return name;
    }

    public boolean isLoyaltyMember() {
        return loyaltyMember;
    }
}
