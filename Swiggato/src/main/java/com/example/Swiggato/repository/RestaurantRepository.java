package com.example.Swiggato.repository;

import com.example.Swiggato.model.DeliveryPartner;
import com.example.Swiggato.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
//    String findRandomPartner="select name from restaurant e  order by e.price desc limit 5";
////    String findRandomPartner="select * from restaurant.MenuItem e where e.first_name={FIRST_NAME} limit 3";
////    select name from restaurant e  order by e.price desc limit 5
//
//    //in case of srl random is rand()
//
//
//    @Query(value = findRandomPartner)
//    List<String> cheapest5ItemsOfAResto(int id);

}
