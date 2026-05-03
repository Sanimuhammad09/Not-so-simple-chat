package com.example.coffeeshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to the Coffee Shop API!");
        response.put("status", "Running");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("Place Order", "POST /api/orders?customerName=...&coffeeType=...");
        endpoints.put("Chat History", "GET /api/chat");
        endpoints.put("Send Chat", "POST /api/chat?sender=...&message=...");
        
        response.put("endpoints", endpoints);
        return response;
    }
}
