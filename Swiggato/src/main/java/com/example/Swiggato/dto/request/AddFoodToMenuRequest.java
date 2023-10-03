package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddFoodToMenuRequest {

    int restaurantId;

    String dishName;

    double price;


    FoodCategory category;

    boolean veg;

    boolean available;
}
