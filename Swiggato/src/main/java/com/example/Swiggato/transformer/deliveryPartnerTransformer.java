package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.DeliveryPartnerRequest;
import com.example.Swiggato.model.DeliveryPartner;

import java.util.ArrayList;

public class deliveryPartnerTransformer {
    public static DeliveryPartner deliveryPartnerRequestTodeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest){
        return DeliveryPartner.builder()
                .name(deliveryPartnerRequest.getName())
                .mobileNo(deliveryPartnerRequest.getMobileNo())
                .gender(deliveryPartnerRequest.getGender())
                .orders(new ArrayList<>())
                .build();
    }
}
