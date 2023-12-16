package com.finbryte.pizzarestaurant.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderedItem {

   private String  itemName;
   private Integer quantity;


}
