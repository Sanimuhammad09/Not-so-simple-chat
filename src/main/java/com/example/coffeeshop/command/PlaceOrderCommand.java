package com.example.coffeeshop.command;

import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.Barista;

public class PlaceOrderCommand implements Command {
    private Barista barista;
    private Order order;

    public PlaceOrderCommand(Barista barista, Order order) {
        this.barista = barista;
        this.order = order;
    }

    @Override
    public void execute() {
        barista.processOrder(order);
    }
}
