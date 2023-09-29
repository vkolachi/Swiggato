package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.RestaurantRequestDto;
import com.example.Swiggato.model.Restaurant;

public class restaurantTransformer {
    public Restaurant RestaurantRequestDtoToRestaurant(RestaurantRequestDto restaurantRequestDto){
        return Restaurant.builder()
                .name(restaurantRequestDto.getName())
                .location(restaurantRequestDto.getLocation())
                .restrauntCategory(restaurantRequestDto.getRestrauntCategory())
                .contactNumber(restaurantRequestDto.getContactNumber())
                .opened(true)
                .build();
    }}

