package com.example.coffeeshop.factory;

import com.example.coffeeshop.model.Coffee;
import org.springframework.stereotype.Service;

@Service
public class CoffeeFactory {

    public Coffee createCoffee(String type) {
        if ("Espresso".equalsIgnoreCase(type)) {
            return new Espresso();
        } else if ("Cappuccino".equalsIgnoreCase(type)) {
            return new Cappuccino();
        }
        throw new IllegalArgumentException("Unknown coffee type: " + type);
    }
    
    // Concrete basic coffees (can also be moved to model)
    private static class Espresso implements Coffee {
        @Override
        public String getDescription() { return "Espresso"; }
        @Override
        public double getCost() { return 2.50; }
    }

    private static class Cappuccino implements Coffee {
        @Override
        public String getDescription() { return "Cappuccino"; }
        @Override
        public double getCost() { return 3.50; }
    }
}
