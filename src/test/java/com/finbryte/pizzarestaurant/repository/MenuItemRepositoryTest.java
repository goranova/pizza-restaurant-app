package com.finbryte.pizzarestaurant.repository;

import com.finbryte.pizzarestaurant.model.MenuItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestPropertySource(locations="classpath:application-test.properties")
public class MenuItemRepositoryTest {

    private static final String PIZZA_NAME = "Seafood pizza";

    private static final String PIZZA_NAME_FAIL = "Mexican Hot";


    @Autowired
    private MenuItemRepository repo;

    @Test
    public void findMenuItemByNameTest_success(){
        MenuItem item = repo.findMenuItemByName(PIZZA_NAME);
        assertNotNull(item);
        assertEquals(item.getName(),PIZZA_NAME);
    }

    @Test
    public void findMenuItemByNameTest_fail(){
        MenuItem item = repo.findMenuItemByName(PIZZA_NAME_FAIL);
        assertNull(item);
    }

}
