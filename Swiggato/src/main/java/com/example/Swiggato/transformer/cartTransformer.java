package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.response.CartResponse;
import com.example.Swiggato.dto.response.CartStatusResponse;
import com.example.Swiggato.dto.response.FoodResponse;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.FoodItem;
import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class cartTransformer {
    public static CartResponse cartToCartResponse(Cart cart){
        return CartResponse.builder()
                .cartTotal((int) cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }

    public static CartStatusResponse CartToCartStatusResponse(Cart cart, MenuItem menuItem){
        List<FoodResponse> foodResponseList=new ArrayList<>();
        int cartTotal=0;
        for(FoodItem foood:cart.getFoodItems()){
            cartTotal += (int) (foood.getRequiredQuantaty()*foood.getMenuItem().getPrice());

        }
        cart.setCartTotal(cartTotal);



        for(FoodItem foood:cart.getFoodItems()){
            FoodResponse foodResponse= FoodResponse.builder()
                    .dishName(foood.getMenuItem().getDishName())
                    .price(foood.getMenuItem().getPrice())
                    .category(foood.getMenuItem().getCategory())
                    .veg(foood.getMenuItem().isVeg())
                    .quantityAdded(foood.getRequiredQuantaty())
                    .build();

            foodResponseList.add(foodResponse);
        }
        return CartStatusResponse.builder()
                .customerName(cart.getCustomer().getName())
                .customeraddress(cart.getCustomer().getAddress())
                .customerMobileNo(cart.getCustomer().getMobileNo())
                .foodList(foodResponseList)
                .restaurantname(menuItem.getRestaurant().getName())
                .cartTotal(cartTotal)
                .build();
    }

}
