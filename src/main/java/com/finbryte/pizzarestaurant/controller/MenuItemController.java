package com.finbryte.pizzarestaurant.controller;

import com.finbryte.pizzarestaurant.request.OrderedItem;
import com.finbryte.pizzarestaurant.response.Bill;
import com.finbryte.pizzarestaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    MenuItemService service;

    @PostMapping("/order")
    public ResponseEntity<Bill> orderItems(@RequestBody List<OrderedItem> orderedItems) {
        Bill bill = service.processOrder(orderedItems);
        return ResponseEntity.status(HttpStatus.OK).body(bill);
    }
}
