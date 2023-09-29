package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.RestaurantRequestDto;
import com.example.Swiggato.dto.response.RestaurantResponseDto;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repository.RestaurantRepository;
import com.example.Swiggato.transformer.restaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    public RestaurantResponseDto addRestaurant(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant= restaurantTransformer.RestaurantRequestDtoToRestaurant(restaurantRequestDto);

       Restaurant savedrestaurant= restaurantRepository.save(restaurant);

        return restaurantTransformer.restaurantTorestaurantResponseDto(savedrestaurant);
    }
}
