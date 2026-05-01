package com.example.coffeeshop.singleton;

import com.example.coffeeshop.command.CommandInvoker;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.OrderQueue;
import com.example.coffeeshop.service.Barista;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShop {

    private final OrderQueue orderQueue;
    private final Barista barista;
    private final CommandInvoker commandInvoker;

    public CoffeeShop(OrderQueue orderQueue, Barista barista, CommandInvoker commandInvoker) {
        this.orderQueue = orderQueue;
        this.barista = barista;
        this.commandInvoker = commandInvoker;
    }

    public void placeOrder(Order order) {
        orderQueue.addOrder(order);
        System.out.println("Order added to queue: " + order.getOrderId());
        
        // We can process it asynchronously via Barista
        barista.processOrder(order);
    }
    
    public void processQueue() {
        // Implementation for a dedicated queue processor thread could go here
    }
}
