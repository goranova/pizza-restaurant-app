package com.finbryte.pizzarestaurant.repository;

import com.finbryte.pizzarestaurant.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {


    @Query("select item from MenuItem item " +
            "where item.name=:name ")
    MenuItem findMenuItemByName(@Param("name") String name);

}
