package com.example.coffeeshop.controller;

import com.example.coffeeshop.facade.CoffeeShopFacade;
import com.example.coffeeshop.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class CoffeeShopController {

    private final CoffeeShopFacade coffeeShopFacade;

    public CoffeeShopController(CoffeeShopFacade coffeeShopFacade) {
        this.coffeeShopFacade = coffeeShopFacade;
    }

    @PostMapping
    public String placeOrder(@RequestParam String customerName, @RequestParam String coffeeType) {
        Order order = coffeeShopFacade.orderCoffee(customerName, coffeeType);
        return "Order placed successfully! Order ID: " + order.getOrderId();
    }
}
