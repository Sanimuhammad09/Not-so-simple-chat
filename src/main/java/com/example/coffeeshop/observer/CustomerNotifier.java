package com.example.coffeeshop.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerNotifier implements ApplicationListener<OrderReadyEvent> {

    @Override
    public void onApplicationEvent(OrderReadyEvent event) {
        System.out.println("Notification: Order " + event.getOrder().getOrderId() + 
                           " for " + event.getOrder().getCustomer().getName() + " is ready!");
    }
}
