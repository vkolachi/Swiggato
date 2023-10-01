package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.exception.CustomerNotFoundException;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.Customer;
import com.example.Swiggato.repository.CustomerRepository;
import com.example.Swiggato.transformer.customerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerService   {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequestDto) {
        Customer customer= customerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        //allocate a cart
        Cart cart=Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        //
       Customer savedCustomer= customerRepository.save(customer);
     return customerTransformer.CustomerToCustomerResponseDto(savedCustomer);
    }


    public CustomerResponse findCustomerByMobile(String mobile) {
        Customer customer=customerRepository.findByMobileNo(mobile);
        if(customer==null){
            throw new CustomerNotFoundException("invalid mobile");
        }
        return customerTransformer.CustomerToCustomerResponseDto(customer);
    }
}
