package com.example.Swiggato.Utils;

import com.example.Swiggato.model.Customer;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repository.CustomerRepository;
import com.example.Swiggato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class ValidationUtils {

    final RestaurantRepository restaurantRepository;
    final CustomerRepository customerRepository;
    @Autowired
    public ValidationUtils(RestaurantRepository restaurantRepository, CustomerRepository customerRepository) {
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
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
    public boolean validateCustomerByMobile(String mobileNo){
        Customer customerOptional=customerRepository.findByMobileNo(mobileNo);
        if(customerOptional==null)
            return false;
        return true;
    }

}
