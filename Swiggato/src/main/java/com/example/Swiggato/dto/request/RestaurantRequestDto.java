package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.RestarauntCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequestDto {
    String name;

    String location;

    RestarauntCategory restrauntCategory;

    String contactNumber;

    boolean opened;

}
