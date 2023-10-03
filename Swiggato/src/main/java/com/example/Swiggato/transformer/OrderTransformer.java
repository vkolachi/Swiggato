package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.response.FoodResponse;
import com.example.Swiggato.dto.response.OrderResponse;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.FoodItem;
import com.example.Swiggato.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {

    public static OrderEntity prepareOrderEntity(Cart cart){
        return OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .orderTotal(cart.getCartTotal())
                .build();
    }
    public static OrderResponse OrderToOrderResponse(OrderEntity orderEntity){
        List<FoodResponse> foodResponseList=new ArrayList<>();
        for(FoodItem foood:orderEntity.getFoodItems()){
            FoodResponse foodResponse= FoodResponse.builder()
                    .dishName(foood.getMenuItem().getDishName())
                    .price(foood.getMenuItem().getPrice())
                    .category(foood.getMenuItem().getCategory())
                    .veg(foood.getMenuItem().isVeg())
                    .quantityAdded(foood.getRequiredQuantaty())
                    .build();

            foodResponseList.add(foodResponse);
        }
        return OrderResponse.builder()
                .orderId(orderEntity.getOrderId())
                .orderTotal(orderEntity.getOrderTotal())
                .orderTime(orderEntity.getOrderTime())
                .customerName(orderEntity.getCustomer().getName())
                .customerMobile(orderEntity.getCustomer().getMobileNo())
                .deliveryPartnerName(orderEntity.getDeliveryPartner().getName())
                .deliveryPartnerMobile(orderEntity.getDeliveryPartner().getMobileNo())
                .restaurantName(orderEntity.getRestaurant().getName())
                .foodResponses(foodResponseList)
                .build();

    }
}
