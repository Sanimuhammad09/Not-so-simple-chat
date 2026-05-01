package com.example.coffeeshop.strategy;

import com.example.coffeeshop.model.Customer;
import org.springframework.stereotype.Component;

// Using one file for simplicity in displaying Strategy

interface PricingStrategy {
    double calculatePrice(double basePrice);
}

@Component("regularPricingStrategy")
class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}

@Component("loyaltyPricingStrategy")
class LoyaltyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9; // 10% discount
    }
}
