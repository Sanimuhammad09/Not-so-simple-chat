package com.example.coffeeshop.observer;

import com.example.coffeeshop.model.Order;
import org.springframework.context.ApplicationEvent;

public class OrderReadyEvent extends ApplicationEvent {
    private final Order order;

    public OrderReadyEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
