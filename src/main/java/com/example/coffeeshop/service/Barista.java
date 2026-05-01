package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.observer.OrderReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Barista {

    private final ApplicationEventPublisher eventPublisher;

    public Barista(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Async
    public void processOrder(Order order) {
        System.out.println("Barista is processing order: " + order.getOrderId() + " for " + 
                           (order.getCustomer() != null ? order.getCustomer().getName() : "Unknown"));
        try {
            // Simulate time taken to prepare coffee
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        order.setReady(true);
        eventPublisher.publishEvent(new OrderReadyEvent(this, order));
    }
}
