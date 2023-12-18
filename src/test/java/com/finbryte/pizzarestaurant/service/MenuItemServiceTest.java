package com.finbryte.pizzarestaurant.service;

import com.finbryte.pizzarestaurant.MenuUtils;
import com.finbryte.pizzarestaurant.enums.MenuItemType;
import com.finbryte.pizzarestaurant.exceptions.MenuItemException;
import com.finbryte.pizzarestaurant.model.MenuItem;
import com.finbryte.pizzarestaurant.repository.MenuItemRepository;
import com.finbryte.pizzarestaurant.request.OrderedItem;
import com.finbryte.pizzarestaurant.response.Bill;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(MenuItemService.class)
public class MenuItemServiceTest {

    private Log log = LogFactory.getLog(this.getClass());

    @MockBean
    private MenuItemRepository repository;

    @Autowired
    private MenuItemService service;

    @Test
    public void processOrderTest_success(){
        MenuItem itemExpectedBeer = new MenuItem(null,MenuUtils.BEER_NAME,new BigDecimal("7.20"), MenuItemType.BEER);
        MenuItem itemExpectedPizza = new MenuItem(null,MenuUtils.PIZZA_NAME,new BigDecimal("16.90"), MenuItemType.PIZZA);

        List<OrderedItem> orderedItems = List.of(new OrderedItem("Bernard",4),
                                                 new OrderedItem("Peperoni",2));

        Mockito.when(repository.findMenuItemByName(Mockito.any()))
                .thenReturn(itemExpectedBeer,itemExpectedPizza);

        Bill bill = service.processOrder(orderedItems);
        BigDecimal beerSumActual = bill.getBillItems().stream()
                .filter(b->b.getItemName().equals(MenuUtils.BEER_NAME))
                .findFirst()
                .get()
                .getSum();
        BigDecimal pizzaSumActual = bill.getBillItems().stream()
                .filter(b->b.getItemName().equals(MenuUtils.PIZZA_NAME))
                .findFirst()
                .get()
                .getSum();
        assertEquals(MenuUtils.BEER_SUM_EXPECTED,beerSumActual);
        assertEquals(MenuUtils.PIZZA_SUM_EXPECTED,pizzaSumActual);
        assertEquals(MenuUtils.TOTAL_SUM_EXPECTED,bill.getTotalSum());
    }

    @Test
    public void findMenuItemByNameTest_success(){
        MenuItem itemExpected = new MenuItem(null,MenuUtils.PIZZA_NAME,new BigDecimal("16.50"), MenuItemType.PIZZA);
        OrderedItem orderedItem = new OrderedItem(MenuUtils.PIZZA_NAME,2);

        Mockito.when(repository.findMenuItemByName(Mockito.any()))
                .thenReturn(itemExpected);

        MenuItem itemResult = service.findMenuItemByName(orderedItem);
        assertNotNull(itemResult);
        assertEquals(itemExpected.getName(),itemResult.getName());
    }

    @Test
    public void findMenuItemByNameTest_null(){
        OrderedItem orderedItem = new OrderedItem(MenuUtils.PIZZA_NAME,2);

        Mockito.when(repository.findMenuItemByName(Mockito.any()))
                .thenReturn(null);
        MenuItemException thrown = assertThrows(MenuItemException.class,()->service.findMenuItemByName(orderedItem));
        log.error(thrown);
    }
}
