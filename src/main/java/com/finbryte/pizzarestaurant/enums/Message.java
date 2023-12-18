package com.finbryte.pizzarestaurant.enums;

import java.util.Locale;
import java.util.ResourceBundle;


public enum Message {

    MISSING_MENU_ITEM("missing.menu.item"),
    UNEXPECTED_EXCEPTION("unexpected.exception");

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages",
            Locale.ENGLISH);

    private String name;
    Message(String name){
        this.name=name;
    }
    public String getName(){
        return resourceBundle.getString(name);
    }
}
