package com.finbryte.pizzarestaurant.model.drinks;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOFT_DRINKS")
public class SoftDrinks extends Drinks{
}
