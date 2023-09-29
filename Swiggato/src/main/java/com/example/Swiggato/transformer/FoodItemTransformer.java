package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.response.MenuResponse;

import java.awt.*;

public class FoodItemTransformer {

    public static MenuResponse FoodToFoodResponse(MenuItem menuItem){
        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .price(menuItem.getPrice())
                .category(menuItem.getCategory())
                .veg(menuItem.isVeg())
                .build();

    }
}
