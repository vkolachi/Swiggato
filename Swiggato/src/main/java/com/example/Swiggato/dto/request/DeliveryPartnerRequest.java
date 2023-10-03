package com.example.Swiggato.dto.request;

import com.example.Swiggato.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeliveryPartnerRequest {
    String name;

    String mobileNo;

    Gender gender;
}
