package com.example.Swiggato.controller;

import com.example.Swiggato.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuItemController {
      final FoodItemService foodItemService;
    @Autowired
    public MenuItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    // get all foods of a particualr category
    @GetMapping("/foodsIn")
    public ResponseEntity foodsIn(@RequestParam("category") String category){
        List<String> foodResponseList=foodItemService.foodsIn(category);
        return new ResponseEntity<>(foodResponseList, HttpStatus.CREATED);
    }

    // get all MAIN_COURSE items with price above x rupees from a particular restaurant.
    @GetMapping("/foodsInRestoWIthC")
    public ResponseEntity foodsInRestoWIthCost(@RequestParam("resto") String resto,@RequestParam("rs")int rs){
        List<String> foodResponseList=foodItemService.foodsInRestoWIthC(resto,rs);
        return new ResponseEntity<>(foodResponseList, HttpStatus.CREATED);
    }
    // get all veg foods of a restaurant
    @GetMapping("/veg")
    public ResponseEntity veg(){
        List<String> foodResponseList=foodItemService.veg();
        return new ResponseEntity<>(foodResponseList, HttpStatus.CREATED);
    }


    // get all non veg foods of a restaurant
    @GetMapping("/nonveg")
    public ResponseEntity nonveg(){
        List<String> foodResponseList=foodItemService.nonveg();
        return new ResponseEntity<>(foodResponseList, HttpStatus.CREATED);
    }

    // Get cheapest 5 food items of a partiuclar restaurant

    // Get costliest 5 food items of a partiuclar restaurant

    // Get costliest 5 food items of a partiuclar catgeory -> name fo dish and rest which serves that dish
}
