package com.example.coffeeshop.adapter;

import org.springframework.stereotype.Service;

// Target Interface
public interface PaymentService {
    boolean processPayment(double amount);
}

// Adaptee
@Service
class StripePaymentService {
    public boolean makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
        return true;
    }
}

// Adapter
@Service
class PaymentAdapter implements PaymentService {
    private final StripePaymentService stripePaymentService;

    public PaymentAdapter(StripePaymentService stripePaymentService) {
        this.stripePaymentService = stripePaymentService;
    }

    @Override
    public boolean processPayment(double amount) {
        return stripePaymentService.makePayment(amount);
    }
}
