package com.example.Swiggato.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartStatusResponse {
    String customerName;

    String customeraddress;

    String customerMobileNo;

    int cartTotal;

    List<FoodResponse> foodList;

    String restaurantname;
}
