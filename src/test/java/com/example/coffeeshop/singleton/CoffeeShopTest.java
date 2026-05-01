package com.example.coffeeshop.singleton;

import com.example.coffeeshop.command.CommandInvoker;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.Barista;
import com.example.coffeeshop.service.OrderQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CoffeeShopTest {

    @Mock
    private OrderQueue orderQueue;

    @Mock
    private Barista barista;

    @Mock
    private CommandInvoker commandInvoker;

    @InjectMocks
    private CoffeeShop coffeeShop;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlaceOrder() {
        Order order = new Order("Espresso");
        coffeeShop.placeOrder(order);

        verify(orderQueue).addOrder(order);
        verify(barista).processOrder(order);
    }
}
