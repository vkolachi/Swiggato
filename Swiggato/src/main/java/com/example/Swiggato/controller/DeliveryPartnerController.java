package com.example.Swiggato.controller;

import com.example.Swiggato.dto.request.DeliveryPartnerRequest;
import com.example.Swiggato.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partner")
public class DeliveryPartnerController {
    final DeliveryPartnerService deliveryPartnerService;
    @Autowired
    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }
    @PostMapping("/add")
    public ResponseEntity addDeliveryPartner(@RequestBody DeliveryPartnerRequest deliveryPartnerRequest){
        String message=deliveryPartnerService.addDeliveryPartner(deliveryPartnerRequest);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }
    // give delivery partner with highest number of deliveries
    @GetMapping("/delPartnerWithHighOrders")
    public  ResponseEntity delPartnerWithHighOrders(){ //tt
        String s=deliveryPartnerService.delPartnerWithHighOrders();
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }

    // send an email to all the partners who have done less than 10 deliveries.
    @GetMapping("/delPartnerWithHighOrderslessthen10")
    public  ResponseEntity delPartnerWithHighOrderslessthen10(){
        String s=deliveryPartnerService.delPartnerWithHighOrderslessthen10();
        return new ResponseEntity<>(s,HttpStatus.CREATED);
    }


}
