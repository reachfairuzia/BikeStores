package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.cart.CartUpsertDTO;
import com.tutorial.bikestores.production.category.CategoryDbService;
import com.tutorial.bikestores.shared.DropdownDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService service;
    private final CategoryDbService categoryDbService;

    @ModelAttribute("categories")
    public List<DropdownDTO> getCategoryDropdown(){
        return service.getCategoryDropdown();
    }
    @ModelAttribute("brands")
    public List<DropdownDTO> getBrandDropdown(){
        return service.getBrandDropdown();
    }
    @ModelAttribute("signedIn")
    boolean signedInStatus(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !((Authentication) authentication).getPrincipal().equals("anonymousUser");
    }
    @GetMapping("/products")
    public ModelAndView showAllProduct(@RequestParam(defaultValue = "") String name,
                                       @RequestParam(defaultValue = "1") int pageNumber){
        ModelAndView mv = new ModelAndView("/products/products-index");
        mv.addObject("products", service.getAllProduct(name, pageNumber));
        mv.addObject("currentPage", pageNumber);
        mv.addObject("totalPages", service.getAllProduct(name, pageNumber).getTotalPages());
        mv.addObject("name", name);
        return mv;
    }

    @GetMapping("/products/new")
    public ModelAndView addProduct(){
        ModelAndView mv = new ModelAndView("/products/upsert-product");
        mv.addObject("product", new ProductUpsertDTO());
        return mv;
    }
    @PostMapping("/products/new")
    public ModelAndView addProduct(ProductUpsertDTO productUpsertDTO, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return new ModelAndView("/products/upsert-product");
//        }
        service.save(productUpsertDTO);
        return new ModelAndView("redirect:/products");
    }
    @GetMapping("/products/{id}/edit")
    public ModelAndView editProduct(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("/products/upsert-product");
        mv.addObject("product", service.getProductById(id));
        return mv;
    }
    @PostMapping("/products/{id}/edit")
    public ModelAndView editProduct(ProductUpsertDTO productUpsertDTO, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return new ModelAndView("/products/upsert-product");
//        }
        service.save(productUpsertDTO);
        return new ModelAndView("redirect:/products");
    }

    @GetMapping("/products/{id}/remove")
    public ModelAndView remove(@PathVariable Integer id){
        return new ModelAndView();
    }

    @GetMapping("/catalog")
    public ModelAndView catalog(){
        ModelAndView mv = new ModelAndView("/products/catalog");
        mv.addObject("products", service.getAllProduct());
        return mv;
    }
    @GetMapping("/catalog-details/{id}")
    public ModelAndView catalogDetails(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("/products/catalog-details");
        mv.addObject("products", service.getSingle(id));
        mv.addObject("cart", new CartUpsertDTO());
        mv.addObject("storeDropdown", service.getStoreDropdown(id));
        return mv;
    }

}
