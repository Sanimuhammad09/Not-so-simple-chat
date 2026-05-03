package com.example.coffeeshop.command;

import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.service.Barista;

public interface Command {
    void execute();
}
