package com.example.coffeeshop.prototype;

import com.example.coffeeshop.model.Coffee;
import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.model.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CoffeeOrderPrototype extends Order {

    public CoffeeOrderPrototype(Customer customer, Coffee coffee) {
        super(customer, coffee);
    }

    public CoffeeOrderPrototype cloneOrder() {
        return new CoffeeOrderPrototype(this.getCustomer(), this.getCoffee());
    }
}
