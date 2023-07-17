package com.tutorial.bikestores.transaction;

import com.tutorial.bikestores.cart.CartUpsertDTO;
import com.tutorial.bikestores.sales.customer.CustomerUpsertDTO;
import com.tutorial.bikestores.user.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class TransactionController {
    private final TransactionService service;
    private final AccountService accountService;

    @PostMapping("/addToCart")
    public ModelAndView addToCart(CartUpsertDTO cartUpsertDTO){
        service.addToCart(cartUpsertDTO);
        ModelAndView mv = new ModelAndView("redirect:/catalog");
        return mv;
    }


}
