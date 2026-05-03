package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.ChatMessage;
import com.example.coffeeshop.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChatController.class)
class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    @Test
    void testSendMessage() throws Exception {
        mockMvc.perform(post("/api/chat")
                .param("sender", "User")
                .param("message", "Hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Message sent!"));
    }

    @Test
    void testGetChatHistory() throws Exception {
        when(chatService.getChatHistory()).thenReturn(Arrays.asList(
                new ChatMessage("User", "Hello")
        ));

        mockMvc.perform(get("/api/chat"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'sender':'User', 'message':'Hello'}]"));
    }
}
