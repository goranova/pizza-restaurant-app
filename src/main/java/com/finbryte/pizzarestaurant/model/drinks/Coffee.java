package com.finbryte.pizzarestaurant.model.drinks;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COFFEE")
public class Coffee extends Drinks {
}
