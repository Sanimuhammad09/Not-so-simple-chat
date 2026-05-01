package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderQueueTest {
    private OrderQueue orderQueue;

    @BeforeEach
    void setUp() {
        orderQueue = new OrderQueue();
    }

    @Test
    void testAddOrder() {
        Order order = new Order("Cappuccino");
        orderQueue.addOrder(order);
        assertEquals(1, orderQueue.size());
    }
}
