package com.richard.backend;

import com.richard.backend.model.Stock;
import com.richard.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpHeaders;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void newUserTest() throws Exception {
        Stock stock = new Stock();
        stock.setName("Samsung");
        stock.setPrice(1000.0);
        stock.setQuantity(1L);
//        userRepository.save(stock);
    }
}
