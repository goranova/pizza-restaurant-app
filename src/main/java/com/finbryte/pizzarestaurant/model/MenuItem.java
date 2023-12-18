package com.finbryte.pizzarestaurant.model;

import com.finbryte.pizzarestaurant.enums.MenuItemType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Table(name="menu_item", schema = "pizza")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuItem {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long identifier;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name="TYPE", insertable = false, updatable = false)
    private MenuItemType type;
}
