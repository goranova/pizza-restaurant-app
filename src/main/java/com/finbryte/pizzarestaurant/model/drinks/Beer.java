package com.finbryte.pizzarestaurant.model.drinks;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BEER")
public class Beer extends Drinks {
}
