package com.finbryte.pizzarestaurant.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PIZZA")
public class Pizza extends MenuItem {


}
