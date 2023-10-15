package com.example.Swiggato.repository;

import com.example.Swiggato.model.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner,Integer> {
    String findRandomPartner="select p from DeliveryPartner p order by random() LIMIT 1";
    //in case of sql random is rand()


    @Query(value = findRandomPartner)
    DeliveryPartner findRandomDeliveryPartner();
}
