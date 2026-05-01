package com.example.coffeeshop.service;

import com.example.coffeeshop.model.ChatMessage;
import com.example.coffeeshop.repository.ChatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ChatServiceTest {
    
    @Mock
    private ChatRepository chatRepository;

    @InjectMocks
    private ChatService chatService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveMessage() {
        String message = "Hello!";
        chatService.saveMessage("Customer", message);
        verify(chatRepository).save(any(ChatMessage.class));
    }
}
