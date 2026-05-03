package com.example.coffeeshop.singleton;

import com.example.coffeeshop.command.CommandInvoker;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.OrderQueue;
import com.example.coffeeshop.service.Barista;
import org.springframework.stereotype.Component;

import com.example.coffeeshop.command.Command;
import com.example.coffeeshop.command.PlaceOrderCommand;

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
        
        // Use Command Pattern to process the order
        Command placeOrderCommand = new PlaceOrderCommand(barista, order);
        commandInvoker.takeCommand(placeOrderCommand);
        commandInvoker.placeOrders();
    }
    
    public void processQueue() {
        // Implementation for a dedicated queue processor thread could go here
    }
}
