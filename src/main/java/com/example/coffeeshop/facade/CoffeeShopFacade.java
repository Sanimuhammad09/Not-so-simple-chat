package com.example.coffeeshop.facade;

import com.example.coffeeshop.factory.CoffeeFactory;
import com.example.coffeeshop.model.Coffee;
import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.singleton.CoffeeShop;
import org.springframework.stereotype.Service;

@Service
public class CoffeeShopFacade {

    private final CoffeeFactory coffeeFactory;
    private final CoffeeShop coffeeShop;

    public CoffeeShopFacade(CoffeeFactory coffeeFactory, CoffeeShop coffeeShop) {
        this.coffeeFactory = coffeeFactory;
        this.coffeeShop = coffeeShop;
    }

    public Order orderCoffee(String customerName, String coffeeType) {
        Customer customer = new Customer(customerName, false);
        Coffee coffee = coffeeFactory.createCoffee(coffeeType);
        Order order = new Order(customer, coffee);
        
        coffeeShop.placeOrder(order);
        
        return order;
    }
}
