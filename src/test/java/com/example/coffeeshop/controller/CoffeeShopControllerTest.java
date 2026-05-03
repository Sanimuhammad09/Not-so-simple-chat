package com.example.coffeeshop.controller;

import com.example.coffeeshop.facade.CoffeeShopFacade;
import com.example.coffeeshop.model.Order;
import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.model.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoffeeShopController.class)
class CoffeeShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoffeeShopFacade coffeeShopFacade;

    @Test
    void testPlaceOrder() throws Exception {
        Coffee mockCoffee = org.mockito.Mockito.mock(Coffee.class);
        when(mockCoffee.getDescription()).thenReturn("Espresso");
        when(mockCoffee.getCost()).thenReturn(2.5);
        
        Order mockOrder = new Order(new Customer("John", false), mockCoffee);
        
        when(coffeeShopFacade.orderCoffee(anyString(), anyString())).thenReturn(mockOrder);

        mockMvc.perform(post("/api/orders")
                .param("customerName", "John")
                .param("coffeeType", "Espresso"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Order placed successfully!")));
    }
}
