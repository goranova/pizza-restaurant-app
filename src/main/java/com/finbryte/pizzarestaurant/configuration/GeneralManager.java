package com.finbryte.pizzarestaurant.configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GeneralManager  implements Manager {
    @Override
    public String getManagerName() {
        return "General Manager";
    }
}
