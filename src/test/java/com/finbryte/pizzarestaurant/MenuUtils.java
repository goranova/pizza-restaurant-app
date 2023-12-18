package com.finbryte.pizzarestaurant;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finbryte.pizzarestaurant.request.OrderedItem;
import com.finbryte.pizzarestaurant.response.Bill;
import com.finbryte.pizzarestaurant.response.BillItem;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.math.BigDecimal;
import java.util.List;

public class MenuUtils {

    private static Log log = LogFactory.getLog(MenuUtils.class);
    public static final BigDecimal BEER_SUM_EXPECTED = new BigDecimal("28.80");
    public static final BigDecimal PIZZA_SUM_EXPECTED = new BigDecimal("33.80");
    public static final BigDecimal TOTAL_SUM_EXPECTED = new BigDecimal("62.60");
    public static final String BEER_NAME = "BERNARD";
    public static final String PIZZA_NAME = "Peperoni";



    public static Bill createBill(){

        List<BillItem> billItems = List.of(
                new BillItem(1,"Margarita", new BigDecimal("12.80"),new BigDecimal("12.80")),
                new BillItem(2,"Bernard", new BigDecimal("7.89"),new BigDecimal("15.78")),
                new BillItem(1,"Krusovice", new BigDecimal("8.52"),new BigDecimal("8.52")),
                new BillItem(2,"Polo", new BigDecimal("17.49"),new BigDecimal("34.98")));
        BigDecimal total = new BigDecimal("72.08");
        return  Bill.builder()
                .billItems(billItems)
                .totalSum(total)
                .build();
    }


    public static String getOrderItemsJson(){

       List<OrderedItem> orderedItems = List.of(
               new OrderedItem("Margarita",1),
               new OrderedItem("Bernard",2),
               new OrderedItem("Krusovice",1),
               new OrderedItem("Polo", 2));


        ObjectMapper mapper = new ObjectMapper();
        String jsonMer = null;
        try {
            jsonMer = mapper.writeValueAsString(orderedItems);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return jsonMer;
    }
}
