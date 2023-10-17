package com.example.Swiggato.service;

import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.model.Restaurant;
import com.example.Swiggato.repository.FoodItemRepository;
import com.example.Swiggato.repository.MenuRepository;
import com.example.Swiggato.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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



    public List<String> cheapest5ItemsOfAResto(int id) {
        List<MenuItem> menuItemList=menuRepository.findAll();
        MenuItem menuItems=new MenuItem();
        List<MenuItem> menuItemList1 = List.of(menuItems);
        menuItems.(Comparator.comparing(MenuItem::getPrice));

        assertTrue(Arrays.toString(employees.toArray())
                .equals(sortedArrayString));

        }
    }
    public List<String> costliest5ItemsOfAResto(int id) {
        Optional<Restaurant> restaurant=restaurantRepository.findById(id);
        Restaurant restaurant1=restaurant.get();
        String a=restaurant1.getName();
        List<MenuItem> menuItemList=menuRepository.costliest5ItemsOfAResto(id);
        List<String> menus=new ArrayList<>();
        for (MenuItem menuItem:menuItemList){
            menus.add(menuItem.getDishName());
        }
        return menus;
    }
}
