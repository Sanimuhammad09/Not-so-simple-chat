package com.example.coffeeshop.command;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommandInvoker {
    private List<Command> commandList = new ArrayList<>();

    public void takeCommand(Command command) {
        commandList.add(command);
    }

    public void placeOrders() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
