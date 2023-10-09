package com.example.Swiggato.service;

import com.example.Swiggato.Utils.ValidationUtils;
import com.example.Swiggato.dto.response.OrderResponse;
import com.example.Swiggato.exception.CartEmptyException;
import com.example.Swiggato.exception.CustomerNotFoundException;
import com.example.Swiggato.model.*;
import com.example.Swiggato.repository.CustomerRepository;
import com.example.Swiggato.repository.DeliveryPartnerRepository;
import com.example.Swiggato.repository.OrderRepository;
import com.example.Swiggato.repository.RestaurantRepository;
import com.example.Swiggato.transformer.OrderTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    final ValidationUtils validationUtils;
    final OrderRepository orderRepository;
    final CustomerRepository customerRepository;
    final RestaurantRepository restaurantRepository;

    final DeliveryPartnerRepository deliveryPartnerRepository;
    @Autowired
    public OrderService(ValidationUtils validationUtils, OrderRepository orderRepository, CustomerRepository customerRepository, RestaurantRepository restaurantRepository, DeliveryPartnerRepository deliveryPartnerRepository) {
        this.validationUtils = validationUtils;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.deliveryPartnerRepository = deliveryPartnerRepository;

    }

    public OrderResponse placeOrder(String customerMobile) {
        if (!validationUtils.validateCustomerByMobile(customerMobile)){
            throw new CustomerNotFoundException(" customer doent exists!!!!!");
        }
        Customer customer=customerRepository.findByMobileNo(customerMobile);

        Cart cart=customer.getCart();
        if(cart.getFoodItems().isEmpty())
            throw new CartEmptyException("cart is empty!!");

        DeliveryPartner partner=deliveryPartnerRepository.findRandomDeliveryPartner();
        Restaurant restaurant=cart.getFoodItems().get(0).getMenuItem().getRestaurant();
        //prepare
        OrderEntity order= OrderTransformer.prepareOrderEntity(cart);



        OrderEntity savedOrder=orderRepository.save(order);

        order.setCustomer(customer);
        order.setDeliveryPartner(partner);
        order.setRestaurant(restaurant);
        order.setFoodItems(cart.getFoodItems());

        customer.getOrders().add(savedOrder);
        partner.getOrders().add(savedOrder);
        restaurant.getOrders().add(savedOrder);

        for (FoodItem foodItem:cart.getFoodItems()){
            foodItem.setCart(null);
            foodItem.setOrderEntity(savedOrder);
        }
        clearCart(cart);

        customerRepository.save(customer);
        deliveryPartnerRepository.save(partner);
        restaurantRepository.save(restaurant);

        //prepare order response

    return OrderTransformer.OrderToOrderResponse(savedOrder);


    }
    private void clearCart(Cart cart){
        cart.setCartTotal(0);
        cart.setFoodItems(new ArrayList<>());
    }
}
