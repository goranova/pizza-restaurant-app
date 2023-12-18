package com.finbryte.pizzarestaurant.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillItem {

    Integer quantity;
    String itemName;
    BigDecimal rate;
    BigDecimal sum;

}
