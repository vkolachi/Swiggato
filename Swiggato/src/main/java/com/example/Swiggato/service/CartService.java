package com.example.Swiggato.service;

import com.example.Swiggato.dto.request.FoodRequest;
import com.example.Swiggato.dto.response.CartStatusResponse;
import com.example.Swiggato.exception.CustomerNotFoundException;
import com.example.Swiggato.exception.MenuItemNotFoundExcetion;
import com.example.Swiggato.exception.RestorentClosedException;
import com.example.Swiggato.model.Cart;
import com.example.Swiggato.model.Customer;
import com.example.Swiggato.model.FoodItem;
import com.example.Swiggato.model.MenuItem;
import com.example.Swiggato.repository.CartRepository;
import com.example.Swiggato.repository.CustomerRepository;
import com.example.Swiggato.repository.FoodItemRepository;
import com.example.Swiggato.repository.MenuRepository;
import com.example.Swiggato.transformer.cartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    final CustomerRepository customerRepository;
    final MenuRepository menuRepository;

    final FoodItemRepository foodItemRepository;
    final CartRepository cartRepository;
    @Autowired
    public CartService(CustomerRepository customerRepository, MenuRepository menuRepository, FoodItemRepository foodItemRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.menuRepository = menuRepository;
        this.foodItemRepository = foodItemRepository;
        this.cartRepository = cartRepository;
    }

    public CartStatusResponse addFoodItemToCart(FoodRequest foodRequest) {
        Customer customer=customerRepository.findByMobileNo(foodRequest.getCustomerMobile());
        if(customer==null){
            throw new CustomerNotFoundException("customer doesnt exists");
        }

        Optional<MenuItem> menuItemOptional=menuRepository.findById(foodRequest.getMenuItemId());
         if(menuItemOptional.isEmpty())
             throw new MenuItemNotFoundExcetion("Item not availabel in menu ");
         MenuItem menuItem=menuItemOptional.get();
        if( !menuItem.isAvailable())
             throw new MenuItemNotFoundExcetion("dish not available or out of stock");
        if(!menuItem.getRestaurant().isOpened())
            throw new RestorentClosedException("restorent is closed");
        //ready to add item

        FoodItem foodItem=FoodItem.builder()
                .menuItem(menuItem)
                .cart(customer.getCart())
                .requiredQuantaty(foodRequest.getRequiredQuantity())
                .totalcost((int) (foodRequest.getRequiredQuantity()*menuItem.getPrice()))
                .build();


        Cart cart=customer.getCart();
        FoodItem savedFoodItem=foodItemRepository.save(foodItem);
        cart.getFoodItems().add(savedFoodItem);
        menuItem.getFoodItems().add(savedFoodItem);
        int cartTotal=0;
        for(FoodItem foood:cart.getFoodItems()){
            cartTotal += (int) (foood.getRequiredQuantaty()*foood.getMenuItem().getPrice());

        }
        cart.setCartTotal(cartTotal);
        //save
        Cart savedCart=cartRepository.save(cart);
        MenuItem savedMenuItem=menuRepository.save(menuItem);
        //prepare response

        return cartTransformer.CartToCartStatusResponse(cart,menuItem);



    }
}
