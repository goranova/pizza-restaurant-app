package com.finbryte.pizzarestaurant.enums;

public enum MenuItemType {
    BEER("BEER"),
    WINE("WINE"),
    COFFEE("COFFEE"),
    SOFT_DRINKS("SOFT_DRINKS"),
    PIZZA("PIZZA");

    private String name;

    MenuItemType(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
