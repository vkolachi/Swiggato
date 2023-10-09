package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.CustomerRequest;
import com.example.Swiggato.dto.response.CustomerResponse;
import com.example.Swiggato.exception.CustomerNotFoundException;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.Customer;
import com.example.Swiggato.repository.CustomerRepository;
import com.example.Swiggato.transformer.customerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service

public class CustomerService   {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public CustomerResponse addCustomer(CustomerRequest customerRequestDto) {
        Customer customer= customerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        //allocate a cart
        Cart cart=Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        //  send an email

        String text = "Hi! " + customer.getName() + " You have successfully signed up\n" ;



        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("kven241@gmail.com");
        simpleMailMessage.setTo(customer.getEmail());
        simpleMailMessage.setSubject("Congrats!! Book Issued");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

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
