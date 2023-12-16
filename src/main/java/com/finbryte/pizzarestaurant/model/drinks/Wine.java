package com.finbryte.pizzarestaurant.model.drinks;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("WINE")
public class Wine extends Drinks {
}
