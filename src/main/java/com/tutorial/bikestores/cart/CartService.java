package com.tutorial.bikestores.cart;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    public List<CartIndexDTO> showCart(Integer custId){
        return cartRepository.getCartByCustomerId(custId);
    }
    public void deleteCart(Integer cartId){
        cartRepository.deleteById(cartId);
    }
}
