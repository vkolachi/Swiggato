package com.example.Swiggato.repository;

import com.example.Swiggato.model.DeliveryPartner;
import com.example.Swiggato.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem,Integer> {

    //in case of sql random is rand()
//    String top5="SELECT f FROM MenuItem f WHERE f.restaurant.id = :id ORDER BY f.price DESC";
//
//
//
//    @Query(value = top5)
//    List<MenuItem> cheapest5ItemsOfAResto(int id);
  //  @Query("SELECT mi FROM MenuItem mi WHERE mi.restaurant.id = :restaurantId ORDER BY mi.price DESC")
    // @Query(value = "SELECT f FROM menu_item f WHERE f.restaurant.id = :id ORDER BY f.price DESC", nativeQuery = true)

    @Query(value = "SELECT f FROM menu_item f WHERE f.restaurant.id = :id ORDER BY f.price DESC", nativeQuery = true)
    List<MenuItem> findTop5ByRestaurantIdOrderByPriceDesc(int id);

}
