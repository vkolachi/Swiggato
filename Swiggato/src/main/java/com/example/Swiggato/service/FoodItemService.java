package com.example.Swiggato.service;

import com.example.Swiggato.dto.response.FoodResponse;
import com.example.Swiggato.model.FoodItem;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repository.FoodItemRepository;
import com.example.Swiggato.repository.RestaurantRepository;
import com.example.Swiggato.transformer.FoodItemTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.Swiggato.Enum.FoodCategory.STREET;

@Service
public class FoodItemService {
    final FoodItemRepository foodItemRepository;
    final RestaurantRepository restaurantRepository;

    public FoodItemService(FoodItemRepository foodItemRepository, RestaurantRepository restaurantRepository) {
        this.foodItemRepository = foodItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<String> foodsIn(String category) {
        List<String> foodsin=new ArrayList<>();
       List<FoodItem> foodItemList=foodItemRepository.findAll();
       for(FoodItem f:foodItemList){
           if(f.getCategory().toString().equals(category)){
               foodsin.add(f.getDishName());
           }
       }
       return foodsin;

    }

    public List<String> foodsInRestoWIthC(String resto, int rs) {
        List<String> foodsin=new ArrayList<>();
        List<FoodItem> foodItemList=foodItemRepository.findAll();
        for(FoodItem f:foodItemList){
//
            if(f.getCategory().toString().equals("STREET") && f.getRestaurant().getName().equals(resto) && f.getPrice()>rs  ){

                foodsin.add(f.getDishName());
            }
        }
        return foodsin;
    }

    public List<String> veg() {
        List<String> foodsin=new ArrayList<>();
        List<FoodItem> foodItemList=foodItemRepository.findAll();
        for(FoodItem f:foodItemList){
            if(f.isVeg()){
                foodsin.add(f.getDishName());
            }
        }
        return foodsin;
    }

    public List<String> nonveg() {
        List<String> foodsin=new ArrayList<>();
        List<FoodItem> foodItemList=foodItemRepository.findAll();
        for(FoodItem f:foodItemList){
            if(!f.isVeg()){
                foodsin.add(f.getDishName());
            }
        }
        return foodsin;
    }
}
