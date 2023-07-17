package com.tutorial.bikestores.transaction;

import com.tutorial.bikestores.cart.Cart;
import com.tutorial.bikestores.cart.CartRepository;
import com.tutorial.bikestores.cart.CartUpsertDTO;
import com.tutorial.bikestores.user.AccountRepository;
import com.tutorial.bikestores.user.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransactionService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final AccountService accountService;

    @Transactional
    public void addToCart(CartUpsertDTO cartUpsertDTO){
        Integer cusId = accountService.getCustomerId();
        Integer prodId = cartUpsertDTO.getProductId();
        Integer storeId = cartUpsertDTO.getStoreId();
        Integer cartId = cartRepository.getCartId(cusId, storeId, prodId);
//        BigDecimal price = cartUpsertDTO.getPrice().multiply(BigDecimal.valueOf(cartUpsertDTO.getQuantity()));
        if(cartId != null){
            cartUpsertDTO.setCartId(cartId);
            cartUpsertDTO.setQuantity(cartRepository.getQuantity(cartId) + cartUpsertDTO.getQuantity());
            cartUpsertDTO.setCustomerId(cusId);
            cartUpsertDTO.setChecked(true);
            cartRepository.save(modelMapper.map(cartUpsertDTO, Cart.class));
        }
        else{
            cartUpsertDTO.setChecked(true);
            cartUpsertDTO.setCustomerId(cusId);
            cartRepository.save(modelMapper.map(cartUpsertDTO, Cart.class));
        }
    }

}
