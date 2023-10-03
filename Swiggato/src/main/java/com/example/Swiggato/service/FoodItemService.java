package com.example.Swiggato.service;

import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.repository.FoodItemRepository;
import com.example.Swiggato.repository.MenuRepository;
import com.example.Swiggato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodItemService {
    final FoodItemRepository foodItemRepository;
    final RestaurantRepository restaurantRepository;
    final MenuRepository menuRepository;
    @Autowired
    public FoodItemService(FoodItemRepository foodItemRepository, RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.foodItemRepository = foodItemRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    public List<String> foodsIn(String category) {
        List<String> foodsin=new ArrayList<>();
       List<MenuItem> menuItemList =menuRepository.findAll();
       for(MenuItem f: menuItemList){
           if(f.getCategory().toString().equals(category)){
               foodsin.add(f.getDishName());
           }
       }
       return foodsin;

    }

    public List<String> foodsInRestoWIthC(String resto, int rs) {
        List<String> foodsin=new ArrayList<>();
        List<MenuItem> menuItemList =menuRepository.findAll();
        for(MenuItem f: menuItemList){
//
            if(f.getCategory().toString().equals("STREET") && f.getRestaurant().getName().equals(resto) && f.getPrice()>rs  ){

                foodsin.add(f.getDishName());
            }
        }
        return foodsin;
    }

    public List<String> veg() {
        List<String> foodsin=new ArrayList<>();
        List<MenuItem> menuItemList =menuRepository.findAll();
        for(MenuItem f: menuItemList){
            if(f.isVeg()){
                foodsin.add(f.getDishName());
            }
        }
        return foodsin;
    }

    public List<String> nonveg() {
        List<String> foodsin=new ArrayList<>();
        List<MenuItem> menuItemList =menuRepository.findAll();
        for(MenuItem f: menuItemList){
            if(!f.isVeg()){
                foodsin.add(f.getDishName());
            }
        }
        return foodsin;
    }
}
