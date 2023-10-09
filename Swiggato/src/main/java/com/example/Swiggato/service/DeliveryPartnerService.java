package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.DeliveryPartnerRequest;
import com.example.Swiggato.model.DeliveryPartner;
import com.example.Swiggato.repository.DeliveryPartnerRepository;
import com.example.Swiggato.transformer.deliveryPartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPartnerService {

    final DeliveryPartnerRepository deliveryPartnerRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepository deliveryPartnerRepository) {
        this.deliveryPartnerRepository = deliveryPartnerRepository;
    }

    public String addDeliveryPartner(DeliveryPartnerRequest deliveryPartnerRequest) {
        DeliveryPartner deliveryPartner= deliveryPartnerTransformer.deliveryPartnerRequestTodeliveryPartner(deliveryPartnerRequest);
        DeliveryPartner savedDeliveryPartner=deliveryPartnerRepository.save(deliveryPartner);
        return "saved succssfully";
    }

    public String delPartnerWithHighOrders() {
        List<DeliveryPartner> deliveryPartners=deliveryPartnerRepository.findAll();
        int max=0;
        DeliveryPartner deliveryPartner1=new DeliveryPartner();
        for(DeliveryPartner deliveryPartner:deliveryPartners){
            if(max<deliveryPartner.getOrders().size()){
                deliveryPartner1=deliveryPartner;
                max=deliveryPartner.getOrders().size();
            }
        }
        return deliveryPartner1.getName();
    }

    public String delPartnerWithHighOrderslessthen10() {
        List<DeliveryPartner> deliveryPartners=deliveryPartnerRepository.findAll();

        DeliveryPartner deliveryPartner1=new DeliveryPartner();
        for(DeliveryPartner deliveryPartner:deliveryPartners){
            if(10>deliveryPartner.getOrders().size()) {


                String text = "Hi! " + deliveryPartner.getName() + " Please deliver sufficient orders \n  your current orders are" + deliveryPartner.getOrders().size() +
                        "please deliver atleast " + (10 - (deliveryPartner.getOrders().size())) + "thank you partner for service with SWIGGATO";


                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom("kven241@gmail.com");
                simpleMailMessage.setTo("vkolachi@gmail.com");
                simpleMailMessage.setSubject("WARNING!!!!");
                simpleMailMessage.setText(text);

                javaMailSender.send(simpleMailMessage);
            }}
        return "Mail sent successfully";

    }
}
