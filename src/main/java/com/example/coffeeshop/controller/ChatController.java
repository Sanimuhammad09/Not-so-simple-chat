package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.ChatMessage;
import com.example.coffeeshop.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public String sendMessage(@RequestParam String sender, @RequestParam String message) {
        chatService.saveMessage(sender, message);
        return "Message sent!";
    }

    @GetMapping
    public List<ChatMessage> getChatHistory() {
        return chatService.getChatHistory();
    }
}
