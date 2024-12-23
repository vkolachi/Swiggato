package com.example.Swiggato.service;

import com.example.Swiggato.Utils.ValidationUtils;
import com.example.Swiggato.dto.request.MenuRequest;
import com.example.Swiggato.dto.request.RestaurantRequest;
import com.example.Swiggato.dto.response.RestaurantResponse;
import com.example.Swiggato.exception.RestaurantNotFoundException;
import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repository.RestaurantRepository;
import com.example.Swiggato.transformer.MenuItemTransformer;
import com.example.Swiggato.transformer.restaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;
    final ValidationUtils validationUtils;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ValidationUtils validationUtils) {
        this.restaurantRepository = restaurantRepository;
        this.validationUtils = validationUtils;
    }

    //    @Autowired
//    RestaurantRepository restaurantRepository;
    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequestDto) {
        Restaurant restaurant= restaurantTransformer.RestaurantRequestDtoToRestaurant(restaurantRequestDto);

       Restaurant savedrestaurant= restaurantRepository.save(restaurant);

        return restaurantTransformer.restaurantTorestaurantResponseDto(savedrestaurant);
    }

    public String changeOpenedStatus(int id) {

        if(!validationUtils.validationRestaurant(id)){
            throw  new RestaurantNotFoundException("Restaurant not found");
        }
        Restaurant restaurant=restaurantRepository.findById(id).get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRepository.save(restaurant);
        if(restaurant.isOpened())
        {
            return "Restaurant is open";
        }
        else return "Restaurant is closed";

//        restaurant.setOpened(!restaurant.isOpened());
//       Restaurant savedRestaurant =restaurantRepository.save(restaurant);
//        return restaurantTransformer.restaurantTorestaurantResponseDto(savedRestaurant);

    }
    public RestaurantResponse addMenuItemtToRestaurant(MenuRequest menuRequest) {

        // check reataurant is valid or not
        if(!validationUtils.validationRestaurant(menuRequest.getRestaurantId())){
            throw  new RestaurantNotFoundException("Restaurant not found");
        }

        Restaurant restaurant = restaurantRepository.findById(menuRequest.getRestaurantId()).get();
        // make food entity
        MenuItem menuItem = MenuItemTransformer.MenuRequestToFoodItem(menuRequest);
        menuItem.setRestaurant(restaurant);

        restaurant.getAvailableMenuItems().add(menuItem);

        // save rest and food
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // prepare response
        return restaurantTransformer.restaurantTorestaurantResponseDto(savedRestaurant);

    }
}
