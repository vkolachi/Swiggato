package com.example.Swiggato.controller;

import com.example.Swiggato.dto.request.CustomerRequestDto;
import com.example.Swiggato.dto.response.CustomerResponseDto;
import com.example.Swiggato.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService; //field injection

    //constructor injection
//    final  CustomerService customerService;
//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }    //

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
       CustomerResponseDto customerResponseDto1=customerService.addCustomer(customerRequestDto);
       return new ResponseEntity(customerResponseDto1, HttpStatus.CREATED);
    }

}
