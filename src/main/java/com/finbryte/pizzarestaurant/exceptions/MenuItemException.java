package com.finbryte.pizzarestaurant.exceptions;

public class MenuItemException extends RuntimeException {

    public  MenuItemException (String errorMessage, String... value){
        super(String.format(errorMessage, value));
    }

}
