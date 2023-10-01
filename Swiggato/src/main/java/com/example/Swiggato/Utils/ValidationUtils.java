package com.example.Swiggato.Utils;

import com.example.Swiggato.exception.RestaurantNotFoundException;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ValidationUtils {

    final RestaurantRepository restaurantRepository;
    @Autowired
    public ValidationUtils(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public  boolean validationRestaurant(int id){
        Optional<Restaurant> restaurantOptional=restaurantRepository.findById(id);
        if(restaurantOptional.isEmpty()){
            return false;
        }
        return true;

        //or
        //return restaurantOptional.isPresent();
    }

}
