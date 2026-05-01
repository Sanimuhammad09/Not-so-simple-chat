package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Order;
import org.springframework.stereotype.Service;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class OrderQueue {
    private final BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void addOrder(Order order) {
        queue.add(order);
    }

    public Order getNextOrder() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
