package com.example.Swiggato.transformer;

import com.example.Swiggato.dto.request.CustomerRequestDto;
import com.example.Swiggato.dto.response.CartResponse;
import com.example.Swiggato.dto.response.CustomerResponseDto;
import com.example.Swiggato.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .email(customerRequestDto.getEmail())
                .address(customerRequestDto.getAddress())
                .mobileNo(customerRequestDto.getEmail())
                .gender(customerRequestDto.getGender())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){
        CartResponse cartResponse=cartTransformer.cartToCartResponse(customer.getCart());
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .mobileNo(customer.getMobileNo())
                .address(customer.getAddress())
                .cart(cartResponse)
                .build();

    }
}
