package com.finbryte.pizzarestaurant.service;

import com.finbryte.pizzarestaurant.enums.Message;
import com.finbryte.pizzarestaurant.exceptions.MenuItemException;
import com.finbryte.pizzarestaurant.response.Bill;
import com.finbryte.pizzarestaurant.response.BillItem;
import com.finbryte.pizzarestaurant.model.MenuItem;
import com.finbryte.pizzarestaurant.request.OrderedItem;
import com.finbryte.pizzarestaurant.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    private MenuItemRepository itemRepo;

    public Bill processOrder(List<OrderedItem> orderedItems){
        List<BillItem> billItems = new ArrayList<>();

        for(OrderedItem orderedItem: orderedItems){

            MenuItem menuItem = findMenuItemByName(orderedItem);
            BigDecimal sum = menuItem.getPrice().multiply(BigDecimal.valueOf(orderedItem.getQuantity()));
            BillItem billItem = new BillItem( orderedItem.getQuantity(), menuItem.getName(),
                    menuItem.getPrice(),sum );
            billItems.add(billItem);
        }
        return generateBill(billItems);
    }

    public MenuItem findMenuItemByName(OrderedItem orderedItem){

        MenuItem menuItem = itemRepo.findMenuItemByName(orderedItem.getItemName());
        if(menuItem==null){
            throw new MenuItemException(Message.MISSING_MENU_ITEM.getName(), orderedItem.getItemName());
        }
        return menuItem;
    }

    private Bill generateBill(List<BillItem> billItems){

        BigDecimal totalSum = billItems.stream().map(BillItem::getSum)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        return Bill.builder()
                .billItems(billItems)
                .totalSum(totalSum).build();
    }
}
