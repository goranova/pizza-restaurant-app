package com.finbryte.pizzarestaurant;

import com.finbryte.pizzarestaurant.configuration.ConfigurationEx;
import com.finbryte.pizzarestaurant.configuration.Manager;
import com.finbryte.pizzarestaurant.configuration.ManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzaRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaRestaurantApplication.class, args);

	}

}
