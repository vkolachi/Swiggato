package com.example.Swiggato.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {
    int cartTotal;

    List<MenuResponse> foodItems;
}
