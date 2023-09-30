package com.example.Swiggato.controller;

import com.example.Swiggato.dto.request.RestaurantRequestDto;
import com.example.Swiggato.dto.response.RestaurantResponseDto;
import com.example.Swiggato.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @PostMapping("/add")
    public ResponseEntity addRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){
        RestaurantResponseDto restaurantResponseDto=restaurantService.addRestaurant(restaurantRequestDto);
        return new ResponseEntity(restaurantResponseDto, HttpStatus.CREATED);

    }
}
