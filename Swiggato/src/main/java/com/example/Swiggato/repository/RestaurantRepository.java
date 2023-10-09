package com.example.Swiggato.repository;

import com.example.Swiggato.model.DeliveryPartner;
import com.example.Swiggato.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
    String findRandomPartner="select p from DeliveryPartner p order by random() LIMIT 1";

    //in case of srl random is rand()


    @Query(value = findRandomPartner)
    List<String> cheapest5ItemsOfAResto(int id);
}
