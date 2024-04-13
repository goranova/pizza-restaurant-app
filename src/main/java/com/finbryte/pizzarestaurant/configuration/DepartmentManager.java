package com.finbryte.pizzarestaurant.configuration;

import org.springframework.stereotype.Component;

@Component
public class DepartmentManager implements Manager {
    @Override
    public String getManagerName() {
        return "Department Manager";
    }
}
