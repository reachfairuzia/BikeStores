package com.tutorial.bikestores.sales.customer;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView index(@RequestParam(defaultValue = "") String name,
                              @RequestParam(defaultValue = "1") Integer pageNumber){
        ModelAndView mv = new ModelAndView("/customers/customers-index");
        mv.addObject("customers", customerService.getAll(name, pageNumber));
        mv.addObject("currentPage", pageNumber);
        mv.addObject("totalPages", customerService.getAll(name, pageNumber));
        mv.addObject("name", name);
        return mv;
    }

    @GetMapping("/customers/{id}/edit")
    public ModelAndView edit(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("/customers/upsert-customers");
        mv.addObject("customers", customerService.getSingle(id));
        return mv;
    }
    @PostMapping("/customers/{id}/edit")
    public ModelAndView edit(@Valid @ModelAttribute("customers") CustomerDTO customerDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("/customers/upsert-customers");
        }
        customerService.save(customerDTO);
        return new ModelAndView("redirect:/customers");
    }
    @GetMapping("/customers/new")
    public ModelAndView add(){
        ModelAndView mv = new ModelAndView("/customers/upsert-customers");
        mv.addObject("customers", new CustomerUpsertDTO());
        return mv;
    }
    @PostMapping("/customers/new")
    public ModelAndView add(@Valid @ModelAttribute("customers") CustomerDTO customerDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ModelAndView("/customers/upsert-customers");
        }
        customerService.save(customerDTO);
        return new ModelAndView("redirect:/customers");
    }
}
