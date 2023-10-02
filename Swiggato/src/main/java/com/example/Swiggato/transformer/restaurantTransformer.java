package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.RestaurantRequest;
import com.example.Swiggato.dto.response.MenuResponse;

import com.example.Swiggato.dto.response.RestaurantResponse;
import com.example.Swiggato.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class restaurantTransformer {
    public static Restaurant RestaurantRequestDtoToRestaurant(RestaurantRequest restaurantRequestDto){
        return Restaurant.builder()
                .name(restaurantRequestDto.getName())
                .location(restaurantRequestDto.getLocation())
                .restrauntCategory(restaurantRequestDto.getRestrauntCategory())
                .contactNumber(restaurantRequestDto.getContactNumber())
                .opened(true)
                .availableMenuItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static RestaurantResponse restaurantTorestaurantResponseDto(Restaurant restaurant){
        List<MenuResponse> menu=restaurant.getAvailableMenuItems()
                .stream()
                .map(menuItem -> FoodItemTransformer.FoodItemToFoodResponse(menuItem))
                .collect(Collectors.toList());

        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .contactNumber(restaurant.getContactNumber())
                .location(restaurant.getLocation())
                .opened(restaurant.isOpened())
                .menu(menu)
                .build();
    }
}

