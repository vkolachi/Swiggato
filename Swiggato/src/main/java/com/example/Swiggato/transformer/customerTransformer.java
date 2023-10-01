package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CartResponse;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.model.Customer;

public class customerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequest customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .email(customerRequestDto.getEmail())
                .address(customerRequestDto.getAddress())
                .mobileNo(customerRequestDto.getMobileNo())
                .gender(customerRequestDto.getGender())
                .build();
    }

    public static CustomerResponse CustomerToCustomerResponseDto(Customer customer){
        CartResponse cartResponse=cartTransformer.cartToCartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .mobileNo(customer.getMobileNo())
                .address(customer.getAddress())
                .cart(cartResponse)
                .build();

    }
}
