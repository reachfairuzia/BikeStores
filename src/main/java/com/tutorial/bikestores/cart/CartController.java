package com.tutorial.bikestores.cart;

import com.tutorial.bikestores.user.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class CartController {
    private final AccountService accountService;
    private final CartRepository cartRepository;
    private final CartService cartService;

    @GetMapping("/cart")
    public ModelAndView showCart(){
        ModelAndView mv = new ModelAndView("/cart/cart-index");
        mv.addObject("carts", cartRepository.getCartByCustomerId(accountService.getCustomerId()));
        return mv;
    }
    @GetMapping("/delete/{cartId}")
    public ModelAndView deleteCart(@PathVariable("cartId") Integer cartId){
        cartService.deleteCart(cartId);
        return new ModelAndView("redirect:/cart");
    }
}
