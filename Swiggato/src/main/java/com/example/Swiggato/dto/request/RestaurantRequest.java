package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.RestarauntCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequest {
    String name;

    String location;

    RestarauntCategory restrauntCategory;

    String contactNumber;

    boolean opened;

}
