package com.example.coffeeshop.service;

import com.example.coffeeshop.model.ChatMessage;
import com.example.coffeeshop.repository.ChatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Transactional
    public void saveMessage(String sender, String message) {
        ChatMessage chatMessage = new ChatMessage(sender, message);
        chatRepository.save(chatMessage);
    }

    public List<ChatMessage> getChatHistory() {
        return chatRepository.findAll();
    }
}
