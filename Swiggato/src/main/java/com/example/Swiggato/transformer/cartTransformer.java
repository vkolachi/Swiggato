package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.response.CartResponse;
import com.example.Swiggato.model.Cart;

import java.util.ArrayList;

public class cartTransformer {
    public static CartResponse cartToCartResponse(Cart cart){
        return CartResponse.builder()
                .cartTotal(0)
                .foodItems(new ArrayList<>())
                .build();
    }

}
