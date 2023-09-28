package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.CustomerRequestDto;
import com.example.Swiggato.dto.response.CustomerResponseDto;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.Customer;
import com.example.Swiggato.repository.CustomerRepository;
import com.example.Swiggato.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService   {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer= CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        //allocate a cart
        Cart cart=Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        //
       Customer savedCustomer= customerRepository.save(customer);
     return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);
    }
}
