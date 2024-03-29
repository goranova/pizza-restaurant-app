package com.finbryte.pizzarestaurant.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Bill {

    private List<BillItem> billItems;
    private BigDecimal totalSum;
}
