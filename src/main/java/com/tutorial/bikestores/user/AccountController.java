package com.tutorial.bikestores.user;

import com.tutorial.bikestores.sales.customer.CustomerUpsertDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class AccountController {
    private final AccountService service;
    @GetMapping("/login")
    public String login(){
        return "/authentication/login";
    }
    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mv = new ModelAndView("/authentication/signup");
        mv.addObject("account", new CustomerUpsertDTO());
        return mv;
    }
    @PostMapping("/signup")
    public ModelAndView signup(AccountRegisterDTO accountRegisterDTO){
        service.save(accountRegisterDTO);
        ModelAndView mv = new ModelAndView("redirect:/login");
        return mv;
    }
    @ModelAttribute("signedIn")
    boolean signedInStatus(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !((Authentication) authentication).getPrincipal().equals("anonymousUser");
    }
}
