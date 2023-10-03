package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.DeliveryPartnerRequest;
import com.example.Swiggato.model.DeliveryPartner;
import com.example.Swiggato.repository.DeliveryPartnerRepository;
import com.example.Swiggato.transformer.deliveryPartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerService {

    final DeliveryPartnerRepository deliveryPartnerRepository;
    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public String addDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest) {
        DeliveryPartner deliveryPartner= deliveryPartnerTransformer.deliveryPartnerRequestTodeliveryPartner(deliveryPartnerRequest);
        DeliveryPartner savedDeliveryPartner=deliveryPartnerRepository.save(deliveryPartner);
        return "saved succssfully";
    }
}
