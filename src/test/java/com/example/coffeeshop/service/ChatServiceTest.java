package com.example.coffeeshop.service;

import com.example.coffeeshop.model.ChatMessage;
import com.example.coffeeshop.repository.ChatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class ChatServiceTest {
    
    @MockBean
    private ChatRepository chatRepository;

    @Autowired
    private ChatService chatService;

    @Test
    void testSaveMessage() {
        String message = "Hello!";
        chatService.saveMessage("Customer", message);
        verify(chatRepository).save(any(ChatMessage.class));
    }
}
