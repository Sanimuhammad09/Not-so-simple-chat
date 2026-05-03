package com.example.coffeeshop.singleton;

import com.example.coffeeshop.command.CommandInvoker;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.Barista;
import com.example.coffeeshop.service.OrderQueue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class CoffeeShopTest {

    @MockBean
    private OrderQueue orderQueue;

    @MockBean
    private Barista barista;

    @MockBean
    private CommandInvoker commandInvoker;

    @Autowired
    private CoffeeShop coffeeShop;

    @Test
    void testPlaceOrder() {
        Order order = new Order("Espresso");
        coffeeShop.placeOrder(order);

        verify(orderQueue).addOrder(order);
        verify(commandInvoker).takeCommand(any());
        verify(commandInvoker).placeOrders();
    }
}
