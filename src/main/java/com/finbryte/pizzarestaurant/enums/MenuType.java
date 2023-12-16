package com.finbryte.pizzarestaurant.enums;

public enum MenuType {
    BEER("BEER"),
    WINE("WINE"),
    COFFEE("COFFEE"),
    SOFT_DRINKS("SOFT_DRINKS"),
    PIZZA("PIZZA");

    private String name;

    MenuType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
