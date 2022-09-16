package com.revature.Group4P2;

import com.revature.Group4P2.beans.repositories.CartRepo;
import com.revature.Group4P2.beans.services.CartService;

import com.revature.Group4P2.entities.Cart;
import com.revature.Group4P2.entities.Catalog;
import com.revature.Group4P2.entities.CatalogDetails;
import com.revature.Group4P2.entities.Users;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartItemTest {

    @Autowired
    private CartService service;
    @MockBean
    private CartRepo repo;

    @Test
    void contextLoads() {
    }
    //testing getCartItemById() method
    @Test
    public void getCartItemByIdTest() {

    }

}