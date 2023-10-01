package com.example.Swiggato.controller;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CustomerResponse;
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
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequestDto){
       CustomerResponse customerResponse1 =customerService.addCustomer(customerRequestDto);
       return new ResponseEntity(customerResponse1, HttpStatus.CREATED);
    }

    @GetMapping("/find/mobile/{mobile}")
    public ResponseEntity findCustomerBymobile(@PathVariable("mobile") String mobile){
        try {
            CustomerResponse customerResponse1 =customerService.findCustomerByMobile(mobile);
            return new ResponseEntity(customerResponse1, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }


    }

}
