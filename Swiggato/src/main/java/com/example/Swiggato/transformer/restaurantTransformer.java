package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.RestaurantRequestDto;
import com.example.Swiggato.dto.response.FoodResponse;

import com.example.Swiggato.dto.response.RestaurantResponseDto;
import com.example.Swiggato.model.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class restaurantTransformer {
    public static Restaurant RestaurantRequestDtoToRestaurant(RestaurantRequestDto restaurantRequestDto){
        return Restaurant.builder()
                .name(restaurantRequestDto.getName())
                .location(restaurantRequestDto.getLocation())
                .restrauntCategory(restaurantRequestDto.getRestrauntCategory())
                .contactNumber(restaurantRequestDto.getContactNumber())
                .opened(true)
                .build();
    }

    public static RestaurantResponseDto restaurantTorestaurantResponseDto(Restaurant restaurant){
//        List<FoodResponse> menu=restaurant.getAvailableFoodItems()
//                .stream()
//                .map(menuItem -> FoodItemTransformer.FoodToFoodResponse(menuItem))
//                .collect(Collectors.toList());

        return RestaurantResponseDto.builder()
                .name(restaurant.getName())
                .contactNumber(restaurant.getContactNumber())
                .location(restaurant.getLocation())
                .opened(restaurant.isOpened())
                .menu(null)
                .build();
    }
}

