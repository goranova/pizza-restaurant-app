package com.finbryte.pizzarestaurant.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BillItem {

    Integer quantity;
    String item;
    BigDecimal price;
    BigDecimal sum;

}
